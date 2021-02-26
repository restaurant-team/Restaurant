import {Component, OnInit, TemplateRef} from '@angular/core';
import {ToastsService} from '../../core/_services/utils/toasts.service';

@Component({
  selector: 'app-toasts',
  templateUrl: './toasts.component.html',
  styleUrls: ['./toasts.component.css']
})
export class ToastsComponent implements OnInit {

  constructor(public toastsService: ToastsService) {
  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  isTemplate(toast) {
    return toast.textOrTpl instanceof TemplateRef;
  }

}
