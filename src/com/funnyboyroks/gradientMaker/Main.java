package com.funnyboyroks.gradientMaker;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Rainbow rainbow = new Rainbow();
        rainbow.setNumberRange(1, 5);
        rainbow.setSpectrumByArrayList(new ArrayList<String>(Arrays.asList("ff0000", "00ff00")));

        ArrayList<String> hexCodes = new ArrayList<String>();
        for (var i = 1; i <= 5; i++) {
            String hexColour = rainbow.colourAt(i);
            hexCodes.add("#" + hexColour);
        }
        System.out.println("hexCodes = " + hexCodes.toString());
    }
}

