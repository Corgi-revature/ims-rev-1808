import { Txact } from "./txact";
import { Item } from "./item";
import { User } from "./user";

export class Order {
    id: number;
    item: Item;
    amount: number;
    user: User;
    txact: Txact;
    address: string;
}
