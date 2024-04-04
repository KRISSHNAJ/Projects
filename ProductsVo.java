package youtube.krishnaitprojects.model;

import java.util.List;

public class ProductsVo {
	
	private List<ProductVo> products;

	public boolean isEmpty() {
		return products == null || products.isEmpty();
	}

	public List<ProductVo> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVo> products) {
		this.products = products;
	}

}
