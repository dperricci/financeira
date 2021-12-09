import {
  Component,
  Input,
  OnChanges,
  OnInit,
  Pipe,
  PipeTransform,
  SimpleChanges,
} from '@angular/core';

import { ArraySortPipe } from './arraySortPipe';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent implements OnChanges {
  @Input() GridData: any;
  @Input() ColData: any;

  ngOnChanges(changes: SimpleChanges): void {}

  sortedColumn: string = 'descricao';
}
