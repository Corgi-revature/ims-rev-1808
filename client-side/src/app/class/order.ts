import { Txact } from "./txact";
import { Item } from "./item";
import { User } from "./user";

export class Order {
    id: number;
    inventoryitem: Item;
    amount: number;
    user: User;
    tx: Txact;
    address: string;
}
