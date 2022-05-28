export interface Marcacoes {
  classId: string | null,
  time: string,
  title: string,
  description: string;
}

export interface MarcacoesResponse {
  id: number;
  nome: string;
  descricao: string;
  momentoMarcacao: string;
}

export interface MarcacoesRequest {
	nome: string;
	descricao: string;
	momentoMarcacao: string;
	aluno: { id: number };
	aula: { id: number };
}
