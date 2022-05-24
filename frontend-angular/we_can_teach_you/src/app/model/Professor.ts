import { Category } from "./Category";


export interface Professor {
	id: number;
	nome: string;
	email: string;
	perfis: number[];
	sexo?: any;
	dataNascimento?: any;
	numeroCelular?: any;
	cpf?: any;
	certificado?: any;
	liberado?: any;
	nivelEscolaridade?: any;
	categorias: Category[];
}
