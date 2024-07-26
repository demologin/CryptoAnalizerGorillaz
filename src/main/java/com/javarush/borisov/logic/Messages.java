package com.javarush.borisov.logic;

public enum Messages {
    GREETINGS ("\nver 1.00 реализовано только для небольших файлов\nВыберете действие"),
    ACCESS_DENIED ("\nне могу создать файл (отказано в доступе), давай по новой\n"),
    FILE_NOT_FOUND ("\nфайл по указанному пути отсутсвует, давай по новой\n"),
    UNKNOWN_ERROR ("\nнеизвестная ошибка\n"),
    ENCODE ("Шифрую..."),
    ENCODE_FINISH("Файл зашифрован"),
    MENU_ENCODE ("1 - зашифровать"),
    MENU_DECODE ("2 - расшифровать"),
    WRONG_NUMBER ("Ну нет такого числа в меню, давай внимательнее..."),
    ENTER_PATH_TO_FILE ("введите путь к файлу: "),
    ENTER_KEY ("введите фразу для шифра: "),
    ENTER_PATH_TI_SAVE ("введите место сохранения файла "),
    MENU_EXIT ("9 - выход");

    private final String title;

    Messages(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

}
