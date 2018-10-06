import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-breadcrumbs',
  templateUrl: './breadcrumbs.component.html',
  styleUrls: ['./breadcrumbs.component.css']
})
export class BreadcrumbsComponent implements OnInit {
  route: String;
  constructor(private router: Router) { }

  ngOnInit() {
    this.test();
  }
  getRoute() {
    console.log(this.router.url);
    this.route = this.router.url;
  }

  test () {
    this.router.events.subscribe((event) => {
      console.log(event);
      if (event instanceof NavigationEnd ) {
        this.route = event.url;
      }
    });
  }

}
