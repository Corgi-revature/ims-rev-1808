import { Item } from './item';
import { Supplier } from './supplier';

export class Delivery {
    id: number;
    items: Item;
    amount: number;
    supplier: Supplier;
}