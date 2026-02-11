package ru.netology;


import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Setter
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

    public void setStation(int station) {
        if (station >= 0 && station < this.totalStations) {
            this.currentStation = station;
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

    @Generated
    public void setCurrentStation(int currentStation) {
        this.currentStation = currentStation;
    }
}
