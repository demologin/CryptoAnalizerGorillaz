package com.javarush.nikitin.view.console;

import com.javarush.nikitin.controllers.DataController;
import com.javarush.nikitin.entity.DataContainer;
import com.javarush.nikitin.exceptions.ApplicationException;

public class ConsoleApplication {
    private final InteractiveMenu interactiveMenu;
    private final DataController dataController;

    public ConsoleApplication(InteractiveMenu interactiveMenu, DataController dataController) {
        this.interactiveMenu = interactiveMenu;
        this.dataController = dataController;
    }

    public void initialize() {
        try {
            DataContainer data = interactiveMenu.executeMenu();
            dataController.setDataContainer(data);
            dataController.runProcessing();
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        }
    }
}