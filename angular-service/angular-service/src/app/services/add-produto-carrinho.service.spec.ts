import { TestBed } from '@angular/core/testing';

import { AddProdutoCarrinhoService } from './add-produto-carrinho.service';

describe('AddProdutoCarrinhoService', () => {
  let service: AddProdutoCarrinhoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddProdutoCarrinhoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
