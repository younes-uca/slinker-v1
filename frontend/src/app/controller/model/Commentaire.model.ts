import {ArticleDto} from './Article.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CommentaireDto  extends BaseDto{

    public id: number;
    public contenu: string;
   public dateCommentaire: Date;
    public dateCommentaireMax: string ;
    public dateCommentaireMin: string ;
    public article: ArticleDto ;

}
