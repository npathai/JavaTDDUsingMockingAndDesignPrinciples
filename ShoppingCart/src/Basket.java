import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Basket{
	private List<Product> items = new ArrayList<Product>();
	
	public void add(Product item) {
		if(item.getPrice().compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("Cannot add a product with price less than 0");
		}
		
		items.add(item);
	}

	public int size() {
		return items.size();
	}

	public BigDecimal totalPrice() {
		BigDecimal total = new BigDecimal(0.0);
		
		for(Product product : items){
			total = total.add(product.getPrice());
		}
		
		return total;
	}

}
