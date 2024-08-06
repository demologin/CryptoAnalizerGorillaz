package com.javarush.myasnikov;

import com.javarush.myasnikov.inputs.FileHandler;
import com.javarush.myasnikov.processors.CryptoProcessor;
import com.javarush.myasnikov.utilities.Command;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static com.javarush.myasnikov.utilities.Alphabet.ALPHABET;
import static com.javarush.myasnikov.utilities.Command.*;


public class swingApp extends JFrame{
    private JButton executeButton;
    private JTextField keyField;
    private JLabel commandsLabel;
    private JPanel mainPanel;
    private JComboBox commandCombo;
    private JTextField decryptedFilePath;
    private JTextField encryptedFilePath;
    private JButton openDecryptedFileButton;
    private JButton openEncryptedFileButton;
    private JButton openBruteForceFileButton;
    private JTextPane textField;
    private JTextField bruteForceFilePath;

    public swingApp(){
        createForm();
        updateForm();
        processTextByButtonPress();
        if (!decryptedFilePath.getText().isBlank()) {
            String filePath = decryptedFilePath.getText();
            fillTextFieldByOpenButtonPress(openDecryptedFileButton, filePath);
        }

        if (!encryptedFilePath.getText().isBlank()) {
            String filePath = encryptedFilePath.getText();
            fillTextFieldByOpenButtonPress(openEncryptedFileButton, encryptedFilePath.getText());
        }

        if (!bruteForceFilePath.getText().isBlank())
        {
            String path = bruteForceFilePath.getText();
            fillTextFieldByOpenButtonPress(openBruteForceFileButton, path);
        }
    }

    private void fillTextFieldByOpenButtonPress (JButton button, String fieldText) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileHandler fileHandler = new FileHandler();
                textField.setText(fileHandler.getTextFromFile(fieldText));
            }
        });
    }

    private void showPopupMessage() {
            JFrame frame = new JFrame("Popup Message (ERROR)");
            JOptionPane.showMessageDialog(frame, "В поле ключ нечисловое значение", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
    }

    private void processTextByButtonPress() {
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = 0;
                try {
                    String text =textField.getText();
                    if (commandCombo.getSelectedItem() != BRUTE_FORCE) {
                        key = Integer.parseInt(keyField.getText());
                    }
                    new CryptoProcessor(ALPHABET, text, key, (Command) commandCombo.getSelectedItem());
                    updateForm();
                }
                catch (NumberFormatException exception) {
                    showPopupMessage();
                }
            }
        });
    }

    private void createForm() {
        setContentPane(mainPanel);
        setTitle("Crypto analyzer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateForm ()
    {
        fillTestTextFiled();
        fillFields();
    }

    public void fillTestTextFiled() {
        if (textField.getText().isBlank()) {
            textField.setText("Я вас любил: любовь еще, быть может,\n" +
                    "В душе моей угасла не совсем;\n" +
                    "Но пусть она вас больше не тревожит;\n" +
                    "Я не хочу печалить вас ничем.\n" +
                    "Я вас любил безмолвно, безнадежно,\n" +
                    "То робостью, то ревностью томим;\n" +
                    "Я вас любил так искренно, так нежно,\n" +
                    "Как дай вам бог любимой быть другим.");
        }
    }

    private void fillFields() {
        FileHandler fileHandler = new FileHandler();
        encryptedFilePath.setText(fileHandler.getFilesList(ENCRYPT));
        decryptedFilePath.setText(fileHandler.getFilesList(DECRYPT));
        bruteForceFilePath.setText(fileHandler.getFilesList(BRUTE_FORCE));
        if (commandCombo.getItemCount() == 0) {
            for (Command command : Command.values()) {
                commandCombo.addItem(command);
            }
            commandCombo.setSelectedItem(ENCRYPT);
        }
    }



}
