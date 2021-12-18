package kr.co.farmstory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.farmstory.vo.ArticleVo;

@Repository
public interface MainDao {

    public List<ArticleVo> selectLatest(String cate);

}