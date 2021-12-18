package kr.co.kmarket.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductCate1Vo;
import kr.co.kmarket.vo.ProductCate2Vo;
import kr.co.kmarket.vo.ProductVo;

@Repository
public interface AdminProductDao {
	public void insertProduct(ProductVo vo);
	
	
	public void selectProduct();
	public void selectProducts();
	public void updateProduct();
	public void deleteProduct();
	public List<ProductCate1Vo> selectCate1();
	public List<ProductCate2Vo> selectCate2(int cate1);
	
}
