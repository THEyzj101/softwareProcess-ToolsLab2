package something;

import java.awt.*;
import javax.swing.*;

public class BasicFrame {
    static JFrame jf;

    public BasicFrame(){
        jf = new JFrame("BasicCalculator");

        JMenuBar menuBar = new JMenuBar();
        JMenu editMenu = new JMenu("Edit");
        JMenu funcMenu = new JMenu("Function");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(editMenu);
        menuBar.add(funcMenu);
        menuBar.add(helpMenu);
        jf.setJMenuBar(menuBar);
        JMenuItem basic = new JMenuItem("Basic");

        JMenuItem programmer = new JMenuItem("Programmer's");
        JMenuItem about = new JMenuItem("About..");


        editMenu.add(basic);
        basic.addActionListener(new MenuItemListener());

        editMenu.add(programmer);
        programmer.addActionListener(new MenuItemListener());


        helpMenu.addSeparator();
        helpMenu.add(about);
        about.addActionListener(new MenuItemListener());

        Container cp = jf.getContentPane();
        cp.add(new basicKeyboard());
        jf.setSize(300,400);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
