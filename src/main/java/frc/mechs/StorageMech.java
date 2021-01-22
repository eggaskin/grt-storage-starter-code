package frc.mechs;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.AnalogInput;
import frc.config.Config;

public class StorageMech {
    // feel free to rename and reorganize these variables
    /* IR sensors */
    private AnalogInput irTop, irMiddle, irBottom, irRamp;
    /* Talon SRX motor controller. */
    private TalonSRX motor;

    /* if the analog input value is greater than this number, then 
    there is a lemon in front of the sensor */
    private static final int LEMON_THRESHOLD = 1200;


    public StorageMech() {
        this.motor = new WPI_TalonSRX(Config.getInt("motor_id"));
        this.irTop = new AnalogInput(Config.getInt("ir0_id"));
        this.irMiddle = new AnalogInput(Config.getInt("ir1_id"));
        this.irBottom = new AnalogInput(Config.getInt("ir2_id"));
        this.irRamp = new AnalogInput(Config.getInt("ir3_id"));
    }

    /**
     * this function is called periodically during teleop
     */
    public void update() {
        // take input from sensors and make motors move here

        //making booleans for if ir sensors are triggered by a power cell, to make code cleaner

        //boolean rampCell = irRamp.getValue() > LEMON_THRESHOLD; //where 5th power cell would be
        boolean topCell = irTop.getValue() > LEMON_THRESHOLD; //at top of shaft
        boolean bottomCell = irBottom.getValue() > LEMON_THRESHOLD; //in front of tubing, on ramp
        //boolean middleCell = irMiddle.getValue() > LEMON_THRESHOLD; //behind tubing, on ramp

        //if there is space in the vertical shaft behind the tubing (no cell at the top)
        //, power cells can be moved into it.
        if(!topCell) { 
            //power cells are only moved behind the tubing if there is a power cell by
            //the tubing to be moved, otherwise it should not move (could cause jams)
            if (bottomCell) {
                motor.set(ControlMode.PercentOutput, 0.5);
            } else if (!bottomCell) {
                motor.set(ControlMode.PercentOutput, 0);
            }
            //if nothing interferes with the mechanism, there should 
            //always be a ball at the bottom of the tubing
        }
        

        //if there is a power cell at the top, there should be 3 under it and so there will be
        // no space in the vertical shaft behind the tubing (3 stacked), so no jamming.
        //then, the belt should not move as to not push them into the shooter
        else {
            motor.set(ControlMode.PercentOutput, 0);
        }
    
    }
}
