package com.example.practica10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.Stack;

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

    String[][] tableData;
    JPanel panel;
    Stack<Cliente> clientStack;
    JTextField turnField;
    JTextField clientTextField;
    JComboBox<String> movimientosDropwdown;
    DefaultTableModel tableModel;

    public Practica10(JPanel panel) {
        this.panel = panel;
        this.customerData();
        this.createButtons();
        this.createTable();
        // this.createDummyData();
    }

    public void customerData() {
        this.turnField = new JTextField();
        this.clientTextField = new JTextField();

        String[] movimientos = {
                "Pago de servicio",
                "Deposito",
                "Retiro",
                "Compra de tiempo aire",
                "Consulta de saldo"
        };

        this.movimientosDropwdown = new JComboBox<>(movimientos);

        this.movimientosDropwdown.addActionListener(e -> {
            Object selection = this.movimientosDropwdown.getSelectedItem();
            System.out.println("selected" + selection);
        });

        JPanel subPanel = new JPanel();

        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.setBorder(BorderFactory.createTitledBorder("Datos del cliente"));
        subPanel.add(turnField);
        subPanel.add(clientTextField);
        subPanel.add(this.movimientosDropwdown);

        this.panel.add(subPanel);
    }

    public void createButtons() {

        JButton addToQue = new JButton("Agregar a la cola");
        addToQue.addActionListener(arg0 -> {
            Cliente client = new Cliente(
                    Integer.parseInt(this.turnField.getText()),
                    this.clientTextField.getText(),
                    this.movimientosDropwdown.getSelectedItem().toString());

            this.tableModel.addRow(new Object[] { client.getNombre(), client.getHoraLlegada(), client.getTurno(),
                    client.getMovimiento() });
            
            this.clientTextField.setText("");
            this.turnField.setText( String.valueOf(this.tableModel.getRowCount() + 1));

        });

        JButton serveWindow = new JButton("Atender en ventanilla");

        serveWindow.addActionListener(arg1 -> {
            if (this.tableModel.getRowCount() > 0) {
                JOptionPane.showMessageDialog(
                    addToQue, 
                    this.tableModel.getValueAt(0, 0), 
                    "Message title", 
                    JOptionPane.OK_OPTION
                );
                this.tableModel.removeRow(0);
            }
        });

        JButton exit = new JButton("Salida del sistema");

        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));

        subPanel.add(addToQue);
        subPanel.add(serveWindow);
        subPanel.add(exit);

        this.panel.add(subPanel);
    }

    private void addRowToTable(String[][] tableData, Cliente client) {
        String[] row = { String.valueOf(client.getTurno()), client.getNombre(), client.getMovimiento(), "null" };
        if (tableData == null) {
            String[][] newTableData = new String[1][4];
            this.tableData = newTableData;
            newTableData[newTableData.length - 1] = row;
            System.out.println("table data initialized");
        } else {
            String[][] newTableData = new String[tableData.length + 1][tableData[0].length];
            System.arraycopy(tableData, 0, newTableData, 0, tableData.length);
            newTableData[newTableData.length - 1] = row;
            this.tableData = newTableData;
            // return newTableData;
        }
    }

    public void createTable() {
        JTable table = new JTable(
                new DefaultTableModel(new Object[] { "turno", "nombre", "movimiento", "llegada" }, 0));

        this.tableModel = (DefaultTableModel) table.getModel();

        JScrollPane scrollPane = new JScrollPane(table);
        this.panel.add(scrollPane);
    }
}
