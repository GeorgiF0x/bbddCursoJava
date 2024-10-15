package curso.bbdd.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import curso.bbdd.daos.AlumnoDAO;
import curso.bbdd.models.Alumn;

public class ControlAlumno {

    // Constructor para inicializar y propagar excepciones
    public ControlAlumno() throws SQLException {
        Alumn alumn1 = new Alumn(0, "Mondongo", "Merequetengue", "666666666");
        AlumnoDAO.insert(alumn1); // Llamada correcta al método insert
    }

    public static File GuardarAlumnos() throws SQLException, IOException {
        ArrayList<Alumn> listaAlumnos = AlumnoDAO.getAll();
        String ruta = "C:\\Users\\gborisov\\Desktop\\Temario\\Sesion 7 (1)\\Sesion 7\\listaAlumnos.dat";
        File fichero = new File(ruta);
        
        if (!fichero.exists()) {
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado.");
            } else {
                System.out.println("No se pudo crear el fichero.");
            }
        } else {
            System.out.println("El fichero ya existe");
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            for (Alumn alumn : listaAlumnos) {
                bw.write(alumn.toString());
                bw.newLine();
            }
        }
        
        return fichero;
    }

    public static void imprimirInfoFichero(File fichero) throws IOException {
        // Usar try-with-resources para asegurar que el BufferedReader se cierre correctamente
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            // Leer cada línea del archivo
            while ((linea = br.readLine()) != null) {
                System.out.println(linea); // Imprimir la línea en la consola
            }
        }
    }
}

