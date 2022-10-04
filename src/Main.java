import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        Date dataNascFunc1 = sdf.parse("20/03/1999");
        cal.setTime(dataNascFunc1);
        Date dataNascFunc2 = sdf.parse("21/04/2009");
        cal.setTime(dataNascFunc2);
        Date dataNascFunc3 = sdf.parse("19/05/1963");
        cal.setTime(dataNascFunc3);
        Date dataNascFunc4 = sdf.parse("07/09/1971");
        cal.setTime(dataNascFunc4);

        Date dataAdimissao1 = sdf.parse("08/06/2070");
        cal.setTime(dataAdimissao1);
        Date dataAdimissao2 = sdf.parse("03/04/2080");
        cal.setTime(dataAdimissao2);
        Date dataAdimissao3 = sdf.parse("26/09/2077");
        cal.setTime(dataAdimissao3);
        Date dataAdimissao4 = sdf.parse("13/07/2000");
        cal.setTime(dataAdimissao4);

        Funcionario func1 = new Funcionario("Emminem", dataNascFunc1);
        Funcionario func2 = new Funcionario("Snoop Dog", dataNascFunc2);
        Funcionario func3 = new Funcionario("Two Pac", dataNascFunc3);
        Funcionario func4 = new Funcionario("Notorious Big", dataNascFunc4);

        Contrato contrato1 = new Contrato(func1, true, 8000, 0, dataAdimissao1);
        Contrato contrato2 = new Contrato(func2, false, 25, 4, dataAdimissao2);
        Contrato contrato3 = new Contrato(func3, false, 600, 1, dataAdimissao3);
        Contrato contrato4 = new Contrato(func4, true, 2500, 6, dataAdimissao4);

        Empresa aEmpresa = new Empresa();

        aEmpresa.contrata(func1, contrato1);
        aEmpresa.contrata(func4, contrato4);
        aEmpresa.contrata(func3, contrato3);
        aEmpresa.contrata(func2, contrato2);

        aEmpresa.folhaPagamento(20, func1);
        aEmpresa.folhaPagamento(320, func2);
        aEmpresa.folhaPagamento(80, func3);
        aEmpresa.folhaPagamento(80, func4);
    }
}