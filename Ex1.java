import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1 extends JFrame implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double num1, num2, result;

    public Ex1() {
        setTitle("계산기");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //프로그램을 화면 가운데로 띄움
        setLayout(new BorderLayout(3,3));

        display = new JTextField("");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);//정렬위치 설정
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 3, 3));

        String[] buttons = {
                "%", "CE", "C", "<-",
                "1/x", "x^2", "루트x", "/",
                "7", "8", "9", "X",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "=",
            };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            operator = "";
        }
        else if (command.equals("<-")) {
        	double currentValue = Double.parseDouble(display.getText());
            currentValue = currentValue/10 - (currentValue%10 *0.1);
            display.setText(String.valueOf(currentValue));
        }
        else if (command.equals("+/-")) {
            double currentValue = Double.parseDouble(display.getText());
            currentValue *= -1; // 부호 변경
            display.setText(String.valueOf(currentValue)); 
        }
        else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            operator = "";
        } else {
            if (!operator.isEmpty()) {
                return;
            }
            operator = command;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ex1 calculator = new Ex1();
            calculator.setVisible(true);
        });
    }
}
