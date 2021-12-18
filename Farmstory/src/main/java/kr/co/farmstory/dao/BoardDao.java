package kr.co.farmstory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;

@Repository
public interface BoardDao {

    public int insertArticle(ArticleVo vo);

    public void insertFile(FileVo vo);

    public void insertComment(ArticleVo vo);

    public ArticleVo selectArticle(int seq);

    public List<ArticleVo> selectArticles(String cate, int start);

    public List<ArticleVo> selectComments(int seq);

    public ArticleVo selectComment(int seq);

    public FileVo selectFile(int fseq);

    public int selectCountTotal(String cate);

    public void updateArticle(ArticleVo vo);
    
    public void plusArticleComment(ArticleVo vo);
    
    public void minusArticleComment(ArticleVo vo);
    
    public void updateArticleHit(int seq);
    
    public void updateFileDownload(int fseq);

    public void updateComment(int seq);

    public void deleteArticle(int seq);

    public void deleteComment(int seq);

    public int completeComment(ArticleVo vo);

}