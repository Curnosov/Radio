public class Radio {
    private int currentStation; // Номер текущей радиостанции
    private int currentVolume;  // Уровень громкости

    // Геттер для текущей станции
    public int getCurrentStation() {
        return currentStation;
    }

    // Сеттер для текущей станции с проверкой диапазона
    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < 0 || newCurrentStation > 9) {
            return; // Игнорируем недопустимые значения
        }
        currentStation = newCurrentStation;
    }

    // Геттер для уровня громкости
    public int getCurrentVolume() {
        return currentVolume;
    }

    // Сеттер для уровня громкости с проверкой диапазона
    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume < 0 || newCurrentVolume > 100) {
            return; // Игнорируем недопустимые значения
        }
        currentVolume = newCurrentVolume;
    }

    // Переключение на следующую станцию
    public void nextStation() {
        if (currentStation == 9) {
            currentStation = 0; // Циклический переход с 9 на 0
        } else {
            currentStation++;
        }
    }

    // Переключение на предыдущую станцию
    public void prevStation() {
        if (currentStation == 0) {
            currentStation = 9; // Циклический переход с 0 на 9
        } else {
            currentStation--;
        }
    }

    // Увеличение громкости
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Уменьшение громкости
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    // Установка максимальной громкости
    public void setToMaxVolume() {
        currentVolume = 100;
    }
}