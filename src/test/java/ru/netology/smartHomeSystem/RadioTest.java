package ru.netology.smartHomeSystem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio exemplarRadio = new Radio();
    Radio exemplarRadioSetStation = new Radio(6);

    @ParameterizedTest
    @CsvSource(value = {
            "'Set position 3', 3, 3", // обычный случай установка номера 3
            "'Set position 0', 0, 0", // граничные значения
            "'Set position 9', 9, 9", // граничные значения
            "'Set position 10', 10, 0", // граничные значения выше диапазона
            "'Set position -1', -1, 0", // граничные значения ниже диапозона
            "'Set position 100000', 100000, 0", // большое положительное
            "'Set position -100000', -100000, 0" // большое отрицательное

    })
    void testSetPosition(String test, int currentPosition, int expected) {
//        Radio exemplarRadio = new Radio();
        exemplarRadio.setCurrentPosition(currentPosition);
        int actual = exemplarRadio.getCurrentPosition();
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Set position 3 amt=9', 3, 3, 9", // обычный случай установка номера 3, максимально 9 станций
            "'Set position 0 amt=1', 0, 0, 1", // граничные значения
            "'Set position 9 amt=10', 9, 9, 10", // граничные значения
            "'Set position 10 amt=10', 10, 0, 10", // граничные значения выше диапазона
            "'Set position -1 amt=4', -1, 0, 4", // граничные значения ниже диапозона
            "'Set position 100000 amt=200000', 100000, 100000, 200000" // большое положительное

    })
    void testSetPositionWithAmt(String test, int currentPosition, int expected, int amt) {
        Radio exemplarRadio = new Radio(amt);
        exemplarRadio.setCurrentPosition(currentPosition);
        int actual = exemplarRadio.getCurrentPosition();
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Next position for current position 3', 3, 4", // обычный случай 3+1
            "'Next position for current position -1', -1, 1", // 0+1
            "'Next position for current position 10', -1, 1", // 0+1
            "'Next position for current position 9', 9, 0", // граница
            "'Next position for current position 0', 0, 1" // граница
    })
    void testNextPosition(String test, int currentPosition, int expected) {
//        Radio exemplarRadio = new Radio();
        exemplarRadio.setCurrentPosition(currentPosition);
        exemplarRadio.nextPosition();
        int actual = exemplarRadio.getCurrentPosition();
        assertEquals(expected, actual);
//
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Next position for current position 3 amt=8', 3, 4, 8", // обычный случай 3+1
            "'Next position for current position -1', -1, 1, 4", // 0+1
            "'Next position for current position 11 amt=12', 11, 0, 12", // граница
            "'Next position for current position 0 amt=13', 0, 1, 13" // граница
    })
    void testNextPositionWithAmt(String test, int currentPosition, int expected, int amt) {
        Radio exemplarRadio = new Radio(amt);
        exemplarRadio.setCurrentPosition(currentPosition);
        exemplarRadio.nextPosition();
        int actual = exemplarRadio.getCurrentPosition();
        assertEquals(expected, actual);
//
    }


    @ParameterizedTest
    @CsvSource(value = {
            "'Prev position for current position 3', 3, 2", // обычный случай 3-1
            "'Prev position for current position 0', 0, 9", // граница
            "'Prev position for current position 9', 9, 8", // граница
            "'Prev position for current position -1', -1, 9", // 0-1
            "'Prev position for current position 10', 10, 9" // 0-1
    })
    void testPrevPosition(String test, int currentPosition, int expected) {
//        Radio exemplarRadio = new Radio();
        exemplarRadio.setCurrentPosition(currentPosition);
        exemplarRadio.prevPosition();
        int actual = exemplarRadio.getCurrentPosition();
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Prev position for current position 3 amt=7', 3, 2, 7", // обычный случай 3-1
            "'Prev position for current position 0 amt 14', 0, 13, 14", // граница
            "'Prev position for current position 9 amt 10', 9, 8, 10", // граница
            "'Prev position for current position -1 amt=16', -1, 15, 16" // 0-1
    })
    void testPrevPositionWithAmt(String test, int currentPosition, int expected, int amt) {
        Radio exemplarRadio = new Radio(amt);
        exemplarRadio.setCurrentPosition(currentPosition);
        exemplarRadio.prevPosition();
        int actual = exemplarRadio.getCurrentPosition();
        assertEquals(expected, actual);

    }

//    @Test
//    void testSetVolume() {
//        Radio exemplarRadio = new Radio();
//        exemplarRadio.setCurrentVolume(3);
//        int expected = 3;
//        int actual = exemplarRadio.getCurrentVolume();
//        assertEquals(expected, actual);
//
//    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Next volume for current volume 10', 10, 11", // обычный случай 10+1
            "'Next volume for current volume 0', 0, 1", // граница
            "'Next volume for current volume 100', 100, 100", // верхняя граница
            "'Next volume for current volume -1', -1, 1", // default + 1
            "'Next volume for current volume 101', 101, 1" // default + 1

    })
    void testNextVolume(String test, int currentPosition, int expected) {
//        Radio exemplarRadio = new Radio();
        exemplarRadio.setCurrentVolume(currentPosition);
        exemplarRadio.nextVolume();
        int actual = exemplarRadio.getCurrentVolume();
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Prev volume for current volume 45', 45, 44", // обычный случай 3-1
            "'Prev volume for current volume 0', 0, 0", // граница
            "'Prev volume for current volume 100', 100, 99", // обычный случай 3+1
            "'Prev volume for current volume -1', -1, 0", // default - 1
            "'Prev volume for current volume 101', 101, 0", // default - 1
    })
    void testPrevVolume(String test, int currentPosition, int expected) {
//        Radio exemplarRadio = new Radio();
        exemplarRadio.setCurrentVolume(currentPosition);
        exemplarRadio.prevVolume();
        int actual = exemplarRadio.getCurrentVolume();
        assertEquals(expected, actual);

    }

}