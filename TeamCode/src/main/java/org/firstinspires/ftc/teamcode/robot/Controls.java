package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.teamcode.robot.utils.Functions;

public class Controls {

   Robot robot;
   Gamepad gamepad1;
   Gamepad gamepad2;
   ButtonMgr buttonMgr;
   Navigator navigator;
   public double DriveSpeed, DriveAngle, Rotate, liftSpeed;

   /* Constructor */
   public Controls(Robot robot){
      construct(robot);
   }

   void construct(Robot robot){
      this.robot = robot;
      this.gamepad1 = robot.opMode.gamepad1;
      this.gamepad2 = robot.opMode.gamepad2;
      this.buttonMgr = robot.buttonMgr;
      this.navigator = robot.navigator;
   }

   void init() {

   }

   public void loop() {
      userInput();
      navigator.setUserDriveSettings(DriveSpeed, DriveAngle, Rotate);
   }

   public void userInput() {

      // TeleOp / normal drive

      // Get speed and direction from left stick
      DriveSpeed = JavaUtil.minOfList(JavaUtil.createListWith(1, Functions.mathHypotenuse(gamepad1.left_stick_x, gamepad1.left_stick_y)));
      DriveAngle = Math.atan2(-gamepad1.left_stick_x, -gamepad1.left_stick_y) / Math.PI * 180;
      // Get rotation from right stick
      Rotate = Math.pow(gamepad1.right_stick_x, 1);
      navigator.handleRotate(Rotate);

      // Toggle FCD
      if (buttonMgr.wasTapped(1, ButtonMgr.Buttons.start))
         navigator.toggleFieldCentricDrive();

      // Toggle HeadingHold
      if (buttonMgr.wasTapped(1, ButtonMgr.Buttons.back))
         navigator.toggleHeadingHold();

      // Store heading correction
      if (buttonMgr.wasReleased(1, ButtonMgr.Buttons.right_stick_button))
         navigator.setDeltaHeading();

      if (buttonMgr.wasReleased(1, ButtonMgr.Buttons.left_stick_button));
//         navigator.toggleSnapToAngle();

      // This blob is for manually entering destinations by adjusting X, Y, Rot
      if (buttonMgr.wasTapped(1, ButtonMgr.Buttons.dpad_up));
//         navigator.setTargetByDeltaRelative(2,0,0);
      if (buttonMgr.wasTapped(1, ButtonMgr.Buttons.dpad_down));
//         navigator.setTargetByDeltaRelative(-2,0,0);
      if (buttonMgr.wasTapped(1, ButtonMgr.Buttons.dpad_left));
//         navigator.setTargetByDeltaRelative(0, 2,0);
      if (buttonMgr.wasTapped(1, ButtonMgr.Buttons.dpad_right));
//         navigator.setTargetByDeltaRelative(0, -2,0);
      if (buttonMgr.wasTapped(1, ButtonMgr.Buttons.x)) {
//         navigator.setTargetRotBySnapRelative (45);
//         navigator.headingDelay = System.currentTimeMillis() + 500;  // workaround
      }
      if (buttonMgr.wasTapped(1, ButtonMgr.Buttons.y)) {
//         navigator.setTargetRotBySnapRelative (-45);
//         navigator.headingDelay = System.currentTimeMillis() + 500;  // workaround
      }

      if (!buttonMgr.isPressed(1, ButtonMgr.Buttons.right_bumper));
//         navigator.setMaxSpeed(1);
      else;
//         navigator.setMaxSpeed(0.25);

      // AutoDrive Testing

      liftSpeed = -gamepad2.left_stick_y;

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.dpad_left));
//         lifter.action(LiftbotLifter.LiftActions.AUTOMATE_PREP_CAPTURE);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.dpad_down));
//         lifter.action(LiftbotLifter.LiftActions.AUTOMATE_PREP_DEPOSIT_LO);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.dpad_right));
//         lifter.action(LiftbotLifter.LiftActions.AUTOMATE_PREP_DEPOSIT_MED);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.dpad_up));
//         lifter.action(LiftbotLifter.LiftActions.AUTOMATE_PREP_DEPOSIT_HI);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.back));
//         lifter.action(LiftbotLifter.LiftActions.CANCEL);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.a));
//         lifter.action(LiftbotLifter.LiftActions.AUTOMATE_CAPTURE);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.b));
//         lifter.action(LiftbotLifter.LiftActions.GRAB_TOGGLE);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.y));
//         lifter.action(LiftbotLifter.LiftActions.LIFT_LOWER_TO_DEPOSIT);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.x));
//         lifter.action(LiftbotLifter.LiftActions.LIFT_RAISE_AFTER_CAPTURE);

      if (buttonMgr.isHeld(2, ButtonMgr.Buttons.left_bumper) &&
              buttonMgr.wasTapped(2, ButtonMgr.Buttons.right_bumper));
//         lifter.action(LiftbotLifter.LiftActions.AUTOMATE_HOME);

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.right_bumper)) {
         if (buttonMgr.isHeld(2, ButtonMgr.Buttons.left_bumper)) {
//            lifter.action(LiftbotLifter.LiftActions.AUTOMATE_HOME);
         } else {
            // reserved for future use
         }
      }

      if (buttonMgr.wasTapped(2, ButtonMgr.Buttons.left_bumper));
//         lifter.action(LiftbotLifter.LiftActions.LIFT_DOWNSTACK);


   }
}
