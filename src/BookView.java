import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class BookView extends JFrame implements ActionListener {
	private BookController bookController;
	
	private Container container;
	private JButton btnRegist, btnList, btnSearch;
	private JTextField tfName, tfAuthor, tfPublisher, tfISBN;
	
	private BookView(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Book");

		Container container = this.getContentPane();
		container.setLayout(new FlowLayout());
		
		container.add(new JLabel("書名"));
		container.add(tfName = new JTextField(10));
		container.add(new JLabel("　著者名"));
		container.add(tfName = new JTextField(10));
		container.add(new JLabel("　出版社"));
		container.add(tfName = new JTextField(10));
		container.add(new JLabel("　ISBN"));
		container.add(tfName = new JTextField(10));
		container.add(btnRegist = new JButton("登録"));
		container.add(new JLabel("または"));
		container.add(btnSearch = new JButton("検索"));
		
		container.add(btnList   = new JButton("一覧表示"));
		
		btnRegist.addActionListener(this);
		btnList.addActionListener(this);
		btnSearch.addActionListener(this);
		
		bookController = new BookController();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnRegist){
			bookController.registBookInfo(new String[]{tfName.getText(), tfAuthor.getText(), tfPublisher.getText(), tfISBN.getText()});
		}
	}


	public static void main(String[] args) {
		BookView app = new BookView();
		app.setVisible(true);
	}

}
