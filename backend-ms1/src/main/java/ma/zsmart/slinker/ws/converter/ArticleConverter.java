package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zsmart.slinker.zynerator.util.ListUtil;


import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.ArticleHistory;
import ma.zsmart.slinker.bean.core.Article;
import ma.zsmart.slinker.ws.dto.ArticleDto;

@Component
public class ArticleConverter extends AbstractConverter<Article, ArticleDto, ArticleHistory> {

    @Autowired
    private CommentaireConverter commentaireConverter ;
    private boolean commentaires;

    public  ArticleConverter(){
        super(Article.class, ArticleDto.class, ArticleHistory.class);
        init(true);
    }

    @Override
    public Article toItem(ArticleDto dto) {
        if (dto == null) {
            return null;
        } else {
        Article item = new Article();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getTitre()))
                item.setTitre(dto.getTitre());
            if(StringUtil.isNotEmpty(dto.getContenu()))
                item.setContenu(dto.getContenu());
            if(StringUtil.isNotEmpty(dto.getImage()))
                item.setImage(dto.getImage());

            if(this.commentaires && ListUtil.isNotEmpty(dto.getCommentaires()))
                item.setCommentaires(commentaireConverter.toItem(dto.getCommentaires()));

        return item;
        }
    }

    @Override
    public ArticleDto toDto(Article item) {
        if (item == null) {
            return null;
        } else {
            ArticleDto dto = new ArticleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getTitre()))
                dto.setTitre(item.getTitre());
            if(StringUtil.isNotEmpty(item.getContenu()))
                dto.setContenu(item.getContenu());
            if(StringUtil.isNotEmpty(item.getImage()))
                dto.setImage(item.getImage());
        if(this.commentaires && ListUtil.isNotEmpty(item.getCommentaires())){
            commentaireConverter.init(true);
            commentaireConverter.setArticle(false);
            dto.setCommentaires(commentaireConverter.toDto(item.getCommentaires()));
            commentaireConverter.setArticle(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.commentaires = value;
    }

    public void initObject(boolean value) {
    }


    public CommentaireConverter getCommentaireConverter(){
        return this.commentaireConverter;
    }
    public void setCommentaireConverter(CommentaireConverter commentaireConverter ){
        this.commentaireConverter = commentaireConverter;
    }
    public boolean  isCommentaires(){
        return this.commentaires ;
    }
    public void  setCommentaires(boolean commentaires ){
        this.commentaires  = commentaires ;
    }
}
