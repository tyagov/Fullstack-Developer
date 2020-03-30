import { Component, OnInit, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Produto } from '../models/produto';
import { Cliente } from '../models/cliente';

import { AddProdutoCarrinhoService } from '../services/add-produto-carrinho.service';
import { ApizuulService } from '../services/apizuul.service';
import { Pedido } from '../models/pedido';


@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class PedidoComponent implements OnInit {
  produtos: Produto[];
  clientes: Cliente[];
  produtoAdicionado: Produto[] = [];
  valorTotal: number = 0;
  freteTotal: number = 0;
  quantidadeCalcular: number = 0;
  totalPedido: number = 0;
  pedido: Pedido;
  codigoPedido: string;

  clienteFormControl = new FormControl();
  produtoFormControl = new FormControl();

  constructor(
    private serviceZuul: ApizuulService,
    private addProdutosService: AddProdutoCarrinhoService,
    private cd: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.serviceZuul.getProdutos().subscribe((produtos: Produto[]) => {
      this.produtos = produtos;
    },
      erro => {

      });
    this.serviceZuul.getClientes().subscribe((clientes: Cliente[]) => {
      this.clientes = clientes;
    },
      erro => {

      });

    this.codigoPedido = String(Math.random() * (99999999 - 1) - 1 + Date.now()).substr(0, 8);
  }

  addCarrinho(produto: Produto) {

    produto.quantidadeProduto = 1;
    this.quantidadeCalcular += 1;

    this.addProdutosService.addProduto(produto);
    this.getProdutosCarrinho();
    this.calcularTotal();
    this.update();
  }

  getProdutosCarrinho() {
    this.produtoAdicionado = this.addProdutosService.getProdutos();
  }
  removerCarrinho(produto: Produto) {
    this.addProdutosService.removarProduto(produto);
    this.calcularTotal();
    this.update();

  }

  calcularValorTotal(quantidade: number, produto: Produto) {

    produto.quantidadeProduto = quantidade;

    this.calcularTotal();

    this.update();

  }
  calcularTotal() {
    this.valorTotal = 0;
    this.freteTotal = 0;
    this.produtoAdicionado.forEach(element => {
      element.valorTotal = element.quantidadeProduto * element.precoUnitario;
      this.valorTotal += element.valorTotal;
      this.quantidadeCalcular += Number(element.quantidadeProduto);

    });
    this.calcularValorFreteService();

  }

  calcularValorFreteService() {
    this.quantidadeCalcular = 0;
    this.produtoAdicionado.forEach(element => {
      this.quantidadeCalcular += Number(element.quantidadeProduto);

    });

    this.serviceZuul.calcularFrete(this.quantidadeCalcular).subscribe((valor: number) => {
      this.freteTotal += valor;
      this.totalPedido = this.freteTotal + this.valorTotal;
      this.update();
    });

  }

  gravarPedito() {
    this.pedido = new Pedido();
    this.pedido.codigoPedido = this.codigoPedido;
    this.pedido.quantidadeTotal = this.quantidadeCalcular;
    this.pedido.valorFrete = this.freteTotal;
    this.pedido.valorTotal = this.totalPedido;

    this.serviceZuul.postPedido(this.pedido).subscribe(
      () => {
        alert("Pedido não realizado!");
      },
      () => {
        this.limparCarrinho();
        alert("Pedido realizado com Sucesso!");
      }
    );
  }

  limparCarrinho() {
    this.produtoFormControl.setValue("");
    this.addProdutosService.limparLista();
    this.produtoAdicionado = [];
    this.valorTotal = 0;
    this.freteTotal = 0;
    this.quantidadeCalcular = 0;
    this.totalPedido = 0;
    this.update();
  }
  update() {
    this.cd.detectChanges();
  }

  isEmptyObject() {
    if (this.produtoAdicionado.length === 0) {
      return true;
    } else {
      return false;
    }
  }



}



