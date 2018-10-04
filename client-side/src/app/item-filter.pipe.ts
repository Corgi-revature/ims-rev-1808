import { Pipe, PipeTransform } from '@angular/core';
import { Item } from './class/item';

@Pipe({
  name: 'itemFilter'
})
export class ItemFilterPipe implements PipeTransform {

  transform(items: Item[], searchText: string): Item[] {
    if(!items) {
      return [];
    }
    searchText = searchText.toLowerCase();
    return items.filter( item => {
      let search: boolean;
      search = item.name.toLowerCase().includes(searchText);
      return search;
    });
  }
}
