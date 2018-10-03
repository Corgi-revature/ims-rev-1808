import { UserType } from './usertype';

export class User {
    id: number;
    first: string;
    last: string;
    phone: string;
    email: string;
    password: string;
    usertype: UserType;
}
