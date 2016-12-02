import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class BookModel {
	private final String BOOK_TXT_PATH = "./book.txt";
	
	//keyはISBN
	private List<Book> bookList = new ArrayList<>();
	private List<Book> bookSearchedList = new ArrayList<>();
	private List<String> bookISBNList = new ArrayList<>();
	
	BookModel(){
		readBookInfo();
	}

	private void readBookInfo(){
		BufferedReader reader;

		bookList.clear();
		bookISBNList.clear();
		
		try {
			reader = new BufferedReader(new FileReader(BOOK_TXT_PATH));
			
			reader.readLine();
			
			String line;
			while((line = reader.readLine()) != null){
				String[] bookInfo = line.split(",", 5);

				if(bookISBNList.contains(bookInfo[3])){
					System.out.println("this ISBN was already registed.");
					continue;
				}
				
				if(bookInfo.length >= 4){
					bookISBNList.add(bookInfo[3]);
					bookList.add(new Book(bookInfo));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	List<Book> getBookList(){
		Collections.sort(bookList, new BookComparator());
		return bookList;
	}

	void search(String[] word){
		bookSearchedList.clear();

		for(Book book : bookList){
			if(book.isMatchs(word)){
				bookSearchedList.add(book);
			}
		}
	}

	List<Book> getSearchedBookList(){
		return bookSearchedList;
	}
	
	boolean addBookInfo(String[] bookInfo) {
		if(bookInfo.length < 4){
			return false;
		}

		for(int i=0; i<4; ++i){
			if(bookInfo[i].length() <= 0){
				return false;
			}
		}

		if(bookISBNList.contains(bookInfo[3])){
			System.out.println("this ISBN was already registed.");
			return false;
		}
		
		FileWriter file;

		bookISBNList.add(bookInfo[3]);
		bookList.add(new Book(bookInfo));
		
		try {
			file = new FileWriter(BOOK_TXT_PATH, true);
			
			StringBuilder builder = new StringBuilder("\n");
			for(String info : bookInfo){
				builder.append(info);
				builder.append(",");
			}
			
			file.write(builder.toString());
			file.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
