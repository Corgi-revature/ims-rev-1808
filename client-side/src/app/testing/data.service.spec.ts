import { TestBed, inject } from '@angular/core/testing';
import { HttpEvent, HttpEventType } from '@angular/common/http';

import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';

import { DataService } from './data.service';
import { coreService } from '../core/core.service';

describe('DataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [DataService]
    });
  });

  it(
    'should get users',
    inject(
      [HttpTestingController, DataService],
      (
        httpMock: HttpTestingController,
        dataService: DataService
      ) => {
        const mockUsers = [
            { name: 'Bob', website: 'www.yessss.com' },
            { name: 'Juliette', website: 'nope.com' }
          ];
          
          dataService.getData().subscribe((event: HttpEvent<any>) => {
            switch (event.type) {
              case HttpEventType.Response:
                expect(event.body).toEqual(mockUsers);
            }
          });
          
          const mockReq = httpMock.expectOne(dataService.url);
          
          expect(mockReq.cancelled).toBeFalsy();
          expect(mockReq.request.responseType).toEqual('json');
          
          mockReq.flush(mockUsers);
          
          httpMock.verify();
      }
    )
  );
});

