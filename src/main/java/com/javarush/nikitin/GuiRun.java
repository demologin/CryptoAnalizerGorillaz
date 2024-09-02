package com.javarush.nikitin;

import com.javarush.nikitin.controllers.DataController;
import com.javarush.nikitin.view.gui.GuiApplication;

public class GuiRun {
    public static void main(String[] args) {
        DataController dataController = new DataController();
        GuiApplication guiApplication = new GuiApplication(dataController);

        guiApplication.initialize();
    }
}
