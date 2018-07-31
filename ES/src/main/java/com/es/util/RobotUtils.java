package com.es.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotUtils {
	public static void uploadFile(){
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_0);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
