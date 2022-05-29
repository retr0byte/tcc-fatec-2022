import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriaisAulasComponent } from './materiais-aulas.component';

describe('MateriaisAulasComponent', () => {
  let component: MateriaisAulasComponent;
  let fixture: ComponentFixture<MateriaisAulasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MateriaisAulasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MateriaisAulasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
