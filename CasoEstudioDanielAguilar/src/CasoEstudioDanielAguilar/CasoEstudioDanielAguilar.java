/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CasoEstudioDanielAguilar;

import javax.swing.JOptionPane;

/**
 *
 * @author dagui
 */
public class CasoEstudioDanielAguilar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
// TODO code application logic here
        
 // Primero le pedimos aal usuario los datos requeridos para rellenar las variables
            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            String cedulaCliente = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
        
            int totalFacturas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantiad de facturas del cliente:"));
            double totalDeuda = 0.0;
            int añoFactura = 0;
            
// Este loop se repite segun la cantidad de facturas ingresadas y determinara la couta
            for (int i = 1; i <= totalFacturas; i++) {
            String numeroFactura = JOptionPane.showInputDialog("Ingrese el número de factura " + i + ":");
            double montoFactura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto de la factura " + i + ":"));
            String mesFactura = JOptionPane.showInputDialog("Ingrese el mes de la factura " + i + ":") ; //Utilizar el nombre del mes de la factura
            añoFactura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de la factura " + i + ":"));
            int estadoFactura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estado de la factura (1: Pagada, 2: No pagada) " + i + ":"));
            
            if (estadoFactura == 2) {
            totalDeuda += montoFactura;
            }
        }

// Aca determinamos variables para los intereses y fechas de pago 
            int plazoCobro = 6;
            double interes = 0.05;
            double cuotaMensual = ((totalDeuda * interes) + totalDeuda) / plazoCobro;
        
            int mesActual = 7; // Julio
        
            JOptionPane.showMessageDialog(null, "Resumen de la deuda del cliente " + nombreCliente + " (Cédula: " + cedulaCliente + "):" +
            "\nTotal deuda: " + totalDeuda +
            "\nCuota mensual: " + cuotaMensual +
            "\nPlan de cobro fraccionado:");
        
            for (int cuota = 1; cuota <= plazoCobro; cuota++) {
            String fechaPago = obtenerFechaPago(mesActual, cuota, añoFactura);
            JOptionPane.showMessageDialog(null, "Cuota " + cuota + " " + cuotaMensual + " Fecha de pago " + fechaPago);
        }
    }
    
// Función y clase para obtener la fecha de pago
    public static String obtenerFechaPago(int mesActual, int cuota, int añoFactura) {
            int mesPago = mesActual + cuota - 1;
            int añoPago = añoFactura;
            
            if (mesPago > 12) {
            mesPago -= 12;
            añoPago++;
        }
        
            String mesPagoStr = obtenerNombreMes(mesPago);
            return mesPagoStr + " " + añoPago;
    }
    
 // Función y clsae para obtener el nombre del mes
    public static String obtenerNombreMes(int numeroMes) {
            String[] meses = {
            "Enero", "Febero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Novembre", "Diciembre"
        };
        
            if (numeroMes >= 1 && numeroMes <= 12) {
            return meses[numeroMes - 1];
        }   else {
            return "Mes inválido";
        }
    }
}

    
    

