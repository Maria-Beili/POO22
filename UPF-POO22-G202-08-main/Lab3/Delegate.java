import java.util.Date;
import java.util.LinkedList;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.common.BitMatrix;

public class Delegate extends Member{
    
    //Atributs 
    private LinkedList<Regular> dependentsList;
    private Headquarter headOf;

    //Constructor
    public Delegate(String n, int p, String e, Headquarter h){
        super(n,p,e,h);
        dependentsList = new LinkedList<Regular>();
    }

    //Mètodes
    public void setHeadOf(Headquarter h){
        headOf = h;
    }

    public void addDependents(Regular r){
        dependentsList.add(r);
    }

    public void setAvailability(Availability a){
        super.setAvailabiliy(a);
    }

    public void printDelegate(){
        System.out.print(super.getName() + "\n");
        super.printAvailability();
    }
    
    public String toString(){
        return super.getName();
    }

    public Image genDelegateQR(String path){
        String path_i = "Images/" + path + ".jpg";
        Image i = new Image(path_i, 50, 50);
        String delegate_name = super.getName();
        String text = "This is a QR for a Delegate Member. You don't have to care about rising sea levels, if you live on a mega yatch. Created by ";
        text = text + delegate_name;
        BitMatrix qr = QRLib.generateQRCodeImage(text, 50, 50);
        i.setBitMatrix(qr);
        return i;
    }

     
    public Image genRegularQR(String path){
        String path_i = "Images/" + path + ".jpg";
        Image i = new Image(path_i, 50, 50);
        String delegate_name = super.getName();
        String text = "This is a QR for a Regular Member. Climate change doesn't matter, if you stay indoors. Created by ";
        text = text + delegate_name;
        BitMatrix qr = QRLib.generateQRCodeImage(text, 50, 50);
        i.setBitMatrix(qr);
        return i;
    }
    

    public boolean singUpDelegate(Delegate d, Image i, Headquarter h){
        BinaryBitmap b = i.getBitmap();
        String delegate_name = super.getName();
        String text = QRLib.decodeQRCodeImage(b);
        String delegate_text = "This is a QR for a Delegate Member. You don't have to care about rising sea levels, if you live on a mega yatch. Created by ";
        delegate_text = delegate_text + delegate_name;

        if(! headOf.equals(h)){
            System.out.println("El delegat no pertany a la seu");
            return false;
        }

        if (! delegate_text.equals(text)){
            System.out.println("El QR no és de delegat");
            return false;
        }

        i.save();
        headOf.addMember(d);
        return true;
    }

    
    public boolean singUpRegular(Regular r, Image i, Headquarter h){
        BinaryBitmap b = i.getBitmap();
        String delegate_name = super.getName();
        String text = QRLib.decodeQRCodeImage(b);
        String regular_text = "This is a QR for a Regular Member. Climate change doesn't matter, if you stay indoors. Created by ";
        regular_text = regular_text + delegate_name;

        if(! headOf.equals(h)){
            System.out.println("El delegat no pertany a la seu");
            return false;
        }

        if (! regular_text.equals(text)){
            System.out.println("El QR no és de regular");
            return false;
        }

        i.save();
        headOf.addMember(r);
        return true;
    }
    

    public void proposeAction(Action a){
        Organization o = headOf.getOrganization();
        o.addAction(a);
    }

    public void singUpAction(Date d){
        Organization o = headOf.getOrganization();
        Action a = o.getAction(d);
        headOf.singUpAction(a, 0, 0, false);
    }

}
