public class Radio {
    private int currentStation; // Номер текущей радиостанции
    private int currentVolume;  // Уровень громкости
    private int totalStations; // количество станций

    // Конструктор по умолчанию — 10 станций
    public Radio() {
        this(10);
    }

    // Конструктор с заданным количеством станций
    public Radio(int totalStations) {
        if (totalStations <= 0) {
            throw new IllegalArgumentException();
        }
        this.totalStations = totalStations;
        this.currentStation = 0; // начальная станция — 0
    }

    // Геттер для текущей станции
    public int getCurrentStation() {
        return currentStation;
    }

    // Сеттер для текущей станции с проверкой диапазона
    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < 0 || newCurrentStation >= totalStations) {
            return;
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
        if (currentStation == totalStations - 1) {
            currentStation = 0; // Циклический переход с 9 на 0
        } else {
            currentStation++;
        }
    }

    // Переключение на предыдущую станцию
    public void prevStation() {
        if (currentStation == 0) {
            currentStation = totalStations - 1; // Циклический переход с 0 на 9
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