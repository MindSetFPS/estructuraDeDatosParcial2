package com.example.practica10;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// import com.example.LinkedList;
import com.example.Stack;
import java.time.LocalDateTime;
import java.util.Queue;
import java.time.Duration;
import java.util.LinkedList;
import java.time.format.DateTimeFormatter;


public class Practica10 {
    String[][] clientTableData;
    JPanel panel;
    // Stack<Cliente> clientStack;
    Queue<Cliente> clientQueue;
    JTextField turnField;
    JTextField clientTextField;
    JComboBox<String> movimientosDropwdown;
    DefaultTableModel clientTableModel;

    public Practica10(JPanel panel) {
        this.panel = panel;
        // this.clientStack = new Stack<>();
        this.clientQueue = new LinkedList<>();

        this.customerData();
        this.createButtons();
        this.createTable();
    }

    public void customerData() {
        this.turnField = new JTextField("0");
        this.clientTextField = new JTextField();
        String[] movimientos = {"Pago de servicio","Deposito","Retiro","Compra de tiempo aire","Consulta de saldo"};
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
            Cliente client = new Cliente(Integer.parseInt(this.turnField.getText()), this.clientTextField.getText(),this.movimientosDropwdown.getSelectedItem().toString());
            this.clientTableModel.addRow(new Object[] { client.getTurno(), client.getNombre(), client.getMovimiento(),client.getHoraLlegada()});
            // clientStack.push(client);
            clientQueue.add(client);
            this.clientTextField.setText("");
            this.turnField.setText(String.valueOf(this.clientTableModel.getRowCount()));
        });
        JButton serveWindow = new JButton("Atender en ventanilla");
        serveWindow.addActionListener(arg1 -> {
            if (this.clientTableModel.getRowCount() > 0) {
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime horaSalida = LocalDateTime.now();
                LocalDateTime horaLlegada = LocalDateTime.parse(this.clientTableModel.getValueAt(0, 3).toString());
                horaSalida.format(formatoHora);
                Duration diference = Duration.between(horaLlegada, horaSalida);
                String durationString = diference.toString().replace("PT", " ").replace("H", " horas, ").replace("M", " minutos, ").replace("S", " segundos.");
                JOptionPane.showMessageDialog(
                        addToQue,
                        durationString,
                        "Usuario atendido.",
                        JOptionPane.OK_OPTION);
                this.clientTableModel.removeRow(0);
                // clientStack.pop();
                clientQueue.poll();
                for (Cliente cliente : clientQueue) {
                    System.out.println(cliente.toString());
                }
                // System.out.println(clientStack.printNodes());
            }
        });

        JButton exit = new JButton("Salida del sistema");
        exit.addActionListener(arg1 -> {
            System.exit(0);
        });
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
        subPanel.add(addToQue);
        subPanel.add(serveWindow);
        subPanel.add(exit);
        this.panel.add(subPanel);
    }

    public void createTable() {
        JTable table = new JTable(new DefaultTableModel(new Object[] { "turno", "nombre", "movimiento", "llegada" }, 0));
        this.clientTableModel = (DefaultTableModel) table.getModel();
        JScrollPane scrollPane = new JScrollPane(table);
        this.panel.add(scrollPane);
    }
}
