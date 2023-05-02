import {CommentaireDto} from './Commentaire.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ArticleDto  extends BaseDto{

    public id: number;
    public titre: string;
    public contenu: string;
    public image: string;
     public commentaires: Array<CommentaireDto>;

}
