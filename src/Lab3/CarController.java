package Lab3;

import lab1.*;
import lab2.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
   ArrayList<Cars> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                int x = (int) Math.round(car.getXPos());
                int y = (int) Math.round(car.getYPos());
                if (y <0 ){
                    car.turnRight();
                    car.turnRight();
                }
                if (y > 500 ){
                    car.turnLeft();
                    car.turnLeft();
                }
                frame.drawPanel.moveit(x, y,car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : cars){
            car.gas(gas);
        }
    }
    void brake(double amount){
        double brake = amount/100;
        for(Cars car : cars){
            car.brake(brake);
        }

    }

    void startAllCars(){
        for (Cars car: cars){
            car.startEngine();
        }
    }
    void stopAllCars(){
        for (Cars car : cars){
            car.stopEngine();
        }
    }
    void SaabTurboOn(){
        for (Cars bil : cars){
            if (bil instanceof Saab95){
                ((Saab95) bil).setTurboOn();

            }
        }
    }
    void SaabTurboOff(){
        for (Cars bil : cars){
            if (bil instanceof Saab95){
                ((Saab95) bil).setTurboOff();

            }
        }
    }
    void ScaniaBedUp(){
        for (Cars bil : cars){
            if (bil instanceof Scania){
                ((Scania) bil).RaiseAngle(70);
            }
        }
    }
    void ScaniaBedDown(){
        for (Cars bil : cars){
            if (bil instanceof Scania){
                ((Scania) bil).LowerAngle(70);
            }
        }
    }
}

