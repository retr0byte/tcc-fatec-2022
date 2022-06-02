export interface Faq {
    classId: string | null,
    tituloPergunta: string,
    respostaPergunta: string;
  }
  
  export interface FaqResponse {
    id: number;
    tituloPergunta: string,
    respostaPergunta: string;
  }
  
  export interface FaqRequest {
    tituloPergunta: string,
    respostaPergunta: string;
    funcionario: { id: number };
  }
  