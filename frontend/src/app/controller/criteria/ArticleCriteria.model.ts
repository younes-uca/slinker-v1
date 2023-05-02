import {CommentaireCriteria} from './CommentaireCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ArticleCriteria  extends   BaseCriteria  {

    public id: number;
    public titre: string;
    public titreLike: string;
    public contenu: string;
    public contenuLike: string;
    public image: string;
    public imageLike: string;
      public commentaires: Array<CommentaireCriteria>;

}
