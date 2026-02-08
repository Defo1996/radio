package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    private Radio radio;

    @BeforeEach
    public void setUp() {
        radio = new Radio();
    }

    // Тестирование переключения станций
    @Test
    public void testNextStationFrom0To1() {
        radio.setStation(0);
        radio.next();
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void testNextStationFrom8To9() {
        radio.setStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testNextStationFrom9To0() {
        radio.setStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationFrom9To8() {
        radio.setStation(9);
        radio.prev();
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationFrom1To0() {
        radio.setStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationFrom0To9() {
        radio.setStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testSetStationValid() {
        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetStationBelowRange() {
        radio.setStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetStationAboveRange() {
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testSetStationNegative() {
        radio.setStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testSetStationAboveMax() {
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation());
    }


    // Тестирование регулировки громкости
    @Test
    public void testIncreaseVolumeBelowMax() {
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void testSetCurrentVolumeNegative() {
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testSetCurrentVolumeAboveMax() {
        radio.setCurrentVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolumeAtMax() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeAboveMin() {
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeAtMin() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    // Дополнительные тесты на граничные условия
    @Test
    public void testInitialState() {
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testMultipleNextCalls() {
        for (int i = 0; i < 10; i++) {
            radio.next();
        }
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testMultiplePrevCalls() {
        for (int i = 0; i < 10; i++) {
            radio.prev();
        }
        assertEquals(0, radio.getCurrentStation());
    }


}