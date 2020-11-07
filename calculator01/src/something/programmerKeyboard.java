package something;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class programmerKeyboard extends JPanel{

    private ProgrammerBuf buf = new ProgrammerBuf();

    public programmerKeyboard()
    {
        setLayout(new BorderLayout());
        Calculator.display = new JTextPane();
        Calculator.display.setText(buf.toString());
        Calculator.display.setEnabled(false);

        Calculator.display.setFont(new Font("Dialog",Font.PLAIN,18));
        SimpleAttributeSet aSet = new SimpleAttributeSet();
        StyleConstants.setForeground(aSet, Color.blue);
        StyleConstants.setFontFamily(aSet, "lucida bright italic");
        StyleConstants.setFontSize(aSet, 18);

        SimpleAttributeSet bSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontFamily(bSet, "lucida typewriter bold");
        StyleConstants.setFontSize(bSet, 50);
        StyledDocument doc = Calculator.display.getStyledDocument();
        doc.setCharacterAttributes(105, doc.getLength()-105, aSet, false);
        doc.setParagraphAttributes(0, 104, bSet, false);
        JPanel basicPanel = new JPanel();
        basicPanel.add(Calculator.display);
        JPanel basicKeyboard = new JPanel();

        basicKeyboard.setLayout(new GridLayout(3,5));

        String[] buttons = new String[]{"BIN","7","8","9"," ",
                                        "DEC","4","5","6","Clear",
                                        "HEX","1","2","3","0"};
        for(String x:buttons){
            addButton(basicKeyboard,x);
        }
        add(basicPanel,BorderLayout.NORTH);
        add(basicKeyboard,BorderLayout.CENTER);
    }

    private void addButton(Container c,String str){
        JButton button = new JButton(str);
        button.setFont(new Font("Dialog",Font.PLAIN,20));
        c.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (str) {
                    case "7": buf.setBuf(7); Calculator.display.setText(buf.toString()); break;
                    case "8": buf.setBuf(8); Calculator.display.setText(buf.toString()); break;
                    case "9": buf.setBuf(9); Calculator.display.setText(buf.toString()); break;
                    case "4": buf.setBuf(4); Calculator.display.setText(buf.toString()); break;
                    case "5": buf.setBuf(5); Calculator.display.setText(buf.toString()); break;
                    case "6": buf.setBuf(6); Calculator.display.setText(buf.toString()); break;
                    case "1": buf.setBuf(1); Calculator.display.setText(buf.toString()); break;
                    case "2": buf.setBuf(2); Calculator.display.setText(buf.toString()); break;
                    case "3": buf.setBuf(3); Calculator.display.setText(buf.toString()); break;
                    case "Clear": buf.init(); Calculator.display.setText(buf.toString()); break;
                    case "BIN":  Calculator.display.setText(buf.toStringBin()); break;
                    case "DEC":  Calculator.display.setText(buf.toString()); break;
                    case "HEX":  Calculator.display.setText(buf.toStringHex()); break;

                }
            }
        });
    }
}
