package  ma.zsmart.slinker.dao.criteria.core;


import ma.zsmart.slinker.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ClientCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;
    private String password;
    private String passwordLike;
    private String email;
    private String emailLike;

    private StatutClientCriteria statutClient ;
    private List<StatutClientCriteria> statutClients ;


    public ClientCriteria(){}

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPasswordLike(){
        return this.passwordLike;
    }
    public void setPasswordLike(String passwordLike){
        this.passwordLike = passwordLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }


    public StatutClientCriteria getStatutClient(){
        return this.statutClient;
    }

    public void setStatutClient(StatutClientCriteria statutClient){
        this.statutClient = statutClient;
    }
    public List<StatutClientCriteria> getStatutClients(){
        return this.statutClients;
    }

    public void setStatutClients(List<StatutClientCriteria> statutClients){
        this.statutClients = statutClients;
    }
}
