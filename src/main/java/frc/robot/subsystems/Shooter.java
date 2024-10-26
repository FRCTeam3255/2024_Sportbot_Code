// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  TalonFX propelMotor;
  TalonFX spinMotor;

  public Shooter() {
    propelMotor = new TalonFX(10);
    spinMotor = new TalonFX(11);
  }

  public void setShooterVelocity(double velocity) {
    // Replace with actual code
  }

  public double getShooterVelocity() {
    // Replace with actual code
    return 0; // This is temporary replace with actual code
  }

  public void setPropelVelocity(double velocity) {
    // Replace with actual code
  }

  public double getPropelVelocity() {
    // Replace with actual code
    return 0; // This is temporary replace with actual code
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
