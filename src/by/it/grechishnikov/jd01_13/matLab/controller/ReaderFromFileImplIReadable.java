package by.it.grechishnikov.jd01_13.matLab.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReaderFromFileImplIReadable extends Reader {
    private File from;

    public ReaderFromFileImplIReadable() {
        System.out.println("Введите путь к файлу:");
        from = new File(readStringFromConsole());
    }

    @Override
    public String readValue() {
        String result = "";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(from))) {
            result += fileReader.readLine();
        } catch (Exception e) {
            System.out.println("Ошибка.");
        }
        return result;
    }
}