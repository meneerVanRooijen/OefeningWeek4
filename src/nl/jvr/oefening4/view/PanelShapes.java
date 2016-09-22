/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jvr.oefening4.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import nl.jvr.oefening4.model.Oval;
import nl.jvr.oefening4.model.Rect;
import nl.jvr.oefening4.model.Rules;
import nl.jvr.oefening4.model.Shape;

/**
 *
 * @author vanrooijen
 */
class PanelShapes extends JPanel implements MouseListener {
    
    private final int numberOfShapes = 4;
    private ArrayList<Shape> shapes = new ArrayList();
    private ArrayList<Color> colours = new ArrayList();
    private Rules rules = new Rules();

    public PanelShapes() {
        setLayout(null);
        Random random = new Random();
        Shape newShape;
        colours.add(Color.RED);
        colours.add(Color.BLUE);
        colours.add(Color.GREEN);
        colours.add(Color.BLACK);
        for (int i = 0; i < numberOfShapes; i++) {
            int randomShape = random.nextInt(2);
            if (randomShape == 1) {
                newShape = new Rect();
            } else {
                newShape = new Oval();
            }
            int randomColor = random.nextInt(colours.size());
            newShape.setColor(colours.get(randomColor));
            shapes.add(newShape);
        }
        JButton changeNumberOfShapes = new JButton("Pas aantal vormen aan");
        JTextField inputNumberOfShapes = new JTextField(5);
        JButton checkResult = new JButton("Controleer combinatie");
        checkResult.addActionListener(new CheckResult());
        changeNumberOfShapes.setBounds(40, 200, 200, 40);
        inputNumberOfShapes.setBounds(240, 200, 50, 40);
        checkResult.setBounds(40, 260, 200, 40);
        add(changeNumberOfShapes);
        add(inputNumberOfShapes);
        add(checkResult);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 20;
        int y = 20;
        for (Shape shape : shapes) {
            shape.drawImage(g, x, y);
            x += shape.getWidth() + 30;
        }
    }

    class CheckResult implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String messageText = "";
            if (rules.shapesCorrect(shapes)) {
                messageText = "Colours are equal!";
            } else {
                messageText = "Colours are different!";
            }
            JOptionPane.showMessageDialog(null, messageText);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Shape shape : shapes) {
            if (shape.collision(e.getX(), e.getY())) {
                //shape.setColor(Color.BLUE);
                int currentColor = colours.indexOf(shape.getColor());
                if (currentColor == colours.size() - 1) {
                    currentColor = -1;
                }
                shape.setColor(colours.get(currentColor + 1));
                repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
