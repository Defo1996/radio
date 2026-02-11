package ru.netology;

public class Radio {
    private int currentStation;     // номер текущей радиостанции (0-9)
    private int currentVolume;// громкость звука (0-100)
    private final int totalStations;

    public Radio() {
        this.totalStations = 10;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public Radio(int totalStations) {
        if (totalStations <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть > 0");
        }
        this.totalStations = totalStations;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public void next() {
        if (currentStation == totalStations - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = totalStations - 1;
        } else {
            currentStation--;
        }
    }

    public void setStation(int station) {
        if (station >= 0 && station < totalStations) {
            this.currentStation = station;
        }
    }

    public void setCurrentVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.currentVolume = volume;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getTotalStations() {
        return totalStations;
    }

}
