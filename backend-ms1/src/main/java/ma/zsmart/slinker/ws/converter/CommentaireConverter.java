package  ma.zsmart.slinker.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zsmart.slinker.bean.core.Article;

import ma.zsmart.slinker.zynerator.util.StringUtil;
import ma.zsmart.slinker.zynerator.converter.AbstractConverter;
import ma.zsmart.slinker.zynerator.util.DateUtil;
import ma.zsmart.slinker.bean.history.CommentaireHistory;
import ma.zsmart.slinker.bean.core.Commentaire;
import ma.zsmart.slinker.ws.dto.CommentaireDto;

@Component
public class CommentaireConverter extends AbstractConverter<Commentaire, CommentaireDto, CommentaireHistory> {

    @Autowired
    private ArticleConverter articleConverter ;
    private boolean article;

    public  CommentaireConverter(){
        super(Commentaire.class, CommentaireDto.class, CommentaireHistory.class);
    }

    @Override
    public Commentaire toItem(CommentaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        Commentaire item = new Commentaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getContenu()))
                item.setContenu(dto.getContenu());
            if(StringUtil.isNotEmpty(dto.getDateCommentaire()))
                item.setDateCommentaire(DateUtil.stringEnToDate(dto.getDateCommentaire()));
            if(dto.getArticle() != null && dto.getArticle().getId() != null){
                item.setArticle(new Article());
                item.getArticle().setId(dto.getArticle().getId());
            }



        return item;
        }
    }

    @Override
    public CommentaireDto toDto(Commentaire item) {
        if (item == null) {
            return null;
        } else {
            CommentaireDto dto = new CommentaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getContenu()))
                dto.setContenu(item.getContenu());
            if(item.getDateCommentaire()!=null)
                dto.setDateCommentaire(DateUtil.dateTimeToString(item.getDateCommentaire()));
        if(this.article && item.getArticle()!=null) {
            dto.setArticle(articleConverter.toDto(item.getArticle())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.article = value;
    }


    public ArticleConverter getArticleConverter(){
        return this.articleConverter;
    }
    public void setArticleConverter(ArticleConverter articleConverter ){
        this.articleConverter = articleConverter;
    }
    public boolean  isArticle(){
        return this.article;
    }
    public void  setArticle(boolean article){
        this.article = article;
    }
}
