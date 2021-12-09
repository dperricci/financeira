import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'orderBy',
  pure: true
})
export class ArraySortPipe implements PipeTransform {
  transform(list: any[], column: string): any[] {
    console.log(list);
    let sortedArray = list.sort((a , b) => {
      console.log('coluna: ' + a[column]);
      console.log('coluna: ' + b[column]);
      if(a[column] > b[column]){
        console.log("1");
        return 1;
      }
      if(a[column] < b[column]){
        console.log("-1");
        return -1;
      }
      console.log("0");
      return 0;
    });
    return sortedArray;
  }
}
