package something;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.math.*;
import java.util.*;

public class MenuItemListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if("Basic".equals(e.getActionCommand())){
            new BasicFrame();
            ProgrammerFrame.jf.setVisible(false);
        }else if("Programmer's".equals(e.getActionCommand())){
            new ProgrammerFrame();
            BasicFrame.jf.setVisible(false);
        }else if ("About..".equals(e.getActionCommand())){
            JTextArea aboutarea = new JTextArea();
            aboutarea.setText("版权拥有：@杨延奇 @于子钧\n开发时间 2020.10.22\n");
            JOptionPane.showConfirmDialog(null,aboutarea,"关于 计算器",JOptionPane.PLAIN_MESSAGE);
        }
    }
}
