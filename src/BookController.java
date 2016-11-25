
public class BookController {
	private BookModel bookModel;
	
	BookController(){
		bookModel = new BookModel();
	}
	
	void registBookInfo(String[] bookInfo){
		bookModel.addBookInfo(bookInfo);
	}
}
