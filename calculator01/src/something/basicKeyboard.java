package something;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class basicKeyboard extends JPanel{

    private State state = new State(false, false, false);

    public basicKeyboard()
    {
        setLayout(new BorderLayout());
        Calculator.display = new JTextPane();
        Calculator.display.setText(state.toString());
        Calculator.display.setEnabled(false);

        //Calculator.display.setFont(new Font("Dialog",Font.PLAIN,18));
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

        basicKeyboard.setLayout(new GridLayout(4,4));
        String[] buttons = new String[]{"7", "8", "9", "/",
                                        "4", "5", "6", "*",
                                        "1", "2", "3", "-",
                                        "0", "C", "=", "+"};
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
                switch (str){
                    case "7": state.setState(7); break;
                    case "8": state.setState(8); break;
                    case "9": state.setState(9); break;
                    case "/": state.setState('/'); break;
                    case "4": state.setState(4); break;
                    case "5": state.setState(5); break;
                    case "6": state.setState(6); break;
                    case "*": state.setState('*'); break;
                    case "1": state.setState(1); break;
                    case "2": state.setState(2); break;
                    case "3": state.setState(3); break;
                    case "-": state.setState('-'); break;
                    case "0": state.setState(0); break;
                    case "C": state.initState(); break;
                    case "=": state.setState('='); break;
                    case "+": state.setState('+'); break;
                }
                Calculator.display.setText(state.toString());
            }
        });
    }
}
