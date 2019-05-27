package kurs;

import org.sikuli.basics.Settings;
import org.sikuli.script.*;

/**
 * Программа сама считает на виндовом калькуляторе
 */
public class MyApp {
    public static void main(String[] args) throws FindFailed, InterruptedException {
        // Основной объект Сикули для манипуляции с экраном
        Screen screen = new Screen();

        // Открываем тестируемую программу
        org.sikuli.script.App app = org.sikuli.script.App.open("c:\\windows\\System32\\calc.exe",3);
        // Вылючаю разговорчивый режим логирования
        System.setProperty("sikuli.Debug","1");

        /** При клике мышкой можно подсвечивать, куда кликает */
//        Settings.Highlight = true;

        // Ускоряю клик
        Settings.ClickFast = true;

        // Переносим фокус на тестируемую программу, становиться активным окном
        app.focus();

        /** Указываю абсолютный путь к папке с картинками*/
//        ImagePath.add("C:\\Users\\userXX\\Documents\\IdeaProjects\\sikuli1\\src\\resources");

        /** Т.к. пути у нас на компах разные, то для каждого прийдётся поправить путь на предыдущей строке.
         * Чтобы было универсально использую такую конструкцию чтобы получить папку откуда запущена программа
         * Это удобно, т.к. после того как сбилдим приложение в jar сможем разместить фотки прямо в архиве или рядом с ни в той же папке*/
        ImagePath.add(Thread.currentThread().getContextClassLoader().getResource("."));

        // Кликаю по картинкам. (!) Программа калькулятор должна быть видна на экране.
        screen.click("1.png");
        screen.click("0.png");
        screen.click("+.png");
        screen.click("1.png");
        screen.click("0.png");
        screen.click("=.png");
        // введу текст с клавиатуры
        screen.type("+25*30=");

        // Подожду 2000 милисекунд (чтобы оценить красоту исполнения)
        Thread.sleep(2000);
        //и закрываю калькулятор нажатием Alt+F4
        screen.type(Key.F4, KeyModifier.ALT);
    }
}
