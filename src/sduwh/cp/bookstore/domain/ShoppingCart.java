package sduwh.cp.bookstore.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	
	private Map<Integer, ShoppingCartItem> books = new HashMap<>();
	
	/**
	 * 修改指定购物项的数量
	 */
	public void updateItemQuantity(Integer id, int quantity){
		ShoppingCartItem sci =books.get(id);
		if(sci != null){
			sci.setQuantity(quantity);
		}
	}
	
	/**
	 * 移除指定的购物项 
	 */
	public void removeItem(Integer id){
		books.remove(id);
	}
	
	/**
	 * 清空购物车
	 */
	public void clear(){
		books.clear();
	}
	
	/**
	 * 返回购物车是否为空 
	 */
	public boolean isEmpty(){
		return books.isEmpty();
	}
	
	/**
	 *获取购物车中所有的商品的总的钱数 
	 */
	public float getTotalMoney(){
		float total = 0;
		
		for(ShoppingCartItem sci: getItems()){
			total += sci.getItemMoney();
		}
		
		return total;
	}
	
	/**
	 * 获取购物车中所有的shoppingCartItem 组成的集合
	 * @return
	 */
	public Collection<ShoppingCartItem> getItems(){
		return books.values();
	}
	
	/**
	 * 返回购物车中商品的总数量
	 * @return
	 */
	public int getBookNumber(){
		int total = 0;
		
		for(ShoppingCartItem sci: books.values()){
			total += sci.getQuantity();
		}
		
		return total;
	}
	
	
	public Map<Integer, ShoppingCartItem> getBooks() {
		return books;
	}
	
	/**
	 * 检验购物车中是否有id 指定的商品
	 * @param id
	 * @return
	 */
	public boolean hasBook(Integer id){
		return books.containsKey(id);
	}		
			
	/**
	 * 向购物车中添加一件商品
	 * @param book
	 */
	public void addBook(Book book){
		
		ShoppingCartItem sci = books.get(book.getId());
		
		if(sci == null){
			sci = new ShoppingCartItem(book);
			books.put(book.getId(), sci);
		}else{
			sci.increment();
		}
	}
}
