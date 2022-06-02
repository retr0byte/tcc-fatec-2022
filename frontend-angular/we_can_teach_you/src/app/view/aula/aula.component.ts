import { isNgTemplate } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ControllerService } from 'src/app/controller/controller.service';



@Component({
  selector: 'app-aula',
  templateUrl: './aula.component.html',
  styleUrls: ['./aula.component.css']
})
export class AulaComponent implements OnInit {
  classId: string | null = null
  classSubsection: string | null = null;
  professorId: string | null = null;
  

  
  constructor(private route: ActivatedRoute, public ctrl: ControllerService) { }
  
  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.classId = params.get('classId');
      this.classSubsection = params.get('subsection');
      this.professorId = params.get('professorId');
    });
    
  }

}
