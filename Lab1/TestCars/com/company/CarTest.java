package com.company;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {

    private Position startingPosition = new Position(0,0);


    @Test
    public void testMove(){
        Car c = new Volvo240(4, 100, Color.black , "Volvo240", startingPosition);
        c.move();
        assertTrue(startingPosition.getY() > 0);
    }


    @Test
    public void testTurnLeft(){
        Car c = new Volvo240(4, 100, Color.black , "Volvo240", startingPosition);
        c.turnLeft();

        assertSame(c.getCurrentDirection(), Car.direction.WEST);
    }

    @Test
    public void testTurnRight(){
        Car c = new Volvo240(4, 100, Color.black , "Volvo240", startingPosition);
        c.turnRight();

        assertSame(c.getCurrentDirection(), Car.direction.EAST);
    }

   @Test
    public void testGas(){
        Car c = new Volvo240(4, 100, Color.black , "Volvo240", startingPosition);
        double currentSpeed = c.getCurrentSpeed();

        c.gas(1);

        assertTrue(c.getCurrentSpeed() > currentSpeed );
    }

    @Test
    public void testBrake(){
        Car c = new Volvo240(4, 100, Color.black , "Volvo240", startingPosition);
        c.gas(1);
        double currentSpeed = c.getCurrentSpeed();
        c.brake(1);

        assertTrue(c.getCurrentSpeed()< currentSpeed);
    }

    @Test
    public void testStartEngine(){
        Car c = new Volvo240(4, 100, Color.black , "Volvo240", startingPosition);
        double currentSpeed = c.getCurrentSpeed();
        c.startEngine();

        assertTrue(c.getCurrentSpeed() > currentSpeed);
    }

    @Test
    public void testStopEngine(){
        Car c = new Volvo240(4, 100, Color.black , "Volvo240", startingPosition);
        c.gas(1);
        c.stopEngine();

        assertTrue(c.getCurrentSpeed() == 0);
    }

    @Test
    public void testSpeedFactorVolvo(){
        Car c = new Volvo240(4, 100, Color.black , "Volvo240", startingPosition);
        assertEquals(c.speedFactor(100), 1.25, 0.00001);
    }

    @Test
    public void testSpeedFactorSaab(){
        Car c = new Saab95(2, 125, Color.red, "Saab95", startingPosition);
        assertEquals(c.speedFactor(125), 1.25, 0.00001 );
    }

}
