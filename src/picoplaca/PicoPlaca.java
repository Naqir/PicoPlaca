package picoplaca;

import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Crx
 */
public class PicoPlaca {

   public String Inputs(String msg){                //method for inputs
      return JOptionPane.showInputDialog(msg);
   } 
   
   public String[] Strp(String word, String div){   //method for text processing
      return word.split(div);
   }
   
   public void Predictor(int dig, int date, int hour){  //method for prediction
       if( (dig == 2*date-1 || dig == 2*date) && ((hour >= 7 && hour <= 9 ) || (hour >= 16 && hour <= 19 )) ){
            JOptionPane.showMessageDialog(null, "Can not be on the road");
            
        }
       else{
            JOptionPane.showMessageDialog(null, "Can be on the road");
        }
   }
   
    public static void main(String[] args) {
        PicoPlaca obj=new PicoPlaca();
        int dig,timeh;
        String date, numberp, time;
        String[] temp, temp1, temp3;
        Calendar date1 = Calendar.getInstance();
        
        //User Inputs
        numberp=obj.Inputs("Enter your license plate number e.g pbm-3455");
        date=obj.Inputs("Enter date e.g 2018-01-02");
        time=obj.Inputs("Enter time e.g 14:00");
        
        //text processing
        temp=obj.Strp(date, "-");
        temp1=obj.Strp(numberp, "-");
        temp3=obj.Strp(time, ":");
        
        dig=Integer.parseInt(temp1[1])%10;
        timeh=Integer.parseInt(temp3[0]);
        date1.set(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])-1, Integer.parseInt(temp[2])-1);
        
        //Las siguientes son impresiones del programa para verificar su funcionamiento
        System.out.println("Hoy es : " + date1.get(Calendar.DAY_OF_WEEK));
        System.out.println("El ultimo digito es : " + dig);
        System.out.println("Las restriciones son : " + (2*date1.get(Calendar.DAY_OF_WEEK)-1)+(2*date1.get(Calendar.DAY_OF_WEEK)) );
        System.out.println("La hora es " + timeh);
        //Prediction
        obj.Predictor(dig, date1.get(Calendar.DAY_OF_WEEK), timeh);
        
    }
    
}
