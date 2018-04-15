import { Component,OnInit } from '@angular/core';
import { DashboardService } from '../../../service/dashboard.service';
@Component({
    selector: 'income-counter',
	templateUrl: './income-counter.component.html'
})
export class IncomeCounterComponent implements OnInit { 

	OccMetier = null;
	OccProduit = null;
	OccType = null;
	OccuMotCle = null;

	constructor(private dashboardService: DashboardService) {
	}


	ngOnInit() {
		this.GetOccProduit();
		this.GetOccType();
		this.GetOccuMotCle();
	}

	GetOccuMotCle() {
		return this.dashboardService.GetOccuMotCle().subscribe(
			data => {
				this.OccuMotCle = data;
			}
		)
	}

	GetOccType() {
		return this.dashboardService.GetOccType().subscribe(
			data => {
				this.OccType = data;
			}
		)
	}

	GetOccProduit() {
		return this.dashboardService.GetOccProduit().subscribe(
			data => {
				this.OccProduit = data;
			}
		)
	}
	
}