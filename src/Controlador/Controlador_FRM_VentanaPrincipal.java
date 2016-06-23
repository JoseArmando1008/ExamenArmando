
package Controlador;

import Modelo.MetodosNodos;
import Vista.FRM_VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador_FRM_VentanaPrincipal implements ActionListener{
    FRM_VentanaPrincipal ventana;
    MetodosNodos metodos;
    int prioridad=1;
    int reporte=1;

    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal ventana) {
        this.ventana = ventana;
        metodos=new MetodosNodos();
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Agregar")){
            
          prioridad=Integer.parseInt( JOptionPane.showInputDialog("Digite la prioridad de la persona"+"\n\n"+"1) 7600\n2)Normal"));
            if(prioridad==1){
            this.metodos.crear(this.ventana.devolverNumeroCedula(),this.ventana.devolverNombre(),this.ventana.devolverEdad(),this.ventana.devolverFechaCita());
            this.ventana.imprimirAgregar(this.metodos.imprimir());
            this.ventana.limpiarInterfaz();
            JOptionPane.showMessageDialog(null,"Se agregó correctamente");
            }
            if(prioridad==2){
            this.metodos.agregarAlFinal(this.ventana.devolverNumeroCedula(), this.ventana.devolverNombre(), this.ventana.devolverEdad(), this.ventana.devolverFechaCita(), null);
            this.ventana.imprimirAgregar(this.metodos.imprimir());
            this.ventana.limpiarInterfaz();
            JOptionPane.showMessageDialog(null,"Se agregó correctamente");
                
            }
           
            
        }
        if(e.getActionCommand().equals("Llamar Cliente")){
            System.out.println("Llamar Cliente");
        this.ventana.imprimirEnLlamarCliente(this.metodos.imprimirCliente());
        this.metodos.eliminarPrimero();
        this.ventana.imprimirAgregar(this.metodos.imprimir());
        }
        if(e.getActionCommand().equals(">"))
        {
             System.out.println("Mayor");
            metodos.ordenarMayorAMenor();
            ventana.imprimirAgregar(this.metodos.imprimir());
           // this.ventana.imprimirEnLlamarCliente(this.metodos.imprimirCliente());
            
        }
        if(e.getActionCommand().equals("<"))
        {
             System.out.println("Menor");
            //metodos.ordenarMenorAMayor();
            //ventana.imprimirAgregar(this.metodos.imprimir());
           // this.ventana.imprimirEnLlamarCliente(this.metodos.imprimirCliente());          
            
        }
         if(e.getActionCommand().equals("Modificar"))
        {
            metodos.modificar(this.ventana.devolverNumeroCedula(), this.ventana.devolverNombre(), this.ventana.devolverEdad(), this.ventana.devolverFechaCita());
            
        }
        
        if(e.getActionCommand().equals("Reporte"))
        {
            reporte=Integer.parseInt(JOptionPane.showInputDialog("Digite el tipo de reporte que desea\n\n1.Cantidad de personas agregadas\n2.Información de las personas\3.Promedio de edades"));
            if(reporte==1){
                ventana.imprimirAgregar(this.metodos.devolverCantidadNodos());
            }
            if(reporte==2){
                
            }
            if(reporte==3){
                
            }
            
        }
        
        if(e.getActionCommand().equals("Cancelar"))
        {
            
            
            metodos.eliminar(this.ventana.devolverNumeroCedula());
            this.ventana.imprimirAgregar(this.metodos.imprimir());
            this.ventana.limpiarInterfaz();
            JOptionPane.showMessageDialog(null,"Se eliminó correctamente");
        }
    }
    
}
