package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductDao;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductVo;
import kr.co.kmarket.vo.SearchVo;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao dao;
	
	public void insertProduct() {}
	
	
	public void insertProductCart(ProductCartVo vo) {
		dao.insertProductCart(vo);
	}
	
	
	public ProductVo selectProduct(int productCode) {
		return dao.selectProduct(productCode);
	}
	
	public List<ProductVo> selectProducts(ProductVo vo){
		return dao.selectProducts(vo);
	}
	
	
	public CategoriesVo selectCategoryTitle(ProductVo vo){
		return dao.selectCategoryTitle(vo);
	}
	
	
	
	public int selectProductCountTotal(ProductVo vo) {
		return dao.selectProductCountTotal(vo);
	}
	
	public List<ProductVo> selectProductSearch(SearchVo vo){
		return dao.selectProductSearch(vo);
	}
	
	
	
	
	public void updateProduct() {}
	public void deleteProduct() {}
	
	
	
	// 현재 패이지가 구하는 메서드 , 현재 페이지가 널값이라면 디폴트값으로 1을 넣는다.
	public int getCurrentPage(String pg) {
		if(pg == null) {
			pg = "1";	
		}
		return Integer.parseInt(pg);
	}
	// 마지막페이지를 구하는 메서드 10개씩 나누어 떨어지면 10으로 나눈 몫이되고 아니면 10으로 나눈 몫에다가 1을 더한다. 
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10  + 1;
		}
		return lastPageNum;
	}
	// 현재 페이지에서 출발하는 번호를 구하기 위해 start를 셋팅한다 0,10,20 이면 쿼리문에서 limit(0,10)   limit(10,10) limit(20,10)......
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	// 각 페이지마다 시작하는 데이터 번호
	public int getPageStartNum(int total, int start) {
		return (total - start) + 1;
	}
	// 페이지를 그룹으로 10개씩 묶기 위한 메서드 
	public int[] getPageGroup(int currentPage, int lastPageNum) { // 현재 페이지를 가지고 이 페이지가 어떤 그룹에 속하는지 알아냅니다.  
		int groupCurrent = (int) Math.ceil(currentPage / 10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1; //  1    11   21    31  41
		int groupEnd = groupCurrent * 10;             //  10   20   30    40  45(마지막페이지인경우 그룹의 끝페이지가 됨)
		if(groupEnd > lastPageNum) { // 한 그룹의 마지막페이지가 원래 마지막페이지보다 크다면 원래 마지막페이지를 선택합니다. 
			groupEnd = lastPageNum;
		}
		int[] groups = {groupStart,groupEnd};
		return groups;
	}
	
}
