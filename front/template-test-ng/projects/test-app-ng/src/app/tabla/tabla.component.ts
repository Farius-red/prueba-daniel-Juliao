import { AfterViewInit, ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { MatGridTile } from '@angular/material/grid-list';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import {CoreModule} from 'template-test-ng';
import{PlantillaResponse} from '../../../../../node_modules/juliaositembackenexpress/src/utils/PlantillaResponse';
import{CreditoResponse} from '../../app/models/creditoResponse';
import{CreditoService} from '../../app/servicios/credito.service';
import { Subscription } from 'rxjs';
import { BreakpointObserver, BreakpointState, Breakpoints } from '@angular/cdk/layout';
import { MatDialog } from '@angular/material/dialog';
import { LayoutModule } from '@angular/cdk/layout';

@Component({
  selector: 'app-tabla',
  standalone: true,
  imports: [CoreModule,LayoutModule],
  templateUrl: './tabla.component.html',
  styleUrl: './tabla.component.scss'
})
export class TablaComponent implements OnInit, AfterViewInit {
  
  size = 0;
  rowSpam =4;
  usersResponse: PlantillaResponse<CreditoResponse> = {
    dataList: [],
  };


  displayedColumns: string[] = ['id',"aprobado"];
  dataSource = new MatTableDataSource<CreditoResponse>(this.usersResponse.dataList); 

 dataSize :number =0;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatGridTile) gridTile!: MatGridTile; 

   usersSubscription: Subscription | undefined;

  constructor(private creditoSvc: CreditoService,
    private dialog: MatDialog,private cdr: ChangeDetectorRef,
    private breakpointObserver: BreakpointObserver
  ) {}



  ngOnInit(): void {
    this.getAllUsers();
    this.dataSource.paginator = this.paginator;
    if(this.dataSize > 3 ){
        let size = this.dataSize - this.rowSpam
        this.rowSpam= this.rowSpam + size 
    } 
  }

  scremDataTable(){
    

    if(this.dataSize > 3 ){
    this.size  = this.dataSize - this.rowSpam
      this.rowSpam= this.rowSpam + this.size 
     } 

    this.breakpointObserver.observe([
      Breakpoints.XSmall,
      Breakpoints.Small,
      Breakpoints.XLarge
      
    ]).subscribe((state: BreakpointState) => {
     
      if (state.breakpoints[Breakpoints.Small]) {
        this.rowSpam= this.rowSpam  +  this.dataSize;
      }
      if (state.breakpoints[Breakpoints.XSmall]) {
        this.rowSpam = this.rowSpam  +  this.dataSize;
      }
   
    });
  }

  ngAfterViewInit(): void {
    
  }

  getAllUsers(id?: string | null, idBussines?: number | null): void {
    this.usersSubscription = this.creditoSvc.all(id, idBussines).subscribe({
      next: (response) => {
        this.usersResponse = response;
        console.log(this.usersResponse)
        this.dataSource.data = response?.dataList ?? [];
       this.dataSize = this.dataSource.data.length;
       this.scremDataTable()
      },
      error: (error) => {
        console.error(error);
      }
    });
  }



}
