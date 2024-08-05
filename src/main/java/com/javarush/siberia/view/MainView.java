package com.javarush.siberia.view;

import com.javarush.siberia.constants.Constants;
import com.javarush.siberia.menu.ConsoleApplication;
import com.javarush.siberia.entity.Result;

import javax.swing.*;
import java.awt.*;

public class MainView {

    private final ConsoleApplication consoleApplication;

    public MainView() {
        consoleApplication = new ConsoleApplication();
    }

    public void initFrame() {
        JFrame frame = new JFrame("Примитивный Криптоанализатор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10));
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

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        executeButton.addActionListener(e -> {
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
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}