package com.company;

import java.awt.*;

/**
 * The Car class describe different cars that can be moved in different directions and speed.
 */

public abstract class Car implements Movable {
    private int nrDoors;
    private double enginePower;
    private Color color;
    private String modelName;
    private double currentSpeed;
    private Position position;
    private direction currentDirection = direction.NORTH;

    /**
     * Describes what the cars attributes are.
     *
     * @param nrDoors     number of doors
     * @param enginePower how strong the motor is
     * @param color       the color of the car
     * @param modelName   the name of the car model
     * @param position    where the cars position is
     */

    Car(int nrDoors, double enginePower, Color color, String modelName, Position position) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.position = position;
    }

    public direction getCurrentDirection() {
        return currentDirection;
    }

    double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    /**
     * The method startEngine makes the car move with a specific speed.
     */

    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * The method stopEngine setts the cars speed to 0 and makes it stop.
     */

    void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * The move method starts the car and gives it a speed in a specific direction.
     */

    @Override
    public void move() {
        startEngine();
        if (currentDirection == direction.NORTH) {
            position.setY(position.getY() + currentSpeed);
        } else if (currentDirection == direction.SOUTH) {
            position.setY(position.getY() - currentSpeed);
        } else if (currentDirection == direction.WEST) {
            position.setX(position.getX() - currentSpeed);
        } else if (currentDirection == direction.EAST) {
            position.setX(position.getX() + currentSpeed);
        } else {
            System.out.printf(this.getClass().getSimpleName() + ": move: not valid direction");
        }
    }

    /**
     * The turnLeft method changes the cars direction counter clockwise
     */

    @Override
    public void turnLeft() {
        if (currentDirection == direction.NORTH) {
            currentDirection = direction.WEST;
        } else if (currentDirection == direction.WEST) {
            currentDirection = direction.SOUTH;
        } else if (currentDirection == direction.SOUTH) {
            currentDirection = direction.EAST;
        } else if (currentDirection == direction.EAST) {
            currentDirection = direction.NORTH;
        }
    }

    /**
     * The turnRight method changes the cars direction clockwise.
     */

    @Override
    public void turnRight() {
        if (currentDirection == direction.NORTH) {
            currentDirection = direction.EAST;
        } else if (currentDirection == direction.WEST) {
            currentDirection = direction.NORTH;
        } else if (currentDirection == direction.SOUTH) {
            currentDirection = direction.WEST;
        } else if (currentDirection == direction.EAST) {
            currentDirection = direction.SOUTH;
        }
    }

    /**
     * This method says how fast the car can go
     *
     * @param enginePower how strong the motor is
     * @return returns the cars top speed
     */

    public abstract double speedFactor(double enginePower);

    /**
     * The method gas accelerate the speed. The speed can't go over engine power.
     *
     * @param amount How much we will increase the speed.
     */

    public void gas(double amount) {
        if (currentSpeed < enginePower && amount >= 0 && amount <= 1) {
        } else if (amount < 0) {
            amount = 0;
        } else if (amount > 1) {
            amount = 1;
        }
        incrementSpeed(amount);
    }

    /**
     * The method brake slows down the speed. Can't get under 0.
     *
     * @param amount How much we will decrease the speed.
     */

    public void brake(double amount) {
        if (currentSpeed > 0 && amount >= 0 && amount <= 1) {
            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
        } else if (amount < 0) {
            amount = 0;
        } else if (amount > 1) {
            amount = 1;
        }
        decrementSpeed(amount);
    }


    /**
     * incrementSpeed increases the cars speed.
     *
     * @param amount How much we will increase the speed.
     */

    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor(enginePower) * amount, enginePower));
    }

    /**
     * The method decrementSpeed decreases the cars speed.
     *
     * @param amount How much we will decrease the speed.
     */

    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor(enginePower) * amount, 0));

    }

    /**
     * Are the different directions the cars can move in
     */
    enum direction {
        NORTH, SOUTH, WEST, EAST
    }
}
