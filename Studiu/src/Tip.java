import java.io.Serializable;

public class Tip extends MiniClasaMeaObject {
    public String tip;

    Tip(String tip){
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    @Override
    public String toString() {
        if(tip.equalsIgnoreCase("automobil"))
            return "\nTip{'" + tip + '\'' + '}' + "\nVariabile{Marca, Numarul de serie, Anul aparitiei, Pretul, Numarul de pasageri}";
        else
            return "\nTip{'" + tip + '\'' + '}' + "\nVariabile{Marca, Numarul de serie, Anul aparitiei, Pretul, Capacitatea transportarii}";
    }
}