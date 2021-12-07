export interface Categoria {
  id: number
  descricao: string
  subCategorias: SubCategoria[]
}

export interface SubCategoria {
  id: number
  descricao: string
}
