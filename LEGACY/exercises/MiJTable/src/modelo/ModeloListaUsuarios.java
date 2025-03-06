/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amezc
 */
public class ModeloListaUsuarios extends AbstractTableModel {

    private ArrayList<Usuario> listaUsuarios;
    private final String[] nombresColumnas = {"Nombre", "Apellido", "Edad"};

    public ModeloListaUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    public void añadirUsuario(Usuario u) {
        this.listaUsuarios.add(u);
    }

    @Override
    public String getColumnName(int index) {
        return this.nombresColumnas[index];
    }

    @Override
    public int getRowCount() {
        return this.listaUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Usuario c = listaUsuarios.get(row);
        Object value = null;
        switch (column) {
            case 0 ->
                value = c.getNombre();
            case 1 ->
                value = c.getApellido();
            case 2 ->
                value = c.getEdad();
        }
        return value;
    }

}
