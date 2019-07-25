package com.example.myspringdemo;

import com.example.myspringdemo.entity.Department;
import com.example.myspringdemo.repository.DepartmentRepository;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;


@SpringComponent
@UIScope
public class DepartmentEditor extends VerticalLayout implements KeyNotifier{

    private final DepartmentRepository repository;
    /**
     * The currently edited department
     */
    private Department department;

    /* Fields to edit properties in Department entity */
    TextField nameOfDepartment = new TextField("Name of Department");

    /* Action buttons */
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Department> binder = new Binder<>(Department.class);
    //private BasicMenuUI.ChangeHandler changeHandler;
    private ChangeHandler changeHandler;

    @Autowired
    public DepartmentEditor(DepartmentRepository repository){
        this.repository = repository;

        add(nameOfDepartment, actions);

        // bind using naming convention
        binder.bindInstanceFields(this);

        // Configure and style components
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editDepartment(department));
        setVisible(false);
    }

    public interface ChangeHandler{
        void onChange();
    }

    private void delete() {
        repository.delete(department);
        changeHandler.onChange();
    }

    private void save() {
        repository.save(department);
        changeHandler.onChange();
    }

    void editDepartment(Department d) {
        if (d == null){
            setVisible(false);
            return;
        }
        final boolean persisted = d.getId() != null;
        if (persisted){
            // Find fresh entity for editing
            department = repository.findById(d.getId()).get();
        }
        else {
            department = d;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(department);
        setVisible(true);
        // Focus first name initially
        nameOfDepartment.focus();
    }

    public void setChangeHandler(ChangeHandler h){
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }
}
