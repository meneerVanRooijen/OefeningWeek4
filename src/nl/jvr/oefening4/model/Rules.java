/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jvr.oefening4.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author vanrooijen
 */
public class Rules {
    private ArrayList<nl.jvr.oefening4.model.Shape> shapes = new ArrayList();
    
    public boolean shapesCorrect(ArrayList<Shape> shapes) {
        Color lastColor = null;
        boolean coloursEqual = true;
        for(Shape shape : shapes) {
            if(lastColor == null) {
                lastColor = shape.getColor();
            }
            else {
                if(lastColor != shape.getColor()) {
                    coloursEqual = false;
                    break;
                }
                lastColor = shape.getColor();
            }
        }
        return coloursEqual;
    }
}