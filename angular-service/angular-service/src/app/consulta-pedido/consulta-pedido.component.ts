import { Component, OnInit } from '@angular/core'
import { ApizuulService } from '../services/apizuul.service';
import { Pedido } from '../models/pedido';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}



@Component({
  selector: 'app-consulta-pedido',
  templateUrl: './consulta-pedido.component.html',
  styleUrls: ['./consulta-pedido.component.css']
})



export class ConsultaPedidoComponent implements OnInit {

  pedidos: Pedido[];

  displayedColumns: string[] = ['id', 'codigo', 'nome', 'precoUnitario'];

  constructor(private serviceZuul: ApizuulService) { }

  ngOnInit(): void {
    this.serviceZuul.getPedidos().subscribe((data: Pedido[]) => {
      this.pedidos = data;
    },
      erro => {

      });
  }

}
