import java.awt.*;
import javax.swing.*;;

public class Calculator extends JFrame {

    JTextField screen;

    public Calculator(){
        setTitle("계산기");
        setSize(340, 540);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        screen = new JTextField();  //화면 만들기
        screen.setEditable(false); //화면에 글 못쓰게 하기
        add(screen);

        JPanel button = new JPanel();
        button.setLayout(new GridLayout(6,4));
        
        JButton buttons = new JButton();
        /*buttons = {
            "%", "CE", "C", "<-",
            "1/x", "x^2", "루트x", "/",
            "7", "8", "9", "X",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "=",
        
        */
        add(button);
        add(buttons);
    }

    
    public static void main(String[] args) {
        new Calculator();
    }
}
