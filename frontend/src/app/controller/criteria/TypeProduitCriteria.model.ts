import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class TypeProduitCriteria  extends   BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public libelle: string;
    public libelleLike: string;

}
