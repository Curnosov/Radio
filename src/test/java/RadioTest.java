import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
        // станция в допустимом диапазоне (0–9).
    void shouldSetStationInRange() {
        Radio radio = new Radio(10);
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
        // Попытка установить недопустимую станцию (-1)
    void shouldNotSetStationOutOfRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
        // Попытка установить недопустимую станцию (10)
    void shouldNotSetStationWhenAboveMaxRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
        // цикличное переключение для фиксированного количества станций (с 9 на 0)
    void shouldCycleNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
        // переключение на следующую допустимую станцию
    void shouldIncrementStationWhenNotNine() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
        // цикличное переключение станций для фиксированного количества станций(с 0 на 9)
    void shouldCyclePrevStationFromZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
        // переключение на предыдущую допустимую станцию
    void shouldCyclePrevStationFromNonZero() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
        // увеличение звука (с 0 на 1)
    void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
        // громкость не увеличивается выше 100
    void shouldNotExceedMaxVolume() {
        Radio radio = new Radio();
        for (int i = 0; i <= 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
        // устанавливает максимальную громкость
    void shouldSetToMaxVolume() {
        Radio radio = new Radio();
        radio.setToMaxVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
        // уменьшает громкость на 1
    void shouldDecreaseVolumeWhenAboveMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10); // Устанавливаем начальную громкость
        radio.decreaseVolume();
        assertEquals(9, radio.getCurrentVolume()); // Громкость должна уменьшиться
    }

    @Test
        // громкость не уменьшается ниже 0
    void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
        // проверяет допустимое значение громкости
    void shouldSetVolumeInRange() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
        // недопустимое значение громкости ниже минимума
    void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-10);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
        // недопустимое значение громкости выше максимума
    void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(110);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
        // цикличный переход для кастомного количества станций
    void shouldCycleNextStationWithCustomTotal() {
        Radio radio = new Radio(5); // 5 станций: 0–4
        radio.setCurrentStation(4);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
        // не допускает создание радио без станций
    void shouldThrowExceptionWhenTotalStationsIsZero() {
        assertThrows(IllegalArgumentException.class, () -> new Radio(0));

    }

}

