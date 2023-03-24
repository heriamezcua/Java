package desarrollozaidin;



import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAW-B
 */
public class OrdenarComercialMayorVentas implements Comparator<Comercial> {

    @Override
    public int compare(Comercial o1, Comercial o2) {
        int result = -2;
        if (o1.getNumVentas() > o2.getNumVentas()) {
            result = -1;
        } else if (o1.getNumVentas() == o2.getNumVentas()) {
            result = 0;

        } else {
            result = 1;
        }

        return result;
    }

}
