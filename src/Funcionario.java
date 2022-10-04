import java.util.*;
import java.text.*;

public class Funcionario {
    private String nomeFuncionario;
    private Date dataNascimento;
    private int numFilhos;

    public Funcionario(String nomeFuncionario, Date dataNascimento){
        this.nomeFuncionario = nomeFuncionario;
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getNomeFuncionario(){
        return nomeFuncionario;
    }

    public int getNumFilhos(int numFilhos){
        return numFilhos;
    }

    public void setNumFilhos(int numFilhos){
        this.numFilhos = (numFilhos < 0) ? 0 : numFilhos;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Funcionario : " + this.nomeFuncionario + "\nData de nascimento: " + sdf.format(this.dataNascimento) + "\nNúmero de filhos menores de idade: " + numFilhos + "\n---------------------------------------------------------------";
    }
}