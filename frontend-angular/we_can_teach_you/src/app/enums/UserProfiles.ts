import { Profiles } from '../model/Profiles'

export enum UserProfiles {
  ALUNO = 3,
  PROFESSOR = 4,
  FUNCIONARIO = 2
}

export const UserProfilesTranslations = {
  '3': 'ALUNO',
  '4': 'PROFESSOR',
  '2': 'FUNCIONARIO',
}

export const UserProfilesRoutes: Profiles = {
  'ALUNO': 'alunos',
  'PROFESSOR': 'professores',
  'FUNCIONARIO': 'funcionarios'
}



