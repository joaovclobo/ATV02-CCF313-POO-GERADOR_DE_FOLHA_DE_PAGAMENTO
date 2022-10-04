import java.util.ArrayList;

public class Empresa {

    ArrayList<Funcionario> funcionarios;
    ArrayList<Contrato> contratos;

    public Empresa(){
        this.funcionarios = new ArrayList<>();
        this.contratos = new ArrayList<>();
    }

    public void contrata(Funcionario funcionario, Contrato contrato){
        this.funcionarios.add(funcionario);
        this.contratos.add(contrato);
    }

    private int getIndiceFuncionario(Funcionario funcionario){
        int i;

        for (i = 0; i < funcionarios.size(); i++) {
            if (this.funcionarios.get(i) == funcionario) {
            return i;
            }
        } return 0;
    }

    public float calcSalarioBruto(int horasTrabalhadas, Funcionario funcionario){
        int iFuncionario = getIndiceFuncionario(funcionario);

        if (iFuncionario >= 0) {
            if (this.contratos.get(iFuncionario).isHorista()) {
                return this.contratos.get(iFuncionario).getSalario() * horasTrabalhadas;
            } else {
                return this.contratos.get(iFuncionario).getSalario();
            }
        }else {
            System.out.println("Funcionário não encontrado!");
            return 0;
        }
    }

    public double calcInss(int horasTrabalhadas, Funcionario funcionario){
        int iFuncionario = getIndiceFuncionario(funcionario);
        float salarioBruto = calcSalarioBruto(horasTrabalhadas, funcionario);

        if (iFuncionario >= 0 && salarioBruto > 0) {
            if (salarioBruto <= 1659.38) {
                return salarioBruto * 0.08;

            } else if (salarioBruto > 1659.38 && salarioBruto < 2765.66) {
                return salarioBruto * 0.09;

            } else if (salarioBruto > 2765.67 && salarioBruto < 5531.31) {
                return salarioBruto * 0.11;
            } else {
                return 5531.31 * 0.11;

            }
        } else {
            System.out.println("Funcionário não encontrado!");
            return 0;
        }
    }

    public double calcImpostoRenda(int horasTrabalhadas, Funcionario funcionario){
        int iFuncionario = getIndiceFuncionario(funcionario);
        float salarioBruto = calcSalarioBruto(horasTrabalhadas, funcionario);

        if (iFuncionario >= 0 && salarioBruto > 0) {
            if (salarioBruto <= 1903.998) {
                return (salarioBruto * 0.075) - 142.8;

            } else if (salarioBruto > 1903.99 && salarioBruto < 3751.05) {
                return (salarioBruto * 0.15) - 354.8;

            } else if (salarioBruto > 3751.06 && salarioBruto < 4664.68) {
                return (salarioBruto * 0.225) - 636.13;

            } else {
                return (salarioBruto * 0.275) - 869.36;

            }
        } else {
            System.out.println("Funcionário não encontrado!");
            return 0;
        }
    }

    public double calcSalarioLiquido(int horasTrabalhadas, Funcionario funcionario){
        return calcSalarioBruto(horasTrabalhadas, funcionario) - calcInss(horasTrabalhadas, funcionario) - calcImpostoRenda(horasTrabalhadas, funcionario);
    }

    public void folhaPagamento(int horasTrabalhadas, Funcionario funcionario){

        System.out.println(funcionario.toString());
        System.out.println("Salario bruto: " + calcSalarioBruto(horasTrabalhadas, funcionario));
        System.out.println("Desconto INSS: " + calcInss(horasTrabalhadas, funcionario));
        System.out.println("Desconto imposto de renda: " + calcImpostoRenda(horasTrabalhadas, funcionario));
        System.out.println("Salario liquido: " + calcSalarioLiquido(horasTrabalhadas, funcionario) + "\n===============================================================\n\n");
    }
}
