import {Injectable, TemplateRef} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ToastsService {
  toasts: any[] = [];

  constructor() {
  }

  /*Shows the toast with a provided message.
    You can provide your own classes for the toast through the options parmether.
    Example of options: { classname: 'bg-success text-light' }
  */
  // tslint:disable-next-line:typedef
  toastAdd(textOrTpl: string | TemplateRef<any>, options: any = {}) {
    this.toasts.push({textOrTpl, ...options});
  }

  // tslint:disable-next-line:typedef
  toastAddSuccess(textOrTpl: string | TemplateRef<any>) {
    this.toastAdd(textOrTpl, {classname: 'bg-success text-light'});
  }

  // tslint:disable-next-line:typedef
  toastAddDanger(textOrTpl: string | TemplateRef<any>) {
    this.toastAdd(textOrTpl, {classname: 'bg-danger text-light'});
  }

  // tslint:disable-next-line:typedef
  toastAddWarning(textOrTpl: string | TemplateRef<any>) {
    this.toastAdd(textOrTpl, {classname: 'bg-warning text-light'});
  }

  // tslint:disable-next-line:typedef
  removeToast(toast) {
    this.toasts = this.toasts.filter(t => t !== toast);
  }

  // tslint:disable-next-line:typedef
  removeAll() {
    this.toasts = [];
  }

}
