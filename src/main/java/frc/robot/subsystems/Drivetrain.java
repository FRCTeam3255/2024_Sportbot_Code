// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private TalonFX frontRightMotor;
  private TalonFX frontLeftMotor;
  private TalonFX backRightMotor;
  private TalonFX backLeftMotor;

  public Drivetrain() {
    frontRightMotor = new TalonFX(RobotMap.mapDriveTrain.FRONT_RIGHT_MOTOR);
    backRightMotor = new TalonFX(RobotMap.mapDriveTrain.BACK_RIGHT_MOTOR);
    frontLeftMotor = new TalonFX(RobotMap.mapDriveTrain.FRONT_LEFT_MOTOR);
    backLeftMotor = new TalonFX(RobotMap.mapDriveTrain.BACK_LEFT_MOTOR);
  }

  /**
   * Sets the velocity of the drivetrain motors.
   * 
   * @param forwardVelocity The velocity to set for the forward movement of the drivetrain.
   * @param rotationSpeed The rotation speed to apply to the drivetrain.
   */
  public void setDrivetrainSpeed(double forwardVelocity, double rotationSpeed) {
    // Set right velocity
    frontRightMotor.set(forwardVelocity - rotationSpeed);
    backRightMotor.set(forwardVelocity - rotationSpeed);

    // Set left velocity
    frontLeftMotor.set(forwardVelocity + rotationSpeed);
    backLeftMotor.set(forwardVelocity + rotationSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
 