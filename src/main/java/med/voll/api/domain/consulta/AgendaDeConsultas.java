package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {

        //pegando id do paciente e médico do banco de dados
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = medicoRepository.findById(dados.idMedico()).get();

        //criando uma consulta passando o médico e paciente de acordo com o id informado
        var consulta = new Consulta(null, medico, paciente, dados.data());

        //salvando a consulta no banco de dados
        consultaRepository.save(consulta);
    }
}
