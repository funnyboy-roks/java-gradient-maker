package com.funnyboyroks.gradientMaker;

import java.util.regex.Pattern;

public class ColourGradient {

//    var startColour = 'ff0000';
//    var endColour = '0000ff';
//    var minNum = 0;
//    var maxNum = 100;

    private String startColour = "ff0000";
    private String endColour = "0000ff";
    private int minNum = 0;
    private int maxNum = 100;

    public void setGradient(String colourStart, String colourEnd) {
        startColour = getHexColour(colourStart);
        endColour = getHexColour(colourEnd);
    }

    public String getHexColour(String s) {
        if (isHexColour(s)) {
            return s.substring(s.length() - 6, s.length());
        } else {
            String name = s.toLowerCase();
            throw new Error(s + " is not a valid colour.");
        }
    }

    public boolean isHexColour(String s) {
        Pattern pattern6 = Pattern.compile("^#?[0-9a-fA-F]{6}$");

        return pattern6.matcher(s).find();
    }

    public String formatHex(String hex) {
        if (hex.length() == 1) {
            return "0" + hex;
        }
        return hex;
    }

    public String calcHex(int number, String channelStart_Base16, String channelEnd_Base16) {
        int num = number;
        if (num < minNum) {
            num = minNum;
        }
        if (num > maxNum) {
            num = maxNum;
        }
        int numRange = maxNum - minNum;
        int cStart_Base10 = Integer.parseInt(channelStart_Base16, 16);
        int cEnd_Base10 = Integer.parseInt(channelEnd_Base16, 16);
        int cPerUnit = (cEnd_Base10 - cStart_Base10) / numRange;
        int c_Base10 = Math.round(cPerUnit * (num - minNum) + cStart_Base10);
        return formatHex(Integer.toHexString(c_Base10));
    }

    public String colourAt(int number) {
        return  calcHex(number, startColour.substring(0, 2), endColour.substring(0, 2)) +
                calcHex(number, startColour.substring(2, 4), endColour.substring(2, 4)) +
                calcHex(number, startColour.substring(4, 6), endColour.substring(4, 6));
    }

    public void setNumberRange(int minNumber, int maxNumber) {
        if (maxNumber > minNumber) {
            minNum = minNumber;
            maxNum = maxNumber;
        } else {
            throw new Error(
                    "maxNumber (" + maxNumber + ") is not greater than minNumber (" + minNumber + ")"
            );
        }
    };
}

