import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PedidoComponent } from './pedido/pedido.component';
import { ConsultaPedidoComponent } from './consulta-pedido/consulta-pedido.component';


const routes: Routes = [
  { path: 'pedido', component: PedidoComponent },
  { path: 'consultaPedido', component: ConsultaPedidoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
