export class Reservation {

  id: string;

  name: string;

  tableId: string;

  email: string;

  reservedFrom: Date;

  reservedTo: Date;

  constructor(id, name, tableId, email, reservedFrom, reservedTo) {
    this.id = id;
    this.name = name;
    this.tableId = tableId;
    this.email = email;
    this.reservedFrom = reservedFrom;
    this.reservedTo = reservedTo;
  }
}
