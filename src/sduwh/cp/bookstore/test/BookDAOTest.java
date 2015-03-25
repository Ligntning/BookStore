package sduwh.cp.bookstore.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import sduwh.cp.bookstore.dao.BookDAO;
import sduwh.cp.bookstore.dao.impl.BookDAOImpl;
import sduwh.cp.bookstore.domain.Book;
import sduwh.cp.bookstore.web.CriteriaBook;
import sduwh.cp.bookstore.web.Page;

public class BookDAOTest {

	private BookDAO bookDAO =new BookDAOImpl();
	
	@Test
	public void testGetBook() {
		Book book=bookDAO.getBook(5);
		System.out.println(book);
	}

	@Test
	public void testGetPage() {
		CriteriaBook cb=new CriteriaBook(0, Integer.MAX_VALUE, 3);
		Page<Book> page=bookDAO.getPage(cb);
		System.out.println(page.getPrevPage());
		System.out.println(page.getNextPage());
		System.out.println(page.getPageNo());
	}


	@Test
	public void testGetStoreNumber() {
		int storeNumber=bookDAO.getStoreNumber(5);
		System.out.println(storeNumber);
	}

	@Test
	public void testBatchUpdateStoreNumberAndSalesAmount() {
		fail("Not yet implemented");
	}

}
