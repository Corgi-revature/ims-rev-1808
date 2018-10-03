export class Txact {
    // This is the id (also the 1:M relationship with Orders)
    id: number;
    created: string;
    token: string;
    // Emulated transaction id
    txid: string;
    status: string;

}
