package ru.netology.smartHomeSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int currentVolume;
    private int currentPosition;
    private int amtPosition = 10;

    public Radio(int amtPosition) {
        this.amtPosition = amtPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        if (currentPosition >= 0 && currentPosition <= amtPosition - 1) {
            this.currentPosition = currentPosition;
        }
        return;
    }

    public void nextPosition() {
        if (currentPosition == amtPosition - 1) {
            this.currentPosition = 0;
        } else {
            this.currentPosition = currentPosition + 1;
        }
    }

    public void prevPosition() {
        if (currentPosition == 0) {
            this.currentPosition = amtPosition - 1;
        } else {
            this.currentPosition = currentPosition - 1;
        }

    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume >= 0 && currentVolume <= 100) {
            this.currentVolume = currentVolume;
        }
        return;
    }

    public void nextVolume() {
        if (currentVolume < 100) {
            this.currentVolume = currentVolume + 1;
        }
    }

    public void prevVolume() {
        if (currentVolume > 0) {
            this.currentVolume = currentVolume - 1;
        }
    }

}
