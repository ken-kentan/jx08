import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;


public class BookModel {
	final String BOOK_TXT_PATH = "./book.txt";
	
	private enum INFO{NAME, AUTHOR, PUBLISHER, ISBN};
	
	//keyはISBN
	private Map<String, String> bookNameMap = new HashMap<>();
	private Map<String, String> bookAuthorMap = new HashMap<>();
	private Map<String, String> bookPublisherMap = new HashMap<>();
	
	BookModel(){
		readBookInfos();
	}

	private void readBookInfos(){
		BufferedReader reader;
		
		bookNameMap.clear();
		bookAuthorMap.clear();
		bookPublisherMap.clear();
		
		try {
			reader = new BufferedReader(new FileReader(BOOK_TXT_PATH));
			
			reader.readLine();
			
			String line;
			while((line = reader.readLine()) != null){
				String[] bookInfo = line.split(",", 4);
				
				if(bookInfo.length == 4){
					bookNameMap.put(bookInfo[3], bookInfo[0]);
					bookAuthorMap.put(bookInfo[3], bookInfo[1]);
					bookPublisherMap.put(bookInfo[3], bookInfo[2]);
				}
				System.out.println(bookInfo[0] + bookInfo[1] + bookInfo[2] + bookInfo[3] + bookInfo.length);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	boolean addBookInfo(String[] bookInfo) {
		if(bookInfo.length != 4){
			return false;
		}
		
		FileWriter file;
		
		bookNameMap.put(bookInfo[3], bookInfo[0]);
		bookAuthorMap.put(bookInfo[3], bookInfo[1]);
		bookPublisherMap.put(bookInfo[3], bookInfo[2]);
		
		try {
			file = new FileWriter(BOOK_TXT_PATH);
			
			StringBuilder builder = new StringBuilder();
			for(String info : bookInfo){
				builder.append(info);
				builder.append(",");
			}
			
			file.write(builder.toString());
			file.close();
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
		return true;
	}
}
