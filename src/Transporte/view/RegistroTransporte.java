package Transporte.view;

import java.util.Scanner;

import General.InputTypesUniversidad;
import Transporte.entity.Transporte;

public class RegistroTransporte {
	public static Transporte ingresarVehiculo(Scanner scanner)
	{
		int CodigoVehiculo=InputTypesUniversidad.readInt("Ingrese su codigo de vehiculo:", scanner);
		int CodigoEstudiante=InputTypesUniversidad.readInt("Ingrese su codigo de Estudiante:", scanner);
		String Placa=InputTypesUniversidad.readString("Placa:", scanner);
		String Marca=InputTypesUniversidad.readString("Marca: ", scanner);
		String Color=InputTypesUniversidad.readString("Color del vehiculo:", scanner);
        boolean Soat=InputTypesUniversidad.readBoolean("Soat  true(si)/false(no)", scanner);

		return new Transporte(CodigoVehiculo,CodigoEstudiante, Placa,Marca, Color, Soat);
	}

}
