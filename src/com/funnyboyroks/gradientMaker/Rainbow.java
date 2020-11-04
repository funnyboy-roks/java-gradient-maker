package com.funnyboyroks.gradientMaker;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Rainbow{
    private ArrayList<ColourGradient> gradients;
    private int minNum = 0;
    private int maxNum = 100;
    ArrayList<String> colours;
    public Rainbow(){
        setColours(new ArrayList<String>(Arrays.asList("ff0000", "ffff00", "00ff00", "0000ff")));
    }

    public void setColours(ArrayList<String> spectrum){
        if(spectrum.size() < 2) {
            System.out.println("Rainbow must have >= 2 values");
        }else{
            int increment = (this.maxNum - this.minNum)/(spectrum.size() - 1);
            ColourGradient firstGradient = new ColourGradient();
            firstGradient.setGradient(spectrum.get(0), spectrum.get(1));
            firstGradient.setNumberRange(minNum, minNum + increment);
            gradients = new ArrayList<ColourGradient>(Arrays.asList(firstGradient));

            for (int i = 1; i < spectrum.size() - 1; i++) {
                var colourGradient = new ColourGradient();
                colourGradient.setGradient(spectrum.get(i), spectrum.get(i+1));
                colourGradient.setNumberRange(
                        minNum + increment * i,
                        minNum + increment * (i + 1)
                );
                gradients.add(i, colourGradient);
            }
            colours = spectrum;
        }
    }

    public void setSpectrum(String[] args){
        ArrayList<String> strs = new ArrayList<String>();
        Collections.addAll(strs, args);
        setColours(strs);
    }

    public void setSpectrumByArrayList(ArrayList<String> arr){
        setColours(arr);
    }

    public String colourAt(int number){
        if(false){
            throw new Error(number + " is not a number");
        }else if(gradients.size() == 1){
            return gradients.get(0).colourAt(number);
        }else{
            int segment = (maxNum - minNum) / gradients.size();
            int index = Math.min(
                    (int) Math.floor((Math.max(number, minNum) - minNum) / segment),
                    gradients.size() - 1
            );
            return gradients.get(index).colourAt(number);
        }
    }

   public void setNumberRange(int minNumber, int maxNumber) {
        if (maxNumber > minNumber) {
            minNum = minNumber;
            maxNum = maxNumber;
            setColours(colours);
        } else {
            throw new Error(
                    "maxNumber (" +
                            maxNumber +
                            ") is not greater than minNumber (" +
                            minNumber +
                            ")"
            );
        }
    };



}
