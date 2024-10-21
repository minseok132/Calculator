import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class Calculator extends JFrame {

    JTextField screen;
    String a1;
    double num1, num2, result;

    public Calculator(){
        setTitle("계산기");
        setSize(340, 540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //프로그램을 화면 가운데로 띄움
        setLayout(new BorderLayout(3,3));

        screen = new JTextField("0");  //화면 만들기
        screen.setEditable(false); //화면에 글 못쓰게 하기
        screen.setSize(10,10);
		screen.setHorizontalAlignment(JTextField.RIGHT);//정렬위치 설정
        add(screen, BorderLayout.NORTH);
        

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,4,3,3));
        
        String[] buttons = {
            "%", "CE", "C", "<-",
            "1/x", "x^2", "루트x", "/",
            "7", "8", "9", "X",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "=",
        };

        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);
            //button.addActionListener(this); 버튼 눌렀을때 액션을 넣어야 되는데 모르겠음..
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

//https://ttmcr.tistory.com/entry/JAVA-JFrame%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EA%B3%84%EC%82%B0%EA%B8%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0-%EC%86%8C%EC%8A%A4-%EC%BD%94%EB%93%9C 참고하기
