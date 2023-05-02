package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ScrappingOperationItemCriteria extends  BaseCriteria  {

    private String prix;
    private String prixMin;
    private String prixMax;
    private String stock;
    private String stockLike;
    private String image;
    private String imageLike;
    private String description;
    private String descriptionLike;
    private String review;
    private String reviewLike;

    private ScrappingLinkCriteria scrappingLink ;
    private List<ScrappingLinkCriteria> scrappingLinks ;
    private TypeProduitCriteria typeProduit ;
    private List<TypeProduitCriteria> typeProduits ;
    private ScrappingOperationCriteria scrappingOperation ;
    private List<ScrappingOperationCriteria> scrappingOperations ;


    public ScrappingOperationItemCriteria(){}

    public String getPrix(){
        return this.prix;
    }
    public void setPrix(String prix){
        this.prix = prix;
    }   
    public String getPrixMin(){
        return this.prixMin;
    }
    public void setPrixMin(String prixMin){
        this.prixMin = prixMin;
    }
    public String getPrixMax(){
        return this.prixMax;
    }
    public void setPrixMax(String prixMax){
        this.prixMax = prixMax;
    }
      
    public String getStock(){
        return this.stock;
    }
    public void setStock(String stock){
        this.stock = stock;
    }
    public String getStockLike(){
        return this.stockLike;
    }
    public void setStockLike(String stockLike){
        this.stockLike = stockLike;
    }

    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getImageLike(){
        return this.imageLike;
    }
    public void setImageLike(String imageLike){
        this.imageLike = imageLike;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getReview(){
        return this.review;
    }
    public void setReview(String review){
        this.review = review;
    }
    public String getReviewLike(){
        return this.reviewLike;
    }
    public void setReviewLike(String reviewLike){
        this.reviewLike = reviewLike;
    }


    public ScrappingLinkCriteria getScrappingLink(){
        return this.scrappingLink;
    }

    public void setScrappingLink(ScrappingLinkCriteria scrappingLink){
        this.scrappingLink = scrappingLink;
    }
    public List<ScrappingLinkCriteria> getScrappingLinks(){
        return this.scrappingLinks;
    }

    public void setScrappingLinks(List<ScrappingLinkCriteria> scrappingLinks){
        this.scrappingLinks = scrappingLinks;
    }
    public TypeProduitCriteria getTypeProduit(){
        return this.typeProduit;
    }

    public void setTypeProduit(TypeProduitCriteria typeProduit){
        this.typeProduit = typeProduit;
    }
    public List<TypeProduitCriteria> getTypeProduits(){
        return this.typeProduits;
    }

    public void setTypeProduits(List<TypeProduitCriteria> typeProduits){
        this.typeProduits = typeProduits;
    }
    public ScrappingOperationCriteria getScrappingOperation(){
        return this.scrappingOperation;
    }

    public void setScrappingOperation(ScrappingOperationCriteria scrappingOperation){
        this.scrappingOperation = scrappingOperation;
    }
    public List<ScrappingOperationCriteria> getScrappingOperations(){
        return this.scrappingOperations;
    }

    public void setScrappingOperations(List<ScrappingOperationCriteria> scrappingOperations){
        this.scrappingOperations = scrappingOperations;
    }
}
