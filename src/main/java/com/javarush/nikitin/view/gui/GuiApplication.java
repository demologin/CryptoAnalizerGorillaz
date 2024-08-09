package com.javarush.nikitin.view.gui;

import com.javarush.nikitin.constants.InputParameter;
import com.javarush.nikitin.constants.Operation;
import com.javarush.nikitin.controllers.DataController;
import com.javarush.nikitin.entity.DataContainer;
import com.javarush.nikitin.exceptions.ApplicationException;
import com.javarush.nikitin.util.PathBuilder;

import javax.swing.*;
import java.awt.*;

public class GuiApplication {
    private final DataController dataController;
    private Operation selectOperation;

    private JFrame frame;
    private Container contentPane;
    private JPanel panelOperation;
    private JPanel panelInput;

    private JTextField sourceField;
    private JTextField destinationField;
    private JTextField dictionaryField;
    private JTextField keyField;
    private JButton submitButton;

    private JRadioButton radioButtonEncrypt;
    private JRadioButton radioButtonDecrypt;
    private JRadioButton radioButtonBruteForce;

    public GuiApplication(DataController dataController) {
        this.dataController = dataController;
    }

    public void initialize() {
        initializeUI();

        submitButton.addActionListener(e -> {
            try {
                DataContainer dataContainer = getUserAllResponse();
                dataController.setDataContainer(dataContainer);
                dataController.runProcessing();

                JOptionPane.showMessageDialog(frame, "Task completed");
            } catch (ApplicationException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });
    }

    private void initializeUI() {
        frame = new JFrame("Crypto_Analizer_Gorillaz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        fillFrame();
        addRadioButtonsListener();
        frame.pack();
        frame.setVisible(true);
    }

    private DataContainer getUserAllResponse() {
        String source = sourceField.getText();
        String destination = destinationField.getText();
        String dictionary = dictionaryField.getText();
        int key = Integer.parseInt(keyField.getText());

        return new DataContainer(selectOperation, source, destination, dictionary, key);
    }

    private void fillFrame() {
        createPanels();
        createFields();
        createRadioButtons();
        createButtons();

        contentPane.add(panelInput);
        contentPane.add(panelOperation);
    }

    private void createPanels() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        GridLayout gridLayout = new GridLayout(5, 2, 5, 5);

        panelOperation = new JPanel(flowLayout);
        panelInput = new JPanel(gridLayout);
    }

    private void createButtons() {
        submitButton = new JButton("Submit");
        panelInput.add(submitButton);
    }

    private void createFields() {
        int widthColumn = 40;
        sourceField = new JTextField(widthColumn);
        destinationField = new JTextField(widthColumn);
        dictionaryField = new JTextField(widthColumn);
        keyField = new JTextField(widthColumn);

        panelInput.add(new JLabel(InputParameter.SOURCE.getMessage()));
        panelInput.add(sourceField);
        panelInput.add(new JLabel(InputParameter.DESTINATION.getMessage()));
        panelInput.add(destinationField);
        panelInput.add(new JLabel(InputParameter.DICTIONARY.getMessage()));
        panelInput.add(dictionaryField);
        panelInput.add(new JLabel(InputParameter.KEY.getMessage()));
        panelInput.add(keyField);
    }

    private void createRadioButtons() {
        radioButtonEncrypt = new JRadioButton(Operation.ENCRYPT.toString(), true);
        radioButtonDecrypt = new JRadioButton(Operation.DECRYPT.name());
        radioButtonBruteForce = new JRadioButton(Operation.BRUTE_FORCE.name());

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonEncrypt);
        buttonGroup.add(radioButtonDecrypt);
        buttonGroup.add(radioButtonBruteForce);

        panelOperation.add(new JLabel("Operation:"));
        panelOperation.add(radioButtonEncrypt);
        panelOperation.add(radioButtonDecrypt);
        panelOperation.add(radioButtonBruteForce);
    }

    private void addRadioButtonsListener() {
        radioButtonEncrypt.addActionListener(e -> {
            updateInputFields(radioButtonEncrypt.getText());
        });
        radioButtonDecrypt.addActionListener(e -> {
            updateInputFields(radioButtonDecrypt.getText());
        });
        radioButtonBruteForce.addActionListener(e -> {
            updateInputFields(radioButtonBruteForce.getText());
        });
        updateInputFields(radioButtonEncrypt.getText());
    }

    private void updateInputFields(String OperationType) {
        selectOperation = Operation.valueOf(OperationType);

        String sourcePath = InputParameter.SOURCE
                .getDefaultValue(selectOperation);
        String destination = InputParameter.DESTINATION
                .getDefaultValue(selectOperation);
        String dictionary = InputParameter.DICTIONARY
                .getDefaultValue(selectOperation);
        String key = InputParameter.KEY
                .getDefaultValue(selectOperation);

        sourceField.setText(PathBuilder.buildPathAsString(sourcePath));
        destinationField.setText(PathBuilder.buildPathAsString(destination));
        dictionaryField.setText(PathBuilder.buildPathAsString(dictionary));
        keyField.setText(key);

        switch (selectOperation) {
            case ENCRYPT, DECRYPT -> {
                dictionaryField.setEnabled(false);
                keyField.setEnabled(true);
            }
            case BRUTE_FORCE -> {
                dictionaryField.setEnabled(true);
                keyField.setEnabled(false);
            }
        }
    }
}
