package Git;

public class Color{

    private int rojo;
    private int azul;
    private int verde;

    public Color(){
        rojo = 255;
        azul = 255;
        verde = 255;
    }
    
    public Color(int R, int A, int V){
        rojo = R;
        azul = A;
        verde = V;
    }

    public void variar(int valor){
        if (valor > 0){	
            azul = azul + valor < 255 ? azul + valor : 255; 
            rojo = rojo + valor < 255 ? rojo + valor : 255; 
        	verde = verde + valor < 255 ? verde + valor : 255;
        }
        else if (valor < 0) {
        	rojo = rojo - valor > 0 ?  rojo - valor : 0;
        	azul = azul - valor > 0 ? azul - valor : 0;
        	verde = verde - valor > 0 ? verde - valor : 0;
        }    
    }
    
    public void variarRojo(int valor){
        if (rojo + valor < 255)
            rojo = rojo + valor < 255 ? rojo + valor : 255;
        else if (valor < 0)
            rojo = rojo - valor > 0 ? rojo - valor : 0;
    }
    
    public void variarAzul(int valor){
        if (valor > 0)
            azul = azul + valor < 255 ? azul + valor : 255;
        else if (valor < 0)
            azul = azul - valor > 0 ? azul - valor : 0;
    }
    
    public void variarVerde(int valor){
        if (valor > 0)
            verde = verde + valor < 255 ? verde + valor : 255;
        else if (valor < 0)
            verde = verde - valor > 0 ? verde - valor : 0;
    }
    
    public void setRojo(int valor){
        rojo = valor;
    }
    
    public void setAzul(int valor){
        azul = valor;
    }
    
    public void setVerde(int valor){
        verde = valor;
    }
    
    public void copy(Color color){
    rojo = color.getRojo();
    azul = color.getAzul();
    verde = color.getVerde();
    }
    
    public int getRojo(){
        return rojo;
    }
    
    public int getAzul(){
        return azul;
    }
    
    public int getVerde(){
        return verde;
    }
    
    public Color Complemento(){
        int r, a, v;
        r = 255 - rojo;
        a = 255 - azul;
        v = 255 - verde;
        return new Color(r, a, v);
    }
    
    public boolean equals(Color color){
        return rojo == color.getRojo() && azul == color.getAzul() && verde == color.getVerde();
    }
    
    public Color clone(){
        return new Color(rojo, azul, verde);
    }
    
}