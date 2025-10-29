package notenschnitt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class schnittController {

    @Autowired
    private schnittservice service;

    //public double getNotenschnitt(double[] noten) {
     //   return service.berechneNotenschnitt();
    //}

    public double getNotenschnitt() {
        return service.berechneNotenschnitt();
    }

}
