import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calc extends JFrame{
	
	JTextField t1, t2;
	JTextArea area;
	JButton cal;
	JComboBox cb;
	int a;
	double b;
	
	
	Calc(){
		setTitle("계산기");
		setLayout(new BorderLayout(5, 5));
		showNorth(); showSouth();
		setSize(300, 220);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void showNorth() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
		String[] color = {"+", "-"};
		cb = new JComboBox<>(color);
		cal = new JButton("정답");
		
		t1 = new JTextField(3);
		t2 = new JTextField(3);
		t2.setEnabled(true);
		
		p1.add(t1); p2.add(t2);
		panel.add(p1);
		panel.add(cb);
		panel.add(p2);
		panel.add(cal);
		
		add(panel, BorderLayout.NORTH);	
		
		cb.addItemListener(e ->{
			int index = ((JComboBox) cb).getSelectedIndex();;
			if(index == 0)
				a = 0;
			else if (index == 1)
				a = 1;
			});
		
		ActionListener listener1 = e -> {
			if (e.getSource() == cal) {
				if(t1.getText().isEmpty())
					area.setText("");
				else {
					String s1 = t1.getText();
					String s2 = t2.getText();
					double radius1 = Double.parseDouble(s1);
					double radius2 = Double.parseDouble(s2);
					if (a == 0)
						b = radius1 + radius2;
					else if(a == 1)
						b = radius1 - radius2;
					area.setText("정답 : " + b);
				}
			}else {
				t1.setText("");
				t2.setText("");
				area.setText("");
			}
		};	
		
		cal.addActionListener(listener1);
		
		
	}
	
	void showSouth() {
		JPanel panel = new JPanel();
		
		area = new JTextArea(1, 10);
		area.setEditable(false);
		area.setForeground(Color.RED);
		
		panel.add(area);
		
		add(panel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new Calc();
	}

}
