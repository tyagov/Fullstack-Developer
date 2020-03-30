import { Injectable } from '@angular/core';
import { Produto } from '../models/produto';

@Injectable({
  providedIn: 'root'
})
export class AddProdutoCarrinhoService {
  produtos: Produto[] = [];
  constructor() { }

  addProduto(produto: Produto) {
    if(!this.produtos.find(e => e === produto)){
      this.produtos.push(produto);
    }
  }
  getProdutos() {
    return this.produtos;
  }
  removarProduto(produto: Produto) {
    let obj = this.produtos.indexOf(produto);
    this.produtos.splice(obj, 1); 
  }

  limparLista(){
    this.produtos = [];
  }
}
