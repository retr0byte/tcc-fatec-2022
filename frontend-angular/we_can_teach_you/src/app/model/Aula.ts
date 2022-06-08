export interface Aula {
    classId: string | null,
    link: string,
    name: string,
    description: string;
    date: string;
    time: string;
    valor: number;
  }

export interface AulaResponse {
    id: number;
    linkReuniao: string;
	  nome: string;
    descricao: string;
    dataAula: string;
    duracaoAula: string;
    valorAula: number;
  }
  