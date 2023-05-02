package  ma.zsmart.slinker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;


import ma.zsmart.slinker.bean.core.*;
import ma.zsmart.slinker.service.facade.admin.*;

import ma.zsmart.slinker.zynerator.security.common.AuthoritiesConstants;
import ma.zsmart.slinker.zynerator.security.bean.User;
import ma.zsmart.slinker.zynerator.security.bean.Permission;
import ma.zsmart.slinker.zynerator.security.bean.Role;
import ma.zsmart.slinker.zynerator.security.service.facade.UserService;
import ma.zsmart.slinker.zynerator.security.service.facade.RoleService;


import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableFeignClients("ma.zsmart.slinker.required.facade")
public class SlinkerApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(SlinkerApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){

            createTypePaiement();


    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }



    private void createTypePaiement(){
        String code = "code";
        String libelle = "libelle";
        for (int i = 1; i < 100; i++) {
            TypePaiement item = new TypePaiement();
            item.setCode(fakeString(code, i));
            item.setLibelle(fakeString(libelle, i));
            typePaiementService.create(item);
        }
    }

    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("SubscriptionPack.edit"));
        permissions.add(new Permission("SubscriptionPack.list"));
        permissions.add(new Permission("SubscriptionPack.view"));
        permissions.add(new Permission("SubscriptionPack.add"));
        permissions.add(new Permission("SubscriptionPack.delete"));
        permissions.add(new Permission("StatutWebSite.edit"));
        permissions.add(new Permission("StatutWebSite.list"));
        permissions.add(new Permission("StatutWebSite.view"));
        permissions.add(new Permission("StatutWebSite.add"));
        permissions.add(new Permission("StatutWebSite.delete"));
        permissions.add(new Permission("ScrappingOperationItem.edit"));
        permissions.add(new Permission("ScrappingOperationItem.list"));
        permissions.add(new Permission("ScrappingOperationItem.view"));
        permissions.add(new Permission("ScrappingOperationItem.add"));
        permissions.add(new Permission("ScrappingOperationItem.delete"));
        permissions.add(new Permission("SubscriptionType.edit"));
        permissions.add(new Permission("SubscriptionType.list"));
        permissions.add(new Permission("SubscriptionType.view"));
        permissions.add(new Permission("SubscriptionType.add"));
        permissions.add(new Permission("SubscriptionType.delete"));
        permissions.add(new Permission("StatutNotification.edit"));
        permissions.add(new Permission("StatutNotification.list"));
        permissions.add(new Permission("StatutNotification.view"));
        permissions.add(new Permission("StatutNotification.add"));
        permissions.add(new Permission("StatutNotification.delete"));
        permissions.add(new Permission("ScrappingOperation.edit"));
        permissions.add(new Permission("ScrappingOperation.list"));
        permissions.add(new Permission("ScrappingOperation.view"));
        permissions.add(new Permission("ScrappingOperation.add"));
        permissions.add(new Permission("ScrappingOperation.delete"));
        permissions.add(new Permission("SubscriptionEtat.edit"));
        permissions.add(new Permission("SubscriptionEtat.list"));
        permissions.add(new Permission("SubscriptionEtat.view"));
        permissions.add(new Permission("SubscriptionEtat.add"));
        permissions.add(new Permission("SubscriptionEtat.delete"));
        permissions.add(new Permission("NotificationDetail.edit"));
        permissions.add(new Permission("NotificationDetail.list"));
        permissions.add(new Permission("NotificationDetail.view"));
        permissions.add(new Permission("NotificationDetail.add"));
        permissions.add(new Permission("NotificationDetail.delete"));
        permissions.add(new Permission("Commentaire.edit"));
        permissions.add(new Permission("Commentaire.list"));
        permissions.add(new Permission("Commentaire.view"));
        permissions.add(new Permission("Commentaire.add"));
        permissions.add(new Permission("Commentaire.delete"));
        permissions.add(new Permission("Affliate.edit"));
        permissions.add(new Permission("Affliate.list"));
        permissions.add(new Permission("Affliate.view"));
        permissions.add(new Permission("Affliate.add"));
        permissions.add(new Permission("Affliate.delete"));
        permissions.add(new Permission("Notification.edit"));
        permissions.add(new Permission("Notification.list"));
        permissions.add(new Permission("Notification.view"));
        permissions.add(new Permission("Notification.add"));
        permissions.add(new Permission("Notification.delete"));
        permissions.add(new Permission("ScrappingLink.edit"));
        permissions.add(new Permission("ScrappingLink.list"));
        permissions.add(new Permission("ScrappingLink.view"));
        permissions.add(new Permission("ScrappingLink.add"));
        permissions.add(new Permission("ScrappingLink.delete"));
        permissions.add(new Permission("Article.edit"));
        permissions.add(new Permission("Article.list"));
        permissions.add(new Permission("Article.view"));
        permissions.add(new Permission("Article.add"));
        permissions.add(new Permission("Article.delete"));
        permissions.add(new Permission("WebSite.edit"));
        permissions.add(new Permission("WebSite.list"));
        permissions.add(new Permission("WebSite.view"));
        permissions.add(new Permission("WebSite.add"));
        permissions.add(new Permission("WebSite.delete"));
        permissions.add(new Permission("TypePaiement.edit"));
        permissions.add(new Permission("TypePaiement.list"));
        permissions.add(new Permission("TypePaiement.view"));
        permissions.add(new Permission("TypePaiement.add"));
        permissions.add(new Permission("TypePaiement.delete"));
        permissions.add(new Permission("StatutClient.edit"));
        permissions.add(new Permission("StatutClient.list"));
        permissions.add(new Permission("StatutClient.view"));
        permissions.add(new Permission("StatutClient.add"));
        permissions.add(new Permission("StatutClient.delete"));
        permissions.add(new Permission("TypeProduit.edit"));
        permissions.add(new Permission("TypeProduit.list"));
        permissions.add(new Permission("TypeProduit.view"));
        permissions.add(new Permission("TypeProduit.add"));
        permissions.add(new Permission("TypeProduit.delete"));
        permissions.add(new Permission("Subscription.edit"));
        permissions.add(new Permission("Subscription.list"));
        permissions.add(new Permission("Subscription.view"));
        permissions.add(new Permission("Subscription.add"));
        permissions.add(new Permission("Subscription.delete"));
    }

    @Autowired
    TypePaiementAdminService typePaiementService;
}


