import { TestBed, async } from '@angular/core/testing';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { DashboardComponent } from './views/dashboards/dashboard/dashboard.component';
import { LoginComponent } from './login/login/login.component';

describe('AppComponent', () => {
  const routes: Routes = [
    {path: 'dashboard', component: DashboardComponent},
    {path: 'login', component: LoginComponent}
  ];
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));
  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
  it(`should have as title 'project2-rev'`, async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('project2-rev');
  }));
  it('should render title in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to project2-rev!');
  }));
});
