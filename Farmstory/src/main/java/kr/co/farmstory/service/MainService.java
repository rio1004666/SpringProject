package kr.co.farmstory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.farmstory.dao.MainDao;
import kr.co.farmstory.vo.ArticleVo;

@Service
public class MainService {

    @Autowired
    private MainDao dao;

    public List<ArticleVo> selectLatest(String cate) {

        return dao.selectLatest(cate);
    }

}