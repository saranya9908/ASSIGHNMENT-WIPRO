import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-calculator',
  imports: [CommonModule],
  templateUrl: './calculator.component.html',
  styleUrl: './calculator.component.css',
})
export class CalculatorComponent {
  display: string = '';
  buttons: string[] = [
    '7','8','9','/',
    '4','5','6','*',
    '1','2','3','-',
    '0','.','C','+',
    '='
  ];

  onPress(btn: string) {
    if (btn === 'C') {
      this.display = '';
    } else if (btn === '=') {
      try {
        this.display = eval(this.display);
      } catch {
        this.display = 'Error';
      }
    } else {
      this.display += btn;
    }
  }

  getButtonClass(btn: string): string {
    if (btn === 'C') return 'clear';
    if (btn === '=') return 'equal';
    if (['/', '*', '-', '+'].includes(btn)) return 'operator';
    return '';
  }
}
