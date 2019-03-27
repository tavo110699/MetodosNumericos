/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodoBiseccion;

/**
 *
 * @author gustavo
 */
public class Biseccion {
    
    public double limIzq;
    public double limDer;
    public double error;
    private double f(double x) {
        double fx;
        //Aqui coloca la funcion
        //metodo para calcular F(x)

        fx = (Math.pow(x, 10) - 1);

        return fx;
    }

    public void biseccion(double limIzq, double limDer, double error) {
        double xI = limIzq;
        double xD = limDer;
        double eMax = error;
        double fxI = f(xI);
        double fxD = f(xD);
        double xM = xMedia(xI, xD);
        double fxM = f(xM);
        double Er = 0;
        double xManterior = 0;
        int contador = 1;

        //Verifica si existe raiz entre xi y xd
        if ((fxI > 0 && fxD > 0) || ((fxI < 0 && fxD < 0))) {
            System.out.println("Sin raíces en este intervalo");
            return;
        }

        System.out.println("Glosaro:\n Iteracion = i#\n X izquierda = Xa \n X derecha =Xb \n X media = Xr"
                + "\n F(x) izquierda = Fa \n F(x) derecha = Fb \n F(x) media = Fxr");

        System.out.println(" \ni# \t Xa \t Xb \t Xr \t Fa \t Fb \t Fxr \t Ea");

        while (Math.abs(fxM) >= eMax) {
            // %.3f = a la delimitacion de ddecimales despues de el punto
            // \t = espacio de tabulador
            // \n = salto de linea

            System.out.print(contador);
            System.out.print("\t");
            System.out.printf("%.3f", xD);
            System.out.print("\t");
            System.out.printf("%.3f", xI);
            System.out.print("\t");
            System.out.printf("%.3f", xM);
            System.out.print("\t");
            System.out.printf("%.3f", fxI);
            System.out.print("\t");
            System.out.printf("%.3f", fxD);
            System.out.print("\t");
            System.out.printf("%.3f", fxM);
            System.out.print("\t");
            System.out.printf("%.3f", Er);
            System.out.print("% \n");

            //Pasa el valor de FxM a xI o xD
            if (fxM * fxI > 0) {
                xI = xM;
            } else {
                xD = xM;
            }
            //llamada a los metodos
            fxI = f(xI);
            fxD = f(xD);

            xManterior = xM;
            xM = xMedia(xI, xD);
            fxM = f(xM);

            contador++;
            if (contador >= 2) {
                Er = (xM - xManterior) / xM;
                Er = Er * 100;
                if (Er < 0) {
                    Er = Er * -1;
                }
            }

        }

        System.out.print(contador);
        System.out.print("\t");
        System.out.printf("%.3f", xD);
        System.out.print("\t");
        System.out.printf("%.3f", xI);
        System.out.print("\t");
        System.out.printf("%.3f", xM);
        System.out.print("\t");
        System.out.printf("%.3f", fxI);
        System.out.print("\t");
        System.out.printf("%.3f", fxD);
        System.out.print("\t");
        System.out.printf("%.3f", fxM);
        System.out.print("\t");
        System.out.printf("%.3f", Er);
        System.out.print("% \n");
    }

    private double xMedia(double x1, double x2) {
        //metodo para calcular xM (en biseccion) o  el promedio de ellos dos
        return ((x1 + x2) / 2);
    }
}
