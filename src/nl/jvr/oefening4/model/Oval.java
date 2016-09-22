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
public class Oval extends Shape {
    
    public void drawImage(Graphics g, int posX, int posY) {
        super.drawImage(g, posX, posY);
        g.fillOval(posX, posY, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawOval(posX, posY, getWidth(), getHeight());
    }
    
}
