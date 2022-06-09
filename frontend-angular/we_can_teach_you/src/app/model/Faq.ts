export interface Faq {
    id?: number,
    tituloPergunta: string,
    respostaPergunta: string;
    funcionario?: { id: number };
  }

  export interface FaqResponse {
    id: number,
    tituloPergunta: string,
    respostaPergunta: string;
    funcionario: { id: number };
  }