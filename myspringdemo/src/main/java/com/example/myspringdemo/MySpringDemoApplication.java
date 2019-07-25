package com.example.myspringdemo;

import com.example.myspringdemo.entity.Department;
import com.example.myspringdemo.repository.DepartmentRepository;
import com.vaadin.flow.spring.VaadinConfigurationProperties;
import com.vaadin.flow.spring.VaadinServletConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@AutoConfigureBefore(value=org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.class)
@ConditionalOnClass(value=org.springframework.boot.web.servlet.ServletContextInitializer.class)
@EnableConfigurationProperties(value= VaadinConfigurationProperties.class)
@Import(value= VaadinServletConfiguration.class)


@SpringBootApplication
public class MySpringDemoApplication {
    private static final Logger log = LoggerFactory.getLogger(MySpringDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MySpringDemoApplication.class);
    }

    @Bean
    public CommandLineRunner loadData(DepartmentRepository repository){
        return (args) ->{
            //save a couple of department
            repository.save(new Department("3 офис"));

            // fetch all departments
            log.info("Department found with findAll():");
            log.info("--------------------------------");
            for (Department department: repository.findAll()){
                log.info(repository.toString());
            }
            log.info("");

            // fetch an individual department by ID
            /*
            Optional<Department> byId = repository.findById(1L);
            if (byId.isPresent()) {
                Department department = byId.get();
                log.info("Department found with findOne(1L):");
                log.info("--------------------------------");
                log.info(department.toString());
                log.info("");
            } else
                System.out.println("нет такого департамента");
            */
            Department department = repository.findById(1L).get();
            log.info("Department found with findOne(1L):");
            log.info("--------------------------------");
            log.info(department.toString());
            log.info("");

            //fetch department by name
            log.info("Department found with findByNameOfDepartmentStartsWithIgnoreCase('Bauer'):");
            log.info("--------------------------------");
            for (Department bauer : repository.findByNameOfDepartmentStartsWithIgnoreCase("Bauer")){
                log.info(bauer.toString());
            }
            log.info("");
        };
    }
}