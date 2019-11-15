package com.company;
import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;


    /**Specifies the cars attributes
     *
     * @param nrDoors number of doors
     * @param enginePower how strong the motor is
     * @param color the color of the car
     * @param modelName the name of the car model
     * @param position where the cars position is
     */

    public Volvo240(int nrDoors, double enginePower, Color color, String modelName, Position position){
        super(nrDoors, enginePower, color, modelName, position);
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }


    /**This method says how fast the car can go
     *
     * @param enginePower how strong the motor is
     * @return returns the cars top speed
     */
    @Override
    public double speedFactor(double enginePower){
        return enginePower * 0.01 * trimFactor;
    }
}


