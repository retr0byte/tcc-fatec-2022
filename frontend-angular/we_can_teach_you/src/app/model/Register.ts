export interface Register {
	fullname: string;
	email: string;
	password: string;
	passwordConfirmation?: string;
	profile: { name: string, value: string };
}

export interface RegisterRequest {
	nome: string;
	email: string;
	senha: string;
	perfis: number[];
}

export interface RegisterResponse {
	id: number;
	nome: string;
	email: string;
	perfis: number[];
	sexo?: any;
	dataNascimento?: any;
	numeroCelular?: any;
	cpf?: any;
	nivelEscolaridade?: any;
	categorias?: any;
}
