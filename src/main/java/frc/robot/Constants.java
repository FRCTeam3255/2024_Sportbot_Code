// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class Constants {
    public static class constDrivetrain {
      public static final double SLOW_MODE_MULTIPLIER = 0.5;
      public static final double CONTROLLER_DEADZONE = 0.2;
    }

  public static class constIntake {
    public static final double INTAKE_EJECT_VELOCITY = -0.5;
    public static final double INTAKE_VELOCITY = 0.5;
  }

  public static class constHopper {
    public static final double HOPPER_ORIENTATION_SPEED = 0.5;
  }

  public static class constShooter {
    public static final double PROPEL_MOTOR_VELOCITY = 0.6;
    public static final double SPIRAL_MOTOR_VELOCITY = 0.8;
  }

  public static class constStager {
    public static final double STAGER_MOTOR_VELOCITY = 0.3;
    public static final double TOP_STAGER_MOTOR_VELOCITY = 0.3;
  }
}
