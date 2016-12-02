import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class BookView extends JFrame implements ActionListener{
	private BookController bookController;

	private DefaultTableModel tableModel;
	private JButton btnRegist, btnList, btnSearch;
	private JTextField tfName, tfAuthor, tfPublisher, tfISBN;
	
	private BookView(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Book");

		bookController = new BookController();

        JScrollPane scrollPane = new JScrollPane();
        tableModel = new DefaultTableModel(new String[]{"書名", "著者名", "出版社", "ISBN"}, 0);
        scrollPane.getViewport().setView(new JTable(tableModel){
            @Override public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        scrollPane.setPreferredSize(new Dimension(850, 250));

		Container container = this.getContentPane();
		container.setLayout(new FlowLayout());
		
		container.add(new JLabel("書名"));
		container.add(tfName = new JTextField(10));
		container.add(new JLabel("　著者名"));
		container.add(tfAuthor = new JTextField(10));
		container.add(new JLabel("　出版社"));
		container.add(tfPublisher = new JTextField(10));
		container.add(new JLabel("　ISBN"));
		container.add(tfISBN = new JTextField(10));
		container.add(btnRegist = new JButton("登録"));
		container.add(new JLabel("または"));
		container.add(btnSearch = new JButton("検索"));
		container.add(btnList   = new JButton("一覧表示"));
		container.add(scrollPane);
		
		btnRegist.addActionListener(this);
		btnList.addActionListener(this);
		btnSearch.addActionListener(this);

		KeyListener keyListener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				btnRegist.setEnabled(!isEmptyTextField());
				btnSearch.setEnabled(!isEmptyALLTextField());
			}

			public void keyTyped(KeyEvent e) {
			}
		};

		tfName.addKeyListener(keyListener);
		tfAuthor.addKeyListener(keyListener);
		tfPublisher.addKeyListener(keyListener);
		tfISBN.addKeyListener(keyListener);

        updateBookList();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnRegist){
			if(!bookController.registBookInfo(new String[]{tfName.getText(), tfAuthor.getText(), tfPublisher.getText(), tfISBN.getText()})){
                JOptionPane.showMessageDialog(this, "このISBNは既に登録されています.", "登録エラー", JOptionPane.ERROR_MESSAGE);
            }

			clearAllTextField();

            btnRegist.setEnabled(!isEmptyTextField());
            btnSearch.setEnabled(!isEmptyALLTextField());
		}else if(obj == btnSearch){
			bookController.searchBookInfo(new String[]{tfName.getText(), tfAuthor.getText(), tfPublisher.getText(), tfISBN.getText()});

			tableModel.setRowCount(0);
            for(Book book : bookController.getSearchedBookList()){
                tableModel.addRow(book.getAll());
            }
		}else{
            updateBookList();
		}
	}

	private void updateBookList(){
        clearAllTextField();

        tableModel.setRowCount(0);
        for(Book book : bookController.getBookList()){
            tableModel.addRow(book.getAll());
        }

        btnRegist.setEnabled(!isEmptyTextField());
        btnSearch.setEnabled(!isEmptyALLTextField());
    }

	private void clearAllTextField(){
		tfName.setText("");
		tfAuthor.setText("");
		tfPublisher.setText("");
		tfISBN.setText("");
	}

	private boolean isEmptyTextField(){
		return (tfName.getText().length() <= 0 || tfAuthor.getText().length() <= 0 || tfPublisher.getText().length() <= 0 || tfISBN.getText().length() <= 0);
	}

	private boolean isEmptyALLTextField(){
		return (tfName.getText().length() <= 0 && tfAuthor.getText().length() <= 0 && tfPublisher.getText().length() <= 0 && tfISBN.getText().length() <= 0);
	}


	public static void main(String[] args) {
		BookView app = new BookView();
		app.setVisible(true);
	}

}
