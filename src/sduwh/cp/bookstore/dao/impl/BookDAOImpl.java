package sduwh.cp.bookstore.dao.impl;

import java.util.Collection;
import java.util.List;

import sduwh.cp.bookstore.dao.BookDAO;
import sduwh.cp.bookstore.domain.Book;
import sduwh.cp.bookstore.domain.ShoppingCartItem;
import sduwh.cp.bookstore.web.CriteriaBook;
import sduwh.cp.bookstore.web.Page;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {

	@Override
	public Book getBook(int id) {
		String sql = "SELECT id,author,title, price,publishingDate,"
				+ "salesamount,storenumber,remark FROM mybooks WHERE id<?";
		return query(sql, id);
	}

	@Override
	public Page<Book> getPage(CriteriaBook cb) {
		Page page = new Page<>(cb.getPageNo());
		page.setTotalItemNumber(getTotalBookNumber(cb));
		page.setPageNo(page.getPageNo());//校验一下
		page.setList(getPageList(cb, 3));
		return page;
	}

	@Override
	public long getTotalBookNumber(CriteriaBook cb) {
		String sql = "SELECT COUNT(id) FROM mybooks WHERE price >= ? AND price <=?";
		return getSingleVal(sql, cb.getMinPrice(), cb.getMaxPrice());
	}

	@Override
	public List<Book> getPageList(CriteriaBook cb, int pageSize) {
		String sql = "SELECT id,author,title, price,publishingDate,"
				+ "salesamount,storenumber,remark FROM mybooks WHERE price >= ? AND price <=?"
				+ "LIMIT ?,?";
		return queryForList(sql, cb.getMinPrice(), cb.getMaxPrice(),
				(cb.getPageNo() - 1) * pageSize, pageSize);
	}

	@Override
	public int getStoreNumber(Integer id) {
		String sql = "SELECT storeNumber FROM mybooks WHERE id=?";
		return getSingleVal(sql, id);
	}

	@Override
	public void batchUpdateStoreNumberAndSalesAmount(
			Collection<ShoppingCartItem> items) {
		// TODO Auto-generated method stub

	}

}
