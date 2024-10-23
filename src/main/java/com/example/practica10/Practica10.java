package com.example.practica10;

import javax.swing.*;
import java.awt.*;

// Desarrolle un programa que administre una Cola de una ventanilla de un banco que tenga la siguiente forma:  

// Requerimientos generales:  

// • El programa debe almacenar los siguientes datos de cada cliente: 
// o Número de turno (entero)
// o Nombre del cliente (string) 
// o Tipo de movimiento que desea realizar (string) 
// o Hora de llegada del cliente (DateTime)  

// • Cuando llegue un cliente al banco, debe formarse al final de la cola y se almacenan los datos antes mencionados.  
//
// • Seleccione el tipo de movimiento de un comboBox: 

// Al oprimir el botón “Atender en ventanilla”, se elimina el primer cliente de la cola y se debe  calcular el tiempo en espera de ser atendido. 

// • Inserción de clientes en la Cola (InsertaCola): 
// o Validar que no exista sobreflujo; es decir, que no esté llena la estructura cuando se intente insertar un nuevo dato. Utilice el método ColaLlena() que devuelve el valor true si la cola está llena y false en caso contrario. 
// o Cuando inserte un cliente en la cola, actualice el dataGridView1 y muestre una ventana como la sig:

// Eliminación de datos (bajas): 

// o Validar que la estructura no esté vacía antes de solicitar el dato que se desea eliminar. 
// Utilice el método ColaVacia() que devuelve el valor true si la cola está vacía y false en caso contrario. 
// o Cuando se atiende un cliente en ventanilla (EliminaCola( )), obtenga la hora del sistema para calcular el tiempo de espera en la cola de acuerdo a su hora de llegada. 

// Mostrar la estructura: 
// o Después de cada operación, actualice el dataGridView1 
// o Muestre el valor de frente y final.

public class Practica10 {

    JPanel panel;

    public Practica10(JPanel panel) {
        this.panel = panel;
        this.customerData();
        this.createButtons();
        this.createTable();
    }

    public void customerData() {
        JTextField turnField = new JTextField();
        JTextField clinTextField = new JTextField();

        String[] colors = {
                "Pago de servicio",
                "Deposito",
                "Retiro",
                "Compra de tiempo aire",
                "Consulta de saldo"
        };

        JComboBox<String> colorBox = new JComboBox<>(colors);

        colorBox.addActionListener(e -> {
            Object selection = colorBox.getSelectedItem();
            System.out.println("selected" + selection);
        });

        JPanel subPanel = new JPanel();

        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(BorderFactory.createTitledBorder("Datos del cliente"));
        subPanel.add(turnField);
        subPanel.add(clinTextField);
        subPanel.add(colorBox);

        this.panel.add(subPanel);
    }

    public void createButtons() {

        JButton addToQue = new JButton("Agregar a la cola");
        JButton serveWindow = new JButton("Atender en ventanilla");
        JButton exit = new JButton("Salida del sistema");

        JPanel subPanel = new JPanel();

        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));

        subPanel.add(addToQue);
        subPanel.add(serveWindow);
        subPanel.add(exit);

        this.panel.add(subPanel);
    }

    public void createTable() {

        Object[][] data = {
                { 
                    "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) 
                },
                { 
                    "John", "Doe", "Rowing", new Integer(3), new Boolean(true)
                },
                { 
                    "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) 
                },
                { 
                    "Jane", "White","Speed reading", new Integer(20), new Boolean(true) 
                },
                { 
                    "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) 
                }
        };

        String[] columnNames = {
                "turno",
                "nombre",
                "movimiento",
                "llegada",
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        this.panel.add(scrollPane);
    }
}
