import java.text.SimpleDateFormat;
import java.util.Date;

public class Contrato {
    private Funcionario funcionario;
    private boolean efetivo;
    private boolean horista;
    private float salario;
    private Date dataAdmissao;

    public Contrato(Funcionario funcionario, boolean efetivoHorista, float salario, int numFilhos, Date dataAdmissao){ //efetivoHorista recebe true para funcionario efetivo, false para horista

        this.setFuncionario(funcionario);

        if (efetivoHorista){
            this.setEfetivo();

        }else {
            this.setHorista();
        }

        this.setSalario(salario);
        funcionario.setNumFilhos(numFilhos);
        this.setDataAdmissao(dataAdmissao);
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    private void setEfetivo(){
        this.efetivo = true;
    }

    public boolean isEfetivo() {
        return efetivo;
    }

    private void setHorista(){
        this.horista = true;
    }

    public boolean isHorista(){
        return horista;
    }

    public void mudaContrato(){
        if (this.isEfetivo()){
            this.setHorista();

        }else {
            this.setEfetivo();
        }
    }

    public String tipoContrato(){
        if (this.isEfetivo()){
            return "Efetivo";

        }else {
            return "Horista";
        }
    }

    public float getSalario(){
        return salario;
    }

    public void setSalario(float salario){
        this.salario = (salario > 0) ? salario : 0;
    }

    public Date getDataAdmissao(){
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return funcionario.toString() + "\nTipo de contrato: " + this.tipoContrato() + "\nSalário contratado: " + this.salario + "\nAdimitido em: " + sdf.format(this.dataAdmissao) + "\n---------------------------------------------------------------";
    }
}
