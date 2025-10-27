package notenschnitt;

import org.springframework.stereotype.Component;

@Component
public class schnittservice {

        public double berechneNotenschnitt(double[] noten) {
            if (noten == null || noten.length == 0) 
                return 0.0;
            
            double summe = 0;
            for (double n : noten) {
                summe += n;}

                return summe / noten.length;
            
        
            
        
    }

}
