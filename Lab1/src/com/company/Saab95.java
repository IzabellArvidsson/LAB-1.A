package com.company;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    /**Specifies the cars attributes.
     *
     * @param nrDoors number of doors
     * @param enginePower how strong the motor is
     * @param color the color of the car
     * @param modelName the name of the car model
     * @param position where the cars position is
     */

    public Saab95(int nrDoors, double enginePower, Color color, String modelName, Position position) {
        super(nrDoors, enginePower, color, modelName, position);
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }


    /**This method says how fast the car can go
     *
     * @param enginePower how strong the motor is
     * @return returns the cars top speed
     */
    @Override
    public double speedFactor(double enginePower) {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
