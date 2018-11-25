export class CalcularCantidadResponse {

	costoTotal: number;
	data: Array<CantidadResponse>;
	
}

export class CantidadResponse {
	descripcion: string;
	cantidadAComprar: number;
	costoTotal: number;
}

export class Producto {
	id: number;
	descripcion: string;
	costo: number;
	costoAlmacenamiento: number;
	costoAgotamiento: number;
	costoDeOrden: number;
	precioVenta: number;
	stock: number;
	demandaEstimada: number;

	constructor(id:number, descripcion:string, costo:number, 
		costoAlmacenamiento:number, costoDeOrden:number, 
		precioVenta:number, stock:number, demandaEstimada:number) {
        this.id = id;
        this.descripcion = descripcion;
        this.costo = costo;
        this.costoAlmacenamiento = costoAlmacenamiento;
        this.costoDeOrden = costoDeOrden;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.demandaEstimada = demandaEstimada;
    }
}

export class ProductoRequest {
	data: Array<Producto>;
}