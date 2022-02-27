package ru.netology.smartHomeSystem;

public class Radio {
    private int currentVolume;
    private int currentPosition;

    public void setCurrentPosition(int currentPosition) {
        if (currentPosition >= 0 && currentPosition <= 9) {
            this.currentPosition = currentPosition;
        }
        return;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void nextPosition() {
        if (currentPosition == 9) {
            this.currentPosition = 0;
        } else {
            this.currentPosition = currentPosition + 1;
        }
    }

    public void prevPosition() {
        if (currentPosition == 0) {
            this.currentPosition = 9;
        } else {
            this.currentPosition = currentPosition - 1;
        }

    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume >= 0 && currentVolume <= 10) {
            this.currentVolume = currentVolume;
        }
        return;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void nextVolume() {
        if (currentVolume < 10) {
            this.currentVolume = currentVolume + 1;
        }
    }

    public void prevVolume() {
        if (currentVolume > 0) {
            this.currentVolume = currentVolume - 1;
        }
    }

}
