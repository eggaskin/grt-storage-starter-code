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

    /* if the analog input value is greater than this number, then there is a lemon in front of the sensor */
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
        if (irTop.getValue() > LEMON_THRESHOLD) {
            motor.set(ControlMode.PercentOutput, 0.5);
        }
    }
}
