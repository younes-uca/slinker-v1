import {ArticleCriteria} from './ArticleCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class CommentaireCriteria  extends   BaseCriteria  {

    public id: number;
    public contenu: string;
    public contenuLike: string;
    public dateCommentaire: Date;
    public dateCommentaireFrom: Date;
    public dateCommentaireTo: Date;
  public article: ArticleCriteria ;
  public articles: Array<ArticleCriteria> ;

}
