package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class ViitegeneraattoriAlk implements Viitegeneraattori {
    
    private int seuraava;
    
    public ViitegeneraattoriAlk(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
