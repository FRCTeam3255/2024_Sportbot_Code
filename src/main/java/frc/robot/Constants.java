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

  public static class constLED {
    public static final double LED_BRIGHTNESS = 1;
    public static final int LED_NUMBER = 192;
    public static final int LED_STRIP_START_INDEX = 8;
    public static final int[] CLEAR_LEDS = { 0, 0, 0 };
    public static final int[] LED_SHOOTING = { 105, 69, 9 };
    public static final int[] LED_PREP_SHOOTING = { 254, 212, 6 };
    public static final int[] LED_NONE = { 2, 157, 254 };
    public static final int[] LED_INTAKE_HOPPER = { 133, 249, 1 };
    public static final int[] LED_INTAKE_GROUND = { 187, 1, 249 };
    public static final int[] LED_HASGP = { 249, 1, 109 };
    public static final int[] LED_FULL_HOPPER = { 255, 255, 255 };
    public static final int[] LED_EJECT_INTAKE = { 3, 242, 230 };
    public static final int[] LED_EJECT_SHOOTER = { 242, 3, 230 };

    public static final int[] LED_DRIVE = { 109, 11, 140 };

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
    public static final double PROPEL_MOTOR_VELOCITY_EJECT = 0.3;
    public static final double SPIRAL_MOTOR_VELOCITY_EJECT = 0.3;
    public static final double PROPEL_MOTOR_VELOCITY_EJECT_REQUIREMENT = 0.2;
    public static final double SPIRAL_MOTOR_VELOCITY_EJECT_REQUIREMENT = 0.2;
  }

  public static class constStager {
    public static final double STAGER_MOTOR_VELOCITY = 0.3;
  }
}
