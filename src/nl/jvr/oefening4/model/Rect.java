/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jvr.oefening4.model;

import java.awt.Color;
import java.awt.Graphics;
import nl.jvr.oefening4.model.Shape;

/**
 *
 * @author vanrooijen
 */
public class Rect extends Shape {
    
    public void drawImage(Graphics g, int posX, int posY) {
        super.drawImage(g, posX, posY);
        g.fillRect(posX, posY, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.drawRect(posX, posY, getWidth(), getHeight());
    }
    
}
