package curso.bbdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import curso.bbdd.controllers.ControlAlumno;
import curso.bbdd.daos.AlumnoDAO;
import curso.bbdd.models.Alumn;

public class App {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		//creamos el fichero 
		File fichero=ControlAlumno.GuardarAlumnos();
		ControlAlumno.imprimirInfoFichero(fichero);
		ControlAlumno pepe= new ControlAlumno();
		//leer e imprimir el fichero
		
	    }
	
	
	
    }
	


