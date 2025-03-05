package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(Long id, String cpf, String email, Endereco endereco, String telefone, String nome) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getCpf(), paciente.getEmail(), paciente.getEndereco(), paciente.getTelefone(), paciente.getNome());
    }
}
