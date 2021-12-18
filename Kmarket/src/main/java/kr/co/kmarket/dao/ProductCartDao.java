package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductCartVo;
@Repository
public interface ProductCartDao {
	public void insertCart(ProductCartVo vo);
	public int selectCountCart(ProductCartVo vo);
	public List<ProductCartVo> selectCarts(String uid);
	public void updateCart();
	public int deleteCart(int[] cartIds);
	

}
