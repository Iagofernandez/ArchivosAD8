
package textodelimitado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Textodelimitado {

  
    public static void main(String[] args) throws IOException {
        //Esto crea los objectos que se guaradn en el array
        String[] codigo = {"p1", "p2", "p3"};
        String[] descricion = {"parafusos", "cravos", "tachas"};
        Double[] prezo = {3d, 4d, 5d};

        //escritura
        FileWriter fichero = new FileWriter("/home/oracle/Desktop/Eje8/productos.txt");
        BufferedWriter ficheroBuffer = new BufferedWriter(fichero);
        PrintWriter ficheroPrint = new PrintWriter(ficheroBuffer);

        for (int i = 0; i < prezo.length; i++) {
            //Esto permite tabular al final de codigo y de descricion
            //a fin d eque aparezcan escritos en dversas columnas
            ficheroPrint.println(codigo[i] + "\t" + descricion[i] + "\t" + prezo[i]);

        }
//cerrar ficheros
        ficheroPrint.close();
        ficheroBuffer.close();
        fichero.close();

        
        //lectura
        FileReader fichero1 = new FileReader("/home/oracle/Desktop/Eje8/productos.txt");
        BufferedReader ficheroBuffer1 = new BufferedReader(fichero1);

        //aqui se originan los arrays de productos
        String[] arrayProd;
        Product productos = new Product();
        //esta parte permite eal programa saber cuando una linea ha finalizado
        String linea;
       
        while ((linea = ficheroBuffer1.readLine()) != null) {
            //Se indica la separacionsera un tabulador
            arrayProd = linea.split("\t");

            productos.setCodigo(arrayProd[0]);
            productos.setDescripcion(arrayProd[1]);
            productos.setPrecio(Double.parseDouble(arrayProd[2]));

            System.out.println(productos.toString());

        }

        fichero.close();
        ficheroBuffer.close();
        ficheroPrint.close();

    }

}

class Product {

    private String codigo;
    private String descripcion;
    private Double precio;

    public Product() {

        codigo = "";
        descripcion = "";
        precio = 0d;

    }

    public Product(String codigo, String descripcion, Double precio) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Product{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

}
