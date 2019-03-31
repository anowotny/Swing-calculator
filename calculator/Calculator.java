package calculator; //4

import org.mariuszgromada.math.mxparser.Expression;
import sun.swing.MenuItemLayoutHelper;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.List;

public class Calculator {
    private JButton evaluateButton;
    private JList list1;
    private JTextArea textArea1;
    private JPanel myPanel;
    private JTextField textField1;
    private JMenuBar menuBar;
    private JMenu myMenu;

    public Calculator() {
        JFrame myFrame = new JFrame("Calculator");
        menuBar = new JMenuBar();
        myFrame.setJMenuBar(menuBar);

        myMenu = new JMenu("Options");
        myMenu.setMnemonic(KeyEvent.VK_O);

        JMenuItem reset = new JMenuItem("Reset");
        myMenu.add(reset);
        JMenuItem exit = new JMenuItem("Exit");
        myMenu.add(exit);
        menuBar.add(myMenu);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    textField1.setText(null);
                    textArea1.setText(null);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

       // JScrollPane p1(textArea1);
        // JScrollPane p2= new JScrollPane(list1);
        // p1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // p2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        myFrame.setContentPane(this.myPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
        myFrame.setSize(600, 400);

        textField1.addActionListener(new ActionListener() {
            String myText = textField1.getText();

            @Override
            public void actionPerformed(ActionEvent e) {
                Expression expression=new Expression(myText);
                Double result=expression.calculate();
                String lastRes=(" "+ result);
                if (e.equals(KeyEvent.VK_ENTER)) {
                       if(expression.checkSyntax()){
                        String put=(""+result);
                        textArea1.setText(put);

                    }
                }

                else if(e.equals(KeyEvent.VK_UP)){
                    lastRes=textField1.getText();
                    textArea1.setText(lastRes);
                }
            }
        });

        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expression expression = new Expression(textField1.getText());
                if (expression.checkSyntax()) {
                    Double result = expression.calculate();
                    String putToArea = (" " + result);
                    textArea1.setText(putToArea);
                    String LastResult=putToArea;

                }
                else {
                    JOptionPane.showMessageDialog(null,"wrong syntax or input","error",JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (list1.getSelectedValue().toString().equals("sin")) {
                    textField1.setText(textField1.getText() + "sin()");

                } else if (list1.getSelectedValue().toString().equals("cos")) {
                    textField1.setText(textField1.getText() + "cos()");
                } else if (list1.getSelectedValue().toString().equals("tg")) {
                    textField1.setText(textField1.getText() + "tg()");
                } else if (list1.getSelectedValue().toString().equals("ctg")) {
                    textField1.setText(textField1.getText() + "ctg()");
                } else if (list1.getSelectedValue().toString().equals("+")) {
                    textField1.setText(textField1.getText() + "+");
                } else if (list1.getSelectedValue().toString().equals("*")) {
                    textField1.setText(textField1.getText() + "*");
                } else if (list1.getSelectedValue().toString().equals("^")) {
                    textField1.setText(textField1.getText() + "^");
                } else if (list1.getSelectedValue().toString().equals("sqrt")) {
                    textField1.setText(textField1.getText() + "sqrt()");
                } else if (list1.getSelectedValue().toString().equals("pi")) {
                    textField1.setText(textField1.getText() + "pi");
                }
            }
        });
    }
}



