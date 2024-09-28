public class ColorFrame extends Frame{
    
    //Constructor
    public ColorFrame(int n, int m) {
        super(n, m);
    }
    
    //Mètodes
    public void setColor(int i, int j, int r, int g, int b){
        double ret = RGBToVal(r, g, b);
        super.set(i,j,ret);
    }

    public int[] getColor(int i, int j){
        double rgb = super.get(i, j);
        int[] color = valToRGB(rgb);
        return color;
    }


    @Override
    public void changeBrightness(double delta) {
        for (int i=0; i<super.getrows(); i++){
            for (int j =0; j<super.getcols(); j++){
                int[] rgb = getColor(i,j);
                double val = RGBToVal(rgb[0], rgb[1], rgb[2]);
                val = val*delta;
                super.set(i,j,val);               
            }
        }
    }

    public void changeRGB(int dR, int dG, int dB){
        for (int i=0; i<super.getrows(); i++){
            for (int j =0; j<super.getcols(); j++){
                int[] rgb = getColor(i,j);
                rgb[0] = rgb[0]+dR;
                rgb[1] = rgb[1]+dG;
                rgb[2] = rgb[2]+dB;
                for (int z=0; z<rgb.length;z++){
                    if (rgb[z] > 255){
                        rgb[z] = 255;
                    } 
                    if (rgb[z] < 0){
                        rgb[z] = 0;
                    }
                }
                setColor(i, j, rgb[0], rgb[1], rgb[2]);
            }
        }
    }

    private int[] valToRGB(double rgb) {
        int[] ret = new int[3];
        ret[0] = ((int) rgb >>16) & 255;
        ret[1] = ((int) rgb >>8) & 255;
        ret[2] = ((int) rgb) & 255;
        return ret;
    }

    private double RGBToVal(int r, int g, int b){
        double ret = (r<<16) | (g<<8) | b;
        return ret;
    }
}
