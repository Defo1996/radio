package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    private Radio radio;

    @BeforeEach
    void setUp() {
        radio = new Radio();
    }

    // Тестирование переключения станций
    @Test
    void testNextStationFrom0To1() {
        radio.setStation(0);
        radio.next();
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    void testNextStationFrom8To9() {
        radio.setStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testNextStationFrom9To0() {
        radio.setStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testPrevStationFrom9To8() {
        radio.setStation(9);
        radio.prev();
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    void testPrevStationFrom1To0() {
        radio.setStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testPrevStationFrom0To9() {
        radio.setStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    // Тестирование установки станции через сеттер
    @Test
    void testSetStationValid() {
        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetStationBelowRange() {
        radio.setStation(-1);
        assertEquals(0, radio.getCurrentStation()); // остаётся прежней
    }

    @Test
    void testSetStationAboveRange() {
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation()); // остаётся прежней
    }

    // Тестирование регулировки громкости
    @Test
    void testIncreaseVolumeBelowMax() {
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void testIncreaseVolumeAtMax() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume()); // не увеличивается
    }

    @Test
    void testDecreaseVolumeAboveMin() {
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeAtMin() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume()); // не уменьшается
    }

    // Дополнительные тесты на граничные условия
    @Test
    void testInitialState() {
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testMultipleNextCalls() {
        for (int i = 0; i < 10; i++) {
            radio.next();
        }
        assertEquals(0, radio.getCurrentStation()); // после 10 вызовов вернулись к 0
    }

    @Test
    void testMultiplePrevCalls() {
        for (int i = 0; i < 10; i++) {
            radio.prev();
        }
        assertEquals(0, radio.getCurrentStation()); // после 10 вызовов вернулись к 0
    }
}