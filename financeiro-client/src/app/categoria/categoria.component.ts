import { Component, OnInit } from '@angular/core';
import { CategoriaService } from '../services/categoria/categoria.service';
import {
  Categoria,
  SubCategoria,
} from '../services/categoria/model/categoria.model';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.scss'],
})
export class CategoriaComponent implements OnInit {
  categorias?: Categoria[];
  selectedObject?: Categoria;

  subCategorias?: SubCategoria[];
  selectedSubCategoria?: SubCategoria;

  constructor(private service: CategoriaService) {}

  ngOnInit(): void {
    this.service.getCategorias().subscribe((cat) => {
      this.categorias = cat;
    });
  }

  onChange(event: any) {
    console.log(this.selectedObject);
    this.subCategorias = this.selectedObject?.subCategorias;
  }

  onChangeSubCategoria(event: any) {
    console.log(this.selectedSubCategoria);
  }
}
