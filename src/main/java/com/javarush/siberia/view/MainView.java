package com.javarush.siberia.view;

import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.menu.ConsoleApplication;
import com.javarush.siberia.entity.Result;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainView {

    private final ConsoleApplication consoleApplication;
    private JTextArea resultArea;
    private JTextField replaceFromField;
    private JTextField replaceToField;
    private JTextField savePathField;

    public MainView() {
        consoleApplication = new ConsoleApplication();
    }

    public void initFrame() {
        JFrame frame = new JFrame("CryptoApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel actionLabel = new JLabel("Выберите действие:");
        JComboBox<String> actionComboBox = new JComboBox<>(new String[]{"encode", "decode", "bruteforce", "analysis"});

        JLabel keyLabel = new JLabel("Введите ключ (или оставьте пустым для сдвига по умолчанию):");
        JTextField keyField = new JTextField();

        JLabel inputLabel = new JLabel("Введите путь к входному файлу (или оставьте пустым для пути по умолчанию):");
        JTextField inputFileField = new JTextField();

        JLabel outputLabel = new JLabel("Введите путь к выходному файлу (или оставьте пустым для пути по умолчанию):");
        JTextField outputFileField = new JTextField();

        JButton executeButton = new JButton("Выполнить");

        inputPanel.add(actionLabel);
        inputPanel.add(actionComboBox);
        inputPanel.add(keyLabel);
        inputPanel.add(keyField);
        inputPanel.add(inputLabel);
        inputPanel.add(inputFileField);
        inputPanel.add(outputLabel);
        inputPanel.add(outputFileField);
        inputPanel.add(new JLabel());
        inputPanel.add(executeButton);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());

        resultArea = new JTextArea();
        resultArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        JPanel replacePanel = new JPanel();
        replacePanel.setLayout(new GridLayout(3, 2, 10, 10));
        replacePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel replaceFromLabel = new JLabel("Заменить символ:");
        replaceFromField = new JTextField();

        JLabel replaceToLabel = new JLabel("На символ:");
        replaceToField = new JTextField();

        JLabel savePathLabel = new JLabel("Введите путь для сохранения изменений:");
        savePathField = new JTextField();

        JButton replaceButton = new JButton("Заменить");
        JButton saveButton = new JButton("Сохранить");

        replacePanel.add(replaceFromLabel);
        replacePanel.add(replaceFromField);
        replacePanel.add(replaceToLabel);
        replacePanel.add(replaceToField);
        replacePanel.add(savePathLabel);
        replacePanel.add(savePathField);
        replacePanel.add(new JLabel());
        replacePanel.add(replaceButton);
        replacePanel.add(new JLabel());
        replacePanel.add(saveButton);

        outputPanel.add(scrollPane, BorderLayout.CENTER);
        outputPanel.add(replacePanel, BorderLayout.SOUTH);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(outputPanel, BorderLayout.CENTER);

        executeButton.addActionListener(e -> executeAction(actionComboBox, keyField, inputFileField, outputFileField));
        replaceButton.addActionListener(e -> replaceText());
        saveButton.addActionListener(e -> saveChanges());

        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeAction(JComboBox<String> actionComboBox, JTextField keyField, JTextField inputFileField, JTextField outputFileField) {
        String action = (String) actionComboBox.getSelectedItem();
        String key = keyField.getText().trim();
        String inputPath = inputFileField.getText().trim();
        String outputPath = outputFileField.getText().trim();

        if (inputPath.isEmpty()) {
            inputPath = switch (action) {
                case "encode" -> Constants.INPUT_FILE;
                case "decode" -> Constants.ENCODED_FILE;
                case "bruteforce" -> Constants.ENCODED_FILE;
                case "analysis" -> Constants.ENCODED_FILE;
                default -> inputPath;
            };
        }
        if (outputPath.isEmpty()) {
            outputPath = switch (action) {
                case "encode" -> Constants.ENCODED_FILE;
                case "decode" -> Constants.DECODED_FILE;
                case "bruteforce" -> Constants.BRUTEFORCE_FILE;
                case "analysis" -> Constants.ANALYSIS_FILE;
                default -> outputPath;
            };
        }

        try {
            String[] params;
            if ("encode".equals(action) || "decode".equals(action)) {
                if (key.isEmpty()) {
                    key = String.valueOf(Constants.DEFAULT_SHIFT);
                }
                params = new String[]{action, key, inputPath, outputPath};
            } else {
                params = new String[]{action, inputPath, outputPath};
            }

            Result result = consoleApplication.run(params);
            resultArea.setText(result.toString());
        } catch (Exception ex) {
            resultArea.setText("Ошибка: " + ex.getMessage() + "\n" + ex.toString());
        }
    }

    private void replaceText() {
        String text = resultArea.getText();
        String replaceFrom = replaceFromField.getText();
        String replaceTo = replaceToField.getText();

        if (replaceFrom != null && replaceTo != null) {
            text = text.replace(replaceFrom, replaceTo);
            resultArea.setText(text);
        }
    }

    private void saveChanges() {
        String savePath = savePathField.getText().trim();
        if (savePath.isEmpty()) {
            savePath = Constants.ANALYSIS_FILE;
        }

        try {
            java.nio.file.Files.write(java.nio.file.Paths.get(savePath), resultArea.getText().getBytes());
            JOptionPane.showMessageDialog(null, "Изменения успешно сохранены!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка сохранения: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}