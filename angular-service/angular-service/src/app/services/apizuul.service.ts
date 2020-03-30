import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';
import { Produto } from '../models/produto';
import { Pedido } from '../models/pedido';

@Injectable({
  providedIn: 'root'
})
export class ApizuulService {
  urZuul = "http://localhost:8085";

  constructor(private httpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  getClientes(): Observable<Cliente[]> {
    return this.httpClient.get<Cliente[]>(this.urZuul + "/apiprodutocliente/cliente/listarTodosClientes");
  }

  getProdutos(): Observable<Produto[]> {
    return this.httpClient.get<Produto[]>(this.urZuul + "/apiprodutocliente/produto/listarTodosProdutos");
  }

  calcularFrete(quantidade: number): Observable<number> {
    return this.httpClient.get<number>(this.urZuul + "/calcularfreteservice/calcularFrete/" + quantidade);
  }

  getPedidos(): Observable<Pedido[]> {
    {
      return this.httpClient.get<Pedido[]>(this.urZuul + "/apiprodutocliente/pedido/consultarTodosPedidos");
    }
  }

  postPedido(pedido: Pedido): Observable<Pedido> {
    {
      return this.httpClient.post<Pedido>(this.urZuul + "/apiprodutocliente/pedido/realizarPedido", pedido);
    }
  }
}


// (method) HttpClient.put(url: string, body: any, options: {
//   headers?: HttpHeaders | {
//       [header: string]: string | string[];
//   };
//   observe?: "body";
//   params?: HttpParams | {
//       [param: string]: string | string[];
//   };
//   reportProgress?: boolean;
//   responseType: "arraybuffer";
//   withCredentials?: boolean;
// }): Observable<...> (+14 overloads)
// Constructs a PUT request that interprets the body as an ArrayBuffer and returns the response as an ArrayBuffer.

// @param url — The endpoint URL.

// @param body — The resources to add/update.

// @param options — HTTP options

// @return — An Observable of the response, with the response body as an ArrayBuffer.

// Expected 2-3 arguments, but got 1.ts(2554)
// http.d.ts(2765, 25): An argument for 'body' was not provided.
// Peek Problem
// No quick fixes available
