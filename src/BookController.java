import java.util.List;

class BookController {
	private BookModel bookModel;
	
	BookController(){
		bookModel = new BookModel();
	}

	List<Book> getBookList(){
		return bookModel.getBookList();
	}
	
	boolean registBookInfo(String[] bookInfo){
		return bookModel.addBookInfo(bookInfo);
	}

	void searchBookInfo(String[] bookInfo){
		bookModel.search(bookInfo);
	}

	List<Book> getSearchedBookList(){
		return bookModel.getSearchedBookList();
	}

}
