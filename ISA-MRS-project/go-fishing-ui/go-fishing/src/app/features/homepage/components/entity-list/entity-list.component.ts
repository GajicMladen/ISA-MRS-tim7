import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-entity-list',
  templateUrl: './entity-list.component.html',
  styleUrls: ['./entity-list.component.css'],
})
export class EntityListComponent implements OnInit {
  allItems: any[] = [];
  pageSlice: any[] = [];
  pageSize: number = 4;
  pageSizeOptions: number[] = [this.pageSize];

  constructor() {
    this.allItems = Array(30)
      .fill(0)
      .map((x, i) => i);
    this.pageSlice = this.allItems.slice(0, this.pageSize);
  }

  ngOnInit(): void {}

  onPageChange(event: PageEvent) {
    const startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex + event.pageSize;
    if (endIndex > this.allItems.length) endIndex = this.allItems.length;
    this.pageSlice = this.allItems.slice(startIndex, endIndex);
  }
}
