package com.example.myspringdemo;

import com.example.myspringdemo.entity.Department;
import com.example.myspringdemo.repository.DepartmentRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;


@Route
public class MainView extends VerticalLayout {

    private final DepartmentRepository repo;
    private final DepartmentEditor editor;
    final Grid<Department> grid;
    final TextField filter;
    private final Button addNewBtn;


    public MainView(DepartmentRepository repo, DepartmentEditor editor){
        //add(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid<>(Department.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New department", VaadinIcon.PLUS.create());

        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, editor);

        //add(grid);
        //listDepartments(e.getValue());

        grid.setHeight("300px");
        grid.setColumns("id", "nameOfDepartment");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listDepartments(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editDepartment(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> editor.editDepartment(new Department("", "")));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listDepartments(filter.getValue());
        });

        // Initialize listing
        listDepartments(null);
    }

    private void listDepartments(String filterText) {
        //Grid<HashMap<Department, String>> grid = new Grid<>();
        TextField filter = new TextField();
        filter.setPlaceholder("Filter by last name");
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listDepartments(e.getValue()));
        add(filter, grid);

        if (StringUtils.isEmpty(filterText)){
            grid.setItems(repo.findAll());
        }
        else{
            grid.setItems(repo.findByNameOfDepartmentStartsWithIgnoreCase(filterText));
        }

    }
/*
    // tag::listDepartment[]
    void listDepartment(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems((Department) repo.findAll());
        }
        else {
            grid.setItems(repo.findByNameOfDepartmentStartsWithIgnoreCase(filterText));
        }
    }
 */
    // end::listCustomers[]
/*
    private void add(Button click_me) {
    }
    */
}
