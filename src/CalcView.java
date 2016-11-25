import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CalcView extends JFrame implements ActionListener {
	private CalcController calcController;
	
	private Container container;
	private JTextField tf1, tf2, tf3; //値１、演算記号、値２
	private JLabel labelResult;
	private JButton btnCalc, btnClear;

	private CalcView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(160, 90);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Calc");

		Container container = this.getContentPane();
		container.setLayout(new FlowLayout());
		
		container.add(tf1 = new JTextField(2));
		container.add(tf2 = new JTextField(1));
		container.add(tf3 = new JTextField(2));
		
		container.add(labelResult = new JLabel("=  "));
		
		container.add(btnCalc  = new JButton("Calc"));
		container.add(btnClear = new JButton("Clear"));
		
		btnCalc.addActionListener(this);
		btnClear.addActionListener(this);
		
		calcController = new CalcController();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnCalc){
			labelResult.setText("= " + calcController.calc(tf1.getText(), tf3.getText(), tf2.getText()));
		}else{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			
			labelResult.setText("=  ");
		}
	}
	

	
	public static void main(String[] args) {
		CalcView calc = new CalcView();
		calc.setVisible(true);
	}

}
