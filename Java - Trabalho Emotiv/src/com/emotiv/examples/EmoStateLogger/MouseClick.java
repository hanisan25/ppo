package com.emotiv.examples.EmoStateLogger;

/**
 * Created by alkimo on 9/21/2016.
 */

import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseClick {
    public static void main(String[] args){

    }

    public MouseClick(){
        try{
            Robot robot = new Robot();
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
