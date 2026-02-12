package ru.netology;


import lombok.Generated;
import lombok.Getter;

@Getter
public class Radio {
    private int currentStation;
    private int currentVolume;
    private final int totalStations;

    public Radio() {
        this.totalStations = 10;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public Radio(int totalStations) {
        if (totalStations <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть > 0");
        } else {
            this.totalStations = totalStations;
            this.currentStation = 0;
            this.currentVolume = 0;
        }

    }

    public void setStation(int station) {
        if (station < 0 || station >= totalStations) {
            throw new IllegalArgumentException(
                    String.format("Станция %d недопустима. Допустимый диапазон: 0–%d",
                            station, totalStations - 1)
            );
        }
        this.currentStation = station;
    }

    public void next() {
        if (this.currentStation == this.totalStations - 1) {
            this.currentStation = 0;
        } else {
            ++this.currentStation;
        }

    }

    public void prev() {
        if (this.currentStation == 0) {
            this.currentStation = this.totalStations - 1;
        } else {
            --this.currentStation;
        }

    }


    public void setCurrentVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.currentVolume = volume;
        }

    }

    public void increaseVolume() {
        if (this.currentVolume < 100) {
            ++this.currentVolume;
        }

    }

    public void decreaseVolume() {
        if (this.currentVolume > 0) {
            --this.currentVolume;
        }

    }

}
