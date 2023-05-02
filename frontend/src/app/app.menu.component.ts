import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {
  trigger,
  state,
  style,
  transition,
  animate,
} from '@angular/animations';
import { AppComponent } from './app.component';
import { AppMainComponent } from './app.main.component';

import { AuthService } from 'src/app/zynerator/security/Auth.service';
import { RoleService } from 'src/app/zynerator/security/Role.service';

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html',
  animations: [
    trigger('inline', [
      state(
        'hidden',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visible',
        style({
          height: '*',
        })
      ),
      state(
        'hiddenAnimated',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visibleAnimated',
        style({
          height: '*',
        })
      ),
      transition(
        'visibleAnimated => hiddenAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
      transition(
        'hiddenAnimated => visibleAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
    ]),
  ],
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelsuperadmin:any[];
  modelanonymous: any[];
    modeladmin : any[];
  constructor(public app: AppComponent,
   public appMain: AppMainComponent,
   private roleService: RoleService,
   private authService:AuthService,
  private router: Router) {}

  ngOnInit() {


    this.modeladmin =
      [
              {
                label: 'Subscription Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste subscription pack',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscription/subscription-pack/list']
                    },
                    {
                      label: 'Liste subscription type',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscription/subscription-type/list']
                    },
                    {
                      label: 'Liste subscription etat',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscription/subscription-etat/list']
                    },
                    {
                      label: 'Liste type paiement',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscription/type-paiement/list']
                    },
                    {
                      label: 'Liste subscription',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/subscription/subscription/list']
                    },
                ]
              },
              {
                label: 'Client Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste client',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/client/client/list']
                    },
                    {
                      label: 'Liste affliate',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/client/affliate/list']
                    },
                    {
                      label: 'Liste statut client',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/client/statut-client/list']
                    },
                ]
              },
              {
                label: 'Scrapping Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste scrapping operation item',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/scrapping/scrapping-operation-item/list']
                    },
                    {
                      label: 'Liste scrapping operation',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/scrapping/scrapping-operation/list']
                    },
                    {
                      label: 'Liste type produit',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/scrapping/type-produit/list']
                    },
                ]
              },
              {
                label: 'Web Site Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste statut web site',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/website/statut-web-site/list']
                    },
                    {
                      label: 'Liste scrapping link',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/webSite/scrapping-link/list']
                    },
                    {
                      label: 'Liste web site',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/website/web-site/list']
                    },
                ]
              },
              {
                label: 'Notification Management',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste statut notification',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/notification/statut-notification/list']
                    },
                    {
                      label: 'Liste notification',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/notification/notification/list']
                    },
                ]
              },
    ]
        if (this.authService.authenticated) {
      if (this.authService.authenticatedUser.roles) {

        this.authService.authenticatedUser.roles.forEach(role => {
          const roleName: string = this.getRole(role);
          this.roleService._role.next(roleName.toUpperCase());
          eval('this.model = this.model' + this.getRole(role));
        })
      }

    }
  }
  getRole(text){
  const [role, ...rest] = text.split('_');
  return rest.join('').toLowerCase();
}
  onMenuClick(event) {
    this.appMain.onMenuClick(event);
  }
}
