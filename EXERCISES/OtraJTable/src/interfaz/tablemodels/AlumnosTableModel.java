/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.tablemodels;

import beans.Alumno;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amezc
 */
public class AlumnosTableModel extends AbstractTableModel {

    private ArrayList<Alumno> listAlumno;
    private String[] columnas = {"Nombre", "Curso"};

    public AlumnosTableModel(ArrayList<Alumno> listAlumno) {
        this.listAlumno = listAlumno;
    }

    @Override
    public int getRowCount() {
        return this.listAlumno.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return listAlumno.get(rowIndex).getNombre();
            }
            case 1 -> {
                return listAlumno.get(rowIndex).getCurso();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
