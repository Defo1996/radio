package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    private Radio radio;

    @BeforeEach
    void setUp() {
        radio = new Radio();
    }

    // 1. Тесты конструкторов
    @Test
    void testDefaultConstructor() {
        assertEquals(10, radio.getTotalStations());
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testConstructorWithValidStations() {
        Radio radio5 = new Radio(5);
        assertEquals(5, radio5.getTotalStations());
        assertEquals(0, radio5.getCurrentStation());
    }

    @Test
    void testConstructorInvalidStations() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));
        assertThrows(IllegalArgumentException.class, () -> new Radio(-1));
    }

    @Test
    void testSetStationBothConditionsTrue() {
        IllegalArgumentException thrown1 = assertThrows(
                IllegalArgumentException.class,
                () -> radio.setStation(-1)
        );
        assertTrue(thrown1.getMessage().contains("Станция -1 недопустима"));

        IllegalArgumentException thrown2 = assertThrows(
                IllegalArgumentException.class,
                () -> radio.setStation(10)
        );
        assertTrue(thrown2.getMessage().contains("Станция 10 недопустима"));
    }

    // 2. Тесты переключения станций
    @Test
    void testNextStationNormal() {
        radio.setStation(0);
        radio.next();
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    void testNextStationWrapAround() {
        radio.setStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testNextStationNormalCase() {
        radio.setStation(3);
        radio.next();
        assertEquals(4, radio.getCurrentStation());
    }


    @Test
    void testPrevStationNormal() {
        radio.setStation(9);
        radio.prev();
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    void testPrevStationWrapAround() {
        radio.setStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testPrevStationNormalCase() {
        radio.setStation(7);
        radio.prev();
        assertEquals(6, radio.getCurrentStation());
    }

    // 3. Тесты setStation с валидацией
    @Test
    void testSetStationValid() {
        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetStationNegative() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> radio.setStation(-1)
        );
        assertTrue(thrown.getMessage().contains("Станция -1 недопустима"));
    }

    @Test
    void testSetStationAboveMax() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> radio.setStation(10)
        );
        assertTrue(thrown.getMessage().contains("Станция 10 недопустима"));
    }

    // 4. Тесты регулировки громкости
    @Test
    void testIncreaseVolumeNormal() {
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    void testIncreaseVolumeAtMax() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeNormal() {
        radio.setCurrentVolume(50);
        radio.decreaseVolume(); // Исправить опечатку в названии метода!
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeAtMin() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    // 5. Дополнительные проверки
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
        assertEquals(0, radio.getCurrentStation());
    }

}