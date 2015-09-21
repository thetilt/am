package br.com.brasilDoador.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.brasilDoador.daoimpl.CampanhaDAOImpl;
import br.com.brasilDoador.daoimpl.PessoaFisicaDAOImpl;
import br.com.brasilDoador.daoimpl.PessoaJuridicaDAOImpl;
import br.com.brasilDoador.daoimpl.PreAgendamentoDAOImpl;
import br.com.brasilDoador.daoimpl.SexoDAOImpl;
import br.com.brasilDoador.daoimpl.TipoDoadorDAOImpl;
import br.com.brasilDoador.daoimpl.TipoSanguineoDAOImpl;
import br.com.brasilDoador.entity.Campanha;
import br.com.brasilDoador.entity.PessoaFisica;
import br.com.brasilDoador.entity.PessoaJuridica;
import br.com.brasilDoador.entity.PreAgendamento;
import br.com.brasilDoador.entity.Sexo;
import br.com.brasilDoador.entity.TipoDoador;
import br.com.brasilDoador.entity.TipoSanguineo;
import br.com.brasilDoador.exception.DBCommitException;
import br.com.brasilDoador.singleton.EMFSingleton;



public class TestePersist {

	public static void main(String[] args) {
		
		EntityManager em = EMFSingleton.getInstance().createEntityManager();
		
		PessoaJuridica pJuridica = new PessoaJuridica();
		
		pJuridica.setEndereco("Rua 1,2");
		pJuridica.setNome("DANIEL OLIVEIRA LEMOS");
		pJuridica.setEmail("daniel.o.pedrera@ggmuil.com");
		pJuridica.setRazaoSocial("Cavalaria Samoa");
		pJuridica.setSenha("6565654644");
		pJuridica.setTelefone("65465464");
		pJuridica.setStatusCadastro(true);
		pJuridica.setSenha("65465456");
		
		
		PessoaJuridicaDAOImpl pJuridicaDAO = new PessoaJuridicaDAOImpl(em);
		
		try {
			pJuridicaDAO.insert(pJuridica);
		} catch (DBCommitException e) {
			
			e.printStackTrace();
		}
		
		
		TipoDoador tipoDoador = new TipoDoador();
		tipoDoador.setDescricao("Doador Plus");
		
		
		TipoDoadorDAOImpl tipoDoadorDAO = new TipoDoadorDAOImpl(em);
		
		try {
			tipoDoadorDAO.insert(tipoDoador);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Sexo sexo = new Sexo();
		sexo.setDescricao("Masculino");
		
		SexoDAOImpl sexoDao = new SexoDAOImpl(em);
		
		
		try {
			sexoDao.insert(sexo);
		} catch (DBCommitException e2) {
			
			e2.printStackTrace();
		}
		
		
		TipoSanguineo tipoSanguineo = new TipoSanguineo();
		
		tipoSanguineo.setDescricao("O+");
		
		TipoSanguineoDAOImpl tiposanguineoDAO = new TipoSanguineoDAOImpl(em);
		
		try {
			tiposanguineoDAO.insert(tipoSanguineo);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setDataNascimento(Calendar.getInstance());
		pessoaFisica.setEndereco("Rua 1, numero 2");
		pessoaFisica.setGenero(sexo);
		pessoaFisica.setNome("Daniel Oliveira Lemos");
		pessoaFisica.setEmail("jeromelvieira@hotmail.com");
		pessoaFisica.setPeso(54);
		pessoaFisica.setPontuacao(0);
		pessoaFisica.setTipo(tipoDoador);
		pessoaFisica.setTipoSanguineo(tipoSanguineo);
		pessoaFisica.setTelefone("64554644");
		pessoaFisica.setUltimaDoacao(Calendar.getInstance());
		pessoaFisica.setUltimaDoacao(Calendar.getInstance());
		pessoaFisica.setSenha("131113111");
		
		PessoaFisicaDAOImpl pfisicaDAO = new PessoaFisicaDAOImpl(em);
		
		try {
			pfisicaDAO.insert(pessoaFisica);
		} catch (DBCommitException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		Campanha campanha = new Campanha();
		
		campanha.setDataFim(Calendar.getInstance());
		campanha.setDataInicio(Calendar.getInstance());
		campanha.setDescricao("Campanha da doação doadora");
		campanha.setPj(pJuridica);
		
		CampanhaDAOImpl campanhaDAO = new CampanhaDAOImpl(em);
		try {
			campanhaDAO.insert(campanha);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PreAgendamento preAgenda = new PreAgendamento();
		
		preAgenda.setDataAgendamento(Calendar.getInstance());
		preAgenda.setHoraAgendamento(Calendar.getInstance());
		preAgenda.setPessoafisica(pessoaFisica);
		preAgenda.setPf(pJuridica);
		
		PreAgendamentoDAOImpl preAgendamentoDAOImpl = new PreAgendamentoDAOImpl(em);
		
		try {
			preAgendamentoDAOImpl.insert(preAgenda);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (TipoSanguineo tipo : tiposanguineoDAO.listar()) {
			System.out.println(tipo.getDescricao());
		}
		
		
		
		
		

	}

}
