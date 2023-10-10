import java.time.LocalDate;

public class PessoalFisica extends Pessoa {
    public String cpf;
    public LocalDate dataNasc;

    @Override
    public float CalcularImposto(float rendimento) {
        //    até 1500,00 - isento
        //    de 1500,00 a 3500,00 - 2%
        //    de 3500,00 a 6000,00 - 3,5%
        //    acima de 6000,00 -  5%
        if (rendimento <= 1500) {
            return 0;

        } else if (rendimento <= 3500) {
            return rendimento * .02f;

        } else if (rendimento <= 6000) {
            return rendimento * .035f;

        } else {
            return rendimento * .05f;

        }

    }
}
