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
    private DataContainer dataContainer;

    private Operation selectOperation;
    private String source;
    private String destination;
    private String dictionary;
    private int key;

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
                source = sourceField.getText();
                destination = destinationField.getText();
                dictionary = dictionaryField.getText();
                key = Integer.parseInt(keyField.getText());

                getUserAllResponse(selectOperation, source, destination, dictionary, key);
                dataController.setDataContainer(dataContainer);
                dataController.runProcessing();
            } catch (ApplicationException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });
    }

    private void initializeUI() {

        frame = new JFrame("Crypto_Analizer_Gorillaz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        createPanels();

        createFields();
        createRadioButtons();
        submitButton = new JButton("Submit");
        panelInput.add(submitButton);
        contentPane.add(panelInput);
        contentPane.add(panelOperation);

        frame.pack();
        frame.setVisible(true);
    }

    private void getUserAllResponse(Operation selectOperation, String source, String destination, String dictionary, int key) {
        dataContainer = new DataContainer(selectOperation, source, destination, dictionary, key);
    }

    private void createPanels() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        GridLayout gridLayout = new GridLayout(5, 2, 5, 5);

        panelOperation = new JPanel(flowLayout);
        panelInput = new JPanel(gridLayout);
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

        String sourcePath = InputParameter.SOURCE.getDefaultValue(selectOperation);
        sourceField.setText(PathBuilder.buildPathAsString(sourcePath));

        String destination = InputParameter.DESTINATION.getDefaultValue(selectOperation);
        destinationField.setText(PathBuilder.buildPathAsString(destination));

        String dictionary = InputParameter.DICTIONARY.getDefaultValue(selectOperation);
        dictionaryField.setText(PathBuilder.buildPathAsString(dictionary));

        String key = InputParameter.KEY.getDefaultValue(selectOperation);
        keyField.setText(key);
    }
}
