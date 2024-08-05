package com.javarush.siberia;

import javax.swing.SwingUtilities;
import com.javarush.siberia.view.MainView;

public class StartWindowApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            mainView.initFrame();
        });
    }
}