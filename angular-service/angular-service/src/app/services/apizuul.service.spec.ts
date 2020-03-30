import { TestBed } from '@angular/core/testing';

import { ApizuulService } from './apizuul.service';

describe('ApizuulService', () => {
  let service: ApizuulService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApizuulService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
