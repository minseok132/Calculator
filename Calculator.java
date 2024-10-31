import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator extends JFrame {

    JTextField screen;
    String a1;
    double num1, num2, result;
    char operator;

    public Calculator() {
        setTitle("계산기");
        setSize(340, 540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 프로그램을 화면 가운데로 띄움
        setLayout(new BorderLayout(3, 3));
        createMenu();

        screen = new JTextField("0");  // 화면 만들기
        screen.setFont(new Font("Arial", Font.PLAIN, 40));
        screen.setEditable(false); // 화면에 글 못쓰게 하기
        screen.setHorizontalAlignment(JTextField.RIGHT); // 정렬 위치 설정
        add(screen, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 3, 3));

        String[] buttons = {
            "%", "CE", "C", "<-",
            "1/x", "x^2", "√x", "/",
            "7", "8", "9", "X",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "=",
        };
        //버튼 추가하기
        for (String text : buttons) {
            JButton button = new JButton(text);
            if (text == "=") {
                button.setBackground(Color.BLUE);
                button.setForeground(Color.WHITE);
            }
            else if (text == "0" || text == "1" || text == "2" || text == "3" || text == "4" || text == "5" || text == "6" || text == "7" || text == "8" || text == "9" || text == "+/-" || text == ".") {
                button.setBackground(Color.WHITE);
            }
            else{
                button.setBackground(Color.lightGray);
            } //배경색 바꾸기
            button.setFont(new Font("Arial", Font.PLAIN, 20)); //글씨 폰트와 사이즈 바꾸기

            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    void createMenu() { 
		JMenuBar mb = new JMenuBar(); // 메뉴바 생성
		JMenuItem [] menuItem = new JMenuItem [4];
		String[] itemTitle = {"표준", "공학용", "설정", "종료"};
		JMenu screenMenu = new JMenu("메뉴");

		MenuActionListener listener = new MenuActionListener(); 
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); 
			menuItem[i].addActionListener(listener); 
			screenMenu.add(menuItem[i]);
		}
		mb.add(screenMenu); 
		setJMenuBar(mb); // 메뉴바를 프레임에 부착
	}
	class MenuActionListener implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); 
			switch(cmd) { // 메뉴 아이템의 종류 구분
				case "종료" : //메뉴에서 종료 누르면 꺼짐
					System.exit(0); break;
			}
		}
    }
    //https://blog.naver.com/rain483/220736445264    메뉴 관련 코드



    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "C":
                    screen.setText("0");
                    num1 = num2 = result = 0;
                    break;
                case "CE":
                    screen.setText("0");
                    break;
                case "<-":
                    String text = screen.getText();
                    if (text.length() > 1) {
                        screen.setText(text.substring(0, text.length() - 1));
                    } else {
                        screen.setText("0");
                    }
                    break;
                case "=":
                    num2 = Double.parseDouble(screen.getText());
                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case 'X':
                            result = num1 * num2;
                            break;
                        case '/':
                            result = num1 / num2;
                            break;
                        case '%':
                            result = num1 % num2;
                            break;
                        // 추가적인 연산자 처리
                    }
                    screen.setText(String.valueOf(result));
                    break;
                case "+":
                case "-":
                case "X":
                case "/":
                case "%":
                    num1 = Double.parseDouble(screen.getText());
                    operator = command.charAt(0);
                    screen.setText("0");
                    break;
                case "1/x":
                    num1 = Double.parseDouble(screen.getText());
                    if (num1 != 0) {
                        result = 1 / num1;
                        screen.setText(String.valueOf(result));
                    } else {
                        screen.setText("Error");
                    }
                    break;
                case "x^2":
                    num1 = Double.parseDouble(screen.getText());
                    result = num1 * num1;
                    screen.setText(String.valueOf(result));
                    break;
                case "√x":
                    num1 = Double.parseDouble(screen.getText());
                    if (num1 >= 0) {
                        result = Math.sqrt(num1);
                        screen.setText(String.valueOf(result));
                    } else {
                        screen.setText("Error");
                    }
                    break;
                default:
                    if (screen.getText().equals("0")) {
                        screen.setText(command);
                    } else {
                        screen.setText(screen.getText() + command);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
//gpt 도움