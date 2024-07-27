package com.javarush.borisov.logic;

public class Const {
//    public static final char[] ALPHABET = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м',
//            'н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я',' '};
//    public static final char[] ALPHABET = {'а', 'б','в','г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м',
//        'н', 'о', 'п', 'р', 'с', 'т', 'у','ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.',
//        ',', '«', '»',':', '!', '?', ' '};
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String num = "1234567890";
    private static final String cym = "!@#$%^&*()_+-=*/.,<>[]{};:'\" `~";
        private static final String alphabet1 = (rus + rus.toLowerCase() + eng + eng.toLowerCase() + num + cym);
    public static final char[] ALPHABET = alphabet1.toCharArray();
}
