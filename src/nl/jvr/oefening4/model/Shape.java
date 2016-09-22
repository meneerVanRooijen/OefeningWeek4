/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jvr.oefening4.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author vanrooijen
 */
public class Shape {
    
    private Color color;
    private int width = 60;
    private int height = 60;
    private int positionX = 0;
    private int positionY = 0;

    public void drawImage(Graphics g, int posX, int posY) {
        positionX = posX;
        positionY = posY;
        g.setColor(color);
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }
    
    public boolean collision(int x, int y) {
        if( (x >= positionX)
           && (x <= positionX + width)
           && (y >= positionY)
           && (y <= positionY + height)
        ) {
           return true;
        }
        else { 
           return false;
        }
    }
}