package sduwh.cp.bookstore.test;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import sduwh.cp.bookstore.dao.impl.BaseDAO;
import sduwh.cp.bookstore.dao.impl.BookDAOImpl;
import sduwh.cp.bookstore.domain.Book;

public class BaseDAOTest {

	private BookDAOImpl bookDAOImpl = new BookDAOImpl();

	@Test
	public void testInsert() {
		String sql = "INSERT INTO trade (userid, tradetime) VALUES(? ,?)";
		long id = bookDAOImpl.insert(sql, 1,
				new Date(new java.util.Date().getTime()));
		System.out.println(id);
	}

	@Test
	public void testUpdate() {
		String sql = "UPDATE mybooks SET salesamount = ? WHERE id = ?";
		System.out.println(sql);
		bookDAOImpl.update(sql, 10, 3);
	}

	@Test
	public void testQuery() {
		String sql = "SELECT id,author,title, price,publishingDate,"
				+ "salesamount,storenumber,remark FROM mybooks WHERE id=?";
		Book book=bookDAOImpl.query(sql, 3);
		System.out.println(sql);
		System.out.println(book);
	}

	@Test
	public void testQueryForList() {
		String sql = "SELECT id,author,title, price,publishingDate,"
				+ "salesamount,storenumber,remark FROM mybooks WHERE id<?";
		List<Book> books=bookDAOImpl.queryForList(sql, 4);
		System.out.println(books);
	}

	@Test
	public void testGetSingleVal() {
		String sql="SELECT count(id) FROM mybooks";
		long count=bookDAOImpl.getSingleVal(sql);
		System.out.println(count);
	}

	@Test
	public void testBatch() {
		String sql="UPDATE mybooks SET salesamount=?, storenumber=?"+" WHERE id=?";
		bookDAOImpl.batch(sql, new Object[]{1,1,1},new Object[]{2,2,2},new Object[]{3,3,3});
	}

}
