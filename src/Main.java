import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    // Declare variables
    static JFrame frame;
    static JTextField textField;
    static JButton[] numberButtons = new JButton[10]; // Array for number buttons (0-9)
    static JButton[] functionButtons = new JButton[18]; // Array for function buttons
    static JButton addBtn, subBtn, mulBtn, divBtn, eqBtn, decBtn, clrBtn, delBtn;
    static JButton sinBtn, cosBtn, tanBtn, sqrtBtn, powBtn, logBtn, lnBtn, expBtn;
    static JPanel panel;
    static double num1 = 0, num2 = 0, result = 0;
    static char operator;

    public static void main(String[] args) {
        // Create the main frame (window)
        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 450, 600);
        frame.setLayout(null);
        frame.setVisible(true);

        // Set font for the calculator display and buttons
        Font myfont = new Font("Arial", Font.BOLD, 20);

        // Create the text field to display the input/output
        textField = new JTextField();
        textField.setBounds(45, 25, 350, 50);
        textField.setFont(myfont);
        textField.setEditable(false); // Prevents user from manually editing the text field

        // Initialize basic function buttons (add, subtract, multiply, divide, etc.)
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        clrBtn = new JButton("Clear");
        delBtn = new JButton("Delete");
        decBtn = new JButton(".");
        eqBtn = new JButton("=");

        // Initialize scientific function buttons (sin, cos, tan, sqrt, etc.)
        sinBtn = new JButton("sin");
        cosBtn = new JButton("cos");
        tanBtn = new JButton("tan");
        sqrtBtn = new JButton("√");
        powBtn = new JButton("^");
        logBtn = new JButton("log");
        lnBtn = new JButton("ln");
        expBtn = new JButton("exp");

        // Add basic function buttons to the functionButtons array
        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = eqBtn;
        functionButtons[6] = delBtn;
        functionButtons[7] = clrBtn;

        // Add scientific function buttons to the functionButtons array
        functionButtons[8] = sinBtn;
        functionButtons[9] = cosBtn;
        functionButtons[10] = tanBtn;
        functionButtons[11] = sqrtBtn;
        functionButtons[12] = powBtn;
        functionButtons[13] = logBtn;
        functionButtons[14] = lnBtn;
        functionButtons[15] = expBtn;

        // Set font and focusability for all function buttons
        for (int i = 0; i < 16; i++) {
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }

        // Initialize and set properties for number buttons (0-9)
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }

        // Set positions for delete and clear buttons
        delBtn.setBounds(45, 500, 145, 50);
        clrBtn.setBounds(205, 500, 145, 50);

        // Create a panel to organize the buttons in a grid layout
        panel = new JPanel();
        panel.setBounds(45, 100, 350, 380);
        panel.setLayout(new GridLayout(6, 4, 10, 10)); // 6 rows, 4 columns, 10px spacing
        panel.setBackground(Color.GRAY);

        // Add scientific buttons and number buttons to the panel
        panel.add(sinBtn);
        panel.add(cosBtn);
        panel.add(tanBtn);
        panel.add(sqrtBtn);
        panel.add(powBtn);
        panel.add(logBtn);
        panel.add(lnBtn);
        panel.add(expBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulBtn);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(eqBtn);
        panel.add(addBtn);

        // Add components to the main frame
        frame.add(textField);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(panel);

        // Set action listeners for number buttons (appends the number to the display)
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + numberButtons[finalI].getText());
                }
            });
        }

        // Set action listener for the decimal button (appends a decimal point)
        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + ".");
            }
        });

        // Set action listeners for basic arithmetic operations (stores the first number and operator)
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
        });

        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        });

        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
        });

        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
        });

        // Set action listener for the equals button (performs the calculation and displays the result)
        eqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case '+': {
                        result = num1 + num2;
                        break;
                    }
                    case '-': {
                        result = num1 - num2;
                        break;
                    }
                    case '*': {
                        result = num1 * num2;
                        break;
                    }
                    case '/': {
                        result = num1 / num2;
                        break;
                    }
                }
                textField.setText(result + "");
                num1 = result; // Stores the result for potential further operations
            }
        });

        // Set action listener for the clear button (clears the display)
        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        // Set action listener for the delete button (removes the last character from the display)
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().isEmpty()) {
                    String txt = textField.getText();
                    textField.setText(txt.substring(0, txt.length() - 1));
                }
            }
        });

        // Set action listeners for scientific functions (calculates and displays the result)
        sinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(textField.getText())))));
            }
        });

        cosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(textField.getText())))));
            }
        });

        tanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(textField.getText())))));
            }
        });

        sqrtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.sqrt(Double.parseDouble(textField.getText()))));
            }
        });

        powBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '^';
                textField.setText("");
            }
        });

        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.log10(Double.parseDouble(textField.getText()))));
            }
        });

        lnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.log(Double.parseDouble(textField.getText()))));
            }
        });

        expBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.exp(Double.parseDouble(textField.getText()))));
            }
        });
    }
}
