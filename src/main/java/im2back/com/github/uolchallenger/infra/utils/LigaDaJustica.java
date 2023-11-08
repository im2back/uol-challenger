package im2back.com.github.uolchallenger.infra.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "liga_da_justica")
public class LigaDaJustica {
    private Codinomes codinomes;

    @XmlElement(name = "codinomes")
    public Codinomes getCodinomes() {
        return codinomes;
    }

    public void setCodinomes(Codinomes codinomes) {
        this.codinomes = codinomes;
    }
}

 class Codinomes {
    private List<String> codinomeList;

    @XmlElement(name = "codinome")
    public List<String> getCodinomeList() {
        return codinomeList;
    }

    public void setCodinomeList(List<String> codinomeList) {
        this.codinomeList = codinomeList;
    }
}
