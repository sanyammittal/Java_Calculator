import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JavaGuiCalculator implements ActionListener {
	JFrame f1;
	JTextField t1;
	JButton btnPlus, btnMin, btnDiv, btnMul, btnZero, btnEq, btnDec, btnDel, btnExit;
	JButton nbtn[] = new JButton[10];
	Font ff1 = new Font("Ink.free", Font.BOLD, 30);
	JPanel panel;
	Double num1, num2, result;
	char opr;

	public JavaGuiCalculator() {
		f1 = new JFrame();
		f1.setSize(420, 500);
		f1.setTitle("CALCULATOR");
		f1.setLocationRelativeTo(null);
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.getContentPane().setBackground(new Color(255, 153, 51));
		f1.setLayout(null);

		t1 = new JTextField();
		t1.setBounds(50, 25, 300, 50);
		t1.setFont(ff1);
		f1.add(t1);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setBackground(Color.GRAY);
		f1.add(panel);
		panel.setLayout(new GridLayout(4, 4));
		for (int i = 1; i < 10; i++) {
			nbtn[i] = new JButton(String.valueOf(i));
			nbtn[i].setFont(ff1);
			nbtn[i].addActionListener(this);
		}
		btnPlus = new JButton("+");
		btnPlus.setFont(ff1);
		btnMin = new JButton("-");
		btnMin.setFont(ff1);
		btnDiv = new JButton("/");
		btnDiv.setFont(ff1);
		btnMul = new JButton("*");
		btnMul.setFont(ff1);
		btnDec = new JButton(".");
		btnDec.setFont(ff1);
		btnZero = new JButton("0");
		btnZero.setFont(ff1);
		btnEq = new JButton("=");
		btnEq.setFont(ff1);
		btnExit = new JButton("EXIT");
		btnDel = new JButton("DELETE");

		panel.add(nbtn[7]);
		panel.add(nbtn[8]);
		panel.add(nbtn[9]);
		panel.add(btnPlus);
		panel.add(nbtn[4]);
		panel.add(nbtn[5]);
		panel.add(nbtn[6]);
		panel.add(btnMin);
		panel.add(nbtn[1]);
		panel.add(nbtn[2]);
		panel.add(nbtn[3]);
		panel.add(btnDiv);
		panel.add(btnZero);
		panel.add(btnDec);
		panel.add(btnEq);
		panel.add(btnMul);

		btnDel.setBounds(90, 410, 100, 40);
		btnExit.setBounds(210, 410, 100, 40);
		f1.add(btnDel);
		f1.add(btnExit);
		btnPlus.addActionListener(this);
		btnMin.addActionListener(this);
		btnDiv.addActionListener(this);
		btnMul.addActionListener(this);
		btnDec.addActionListener(this);
		btnEq.addActionListener(this);
		btnZero.addActionListener(this);
		btnDel.addActionListener(this);
		btnExit.addActionListener(this);
		f1.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 1; i < 10; i++) {
			if (e.getSource() == nbtn[i]) {
				t1.setText(t1.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == btnZero)
			t1.setText(t1.getText().concat("0"));
		if (e.getSource() == btnDec)
			t1.setText(t1.getText().concat("."));
		if (e.getSource() == btnPlus) {
			num1 = Double.parseDouble(t1.getText());
			opr = '+';
			t1.setText("");
		}
		if (e.getSource() == btnMin) {
			num1 = Double.parseDouble(t1.getText());
			opr = '-';
			t1.setText("");
		}
		if (e.getSource() == btnMul) {
			num1 = Double.parseDouble(t1.getText());
			opr = '*';
			t1.setText("");
		}
		if (e.getSource() == btnDiv) {
			num1 = Double.parseDouble(t1.getText());
			opr = '/';
			t1.setText("");
		}
		if (e.getSource() == btnDel)
			t1.setText("");
		if (e.getSource() == btnExit)
			System.exit(0);
		if (e.getSource() == btnEq) {
			num2 = Double.parseDouble(t1.getText());
			switch (opr) {
				case '+':
					result = num1 + num2;
					t1.setText(String.valueOf(result));
					break;
				case '-':
					result = num1 - num2;
					t1.setText(String.valueOf(result));
					break;
				case '*':
					result = num1 * num2;
					t1.setText(String.valueOf(result));
					break;
				case '/':
					result = num1 / num2;
					t1.setText(String.valueOf(result));
					break;
			}
		}
	}

	public static void main(String ar[]) {
		new JavaGuiCalculator();
	}
}