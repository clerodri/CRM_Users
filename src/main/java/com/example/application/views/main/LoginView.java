package com.example.application.views.main;

import com.example.application.Data.Contact;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Contacts | Vaadin CRM")
@Route(value = "/login")
public class LoginView extends VerticalLayout {
    Grid<Contact>  grid  = new Grid<>(Contact.class);
    TextField filterText = new TextField();
    public LoginView() {
            addClassName("list-view");
            setSizeFull();

            configureGrid();

            add(
                getToolbar(), grid
            );
    }

    private Component getToolbar() {
        filterText.setPlaceholder("Filter by name..");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button  addContactBtn = new Button("Add Contact");
        HorizontalLayout toolbar = new HorizontalLayout(filterText,addContactBtn);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.setSizeFull();
        grid.setColumns("firstName","lastName","email");
        grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");

        grid.getColumns().forEach(contactColumn -> contactColumn.setAutoWidth(true));

    }
}
