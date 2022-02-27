package ru.netology.smartHomeSystem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
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
        Radio exemplarRadio = new Radio();
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
        Radio exemplarRadio = new Radio();
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
        Radio exemplarRadio = new Radio();
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
            "'Next volume for current volume 3', 3, 4", // обычный случай 3+1
            "'Next volume for current volume 0', 0, 1", // граница
            "'Next volume for current volume 10', 10, 10", // верхняя граница
            "'Next volume for current volume -1', -1, 1", // default + 1
            "'Next volume for current volume 11', 11, 1" // default + 1

    })
    void testNextVolume(String test, int currentPosition, int expected) {
        Radio exemplarRadio = new Radio();
        exemplarRadio.setCurrentVolume(currentPosition);
        exemplarRadio.nextVolume();
        int actual = exemplarRadio.getCurrentVolume();
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "'Prev volume for current volume 3', 3, 2", // обычный случай 3-1
            "'Prev volume for current volume 0', 0, 0", // граница
            "'Prev volume for current volume 10', 10, 9", // обычный случай 3+1
            "'Prev volume for current volume -1', -1, 0", // default - 1
            "'Prev volume for current volume 11', 11, 0", // default - 1
    })
    void testPrevVolume(String test, int currentPosition, int expected) {
        Radio exemplarRadio = new Radio();
        exemplarRadio.setCurrentVolume(currentPosition);
        exemplarRadio.prevVolume();
        int actual = exemplarRadio.getCurrentVolume();
        assertEquals(expected, actual);

    }

}