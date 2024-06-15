import { Component } from '@angular/core';
import { MenuComponent } from './componentes/menu/menu.component';

@Component({
  selector: 'lib-template-test-ng',
  standalone: true,
  imports: [MenuComponent],
 templateUrl: './template-test-ng.componen.html',
  styleUrl: './template-test-ng.component.css'
})
export class TemplateTestNgComponent {

}
