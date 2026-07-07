/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliotecaparcial; 

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;

public class BibliotecaParcial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Socio> socios = cargarSocios();
        ArrayList<Libro> libros = cargarLibros();
        ArrayList<Prestamo> prestamos = cargarPrestamos();

        int opcion = -1;

        do {
            System.out.println("\n=== BIBLIOTECA UTN AVELLANEDA ===");
            System.out.println("1. Registrar socio");
            System.out.println("2. Registrar libro");
            System.out.println("3. Listar socios");
            System.out.println("4. Listar libros disponibles");
            System.out.println("5. Buscar libro");
            System.out.println("6. Registrar préstamo");
            System.out.println("7. Registrar devolución");
            System.out.println("8. Mostrar préstamos activos");
            System.out.println("9. Generar informe");
            System.out.println("0. Guardar y salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese nombre: ");
                        String nombreSocio = sc.nextLine();

                        System.out.println("Ingrese DNI: ");
                        String dniSocio = sc.nextLine();

                        System.out.println("Ingrese numero de socio: ");
                        int numeroSocio = Integer.parseInt(sc.nextLine());

                        Socio nuevoSocio = new Socio(0, numeroSocio, nombreSocio, dniSocio);

                        boolean existeDni = false;
                        for (Socio s : socios) {
                            if (s.getDni().equals(dniSocio)) {
                                existeDni = true;
                                break;
                            }
                        }

                        if (existeDni) {
                            System.out.println("Ya existe un socio con ese DNI.");
                        } else {
                            socios.add(nuevoSocio);
                            System.out.println("Socio registrado con éxito.");
                        }
                        break;

                    case 2:
                        System.out.println("Ingrese titulo del libro: ");
                        String tituloLibro = sc.nextLine();

                        System.out.println("Ingrese nombre del autor: ");
                        String nombreAutor = sc.nextLine();

                        System.out.println("Ingrese el anio de lanzamiento: ");
                        int anioLanzamiento = Integer.parseInt(sc.nextLine());

                        System.out.println("ID del libro: ");
                        int idLibro = Integer.parseInt(sc.nextLine());

                        System.out.println("Está disponible? (s/n): ");
                        String respuesta = sc.nextLine();
                        boolean estaDisponible = respuesta.equalsIgnoreCase("s");

                        Libro nuevoLibro = new Libro(tituloLibro, nombreAutor, anioLanzamiento, estaDisponible, idLibro);
                        libros.add(nuevoLibro);

                        System.out.println("Libro registrado con éxito");
                        break;

                    case 3:
                        System.out.println("===== SOCIOS REGISTRADOS ====");
                        for (Socio s : socios) {
                            System.out.println(s);
                        }
                        break;

                    case 4:
                        System.out.println("=== LIBROS DISPONIBLES ===");
                        for (Libro l : libros) {
                            if (l.isDisponible()) {
                                System.out.println(l);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Ingrese el titulo del libro a buscar: ");
                        String tituloBuscado = sc.nextLine();

                        Libro libroEncontrado = null;
                        for (Libro l : libros) {
                            if (l.getTitulo().equals(tituloBuscado)) {
                                libroEncontrado = l;
                                break;
                            }
                        }

                        if (libroEncontrado != null) {
                            System.out.println("Libro encontrado: " + libroEncontrado);
                        } else {
                            System.out.println("No se encontró ningún libro con ese título");
                        }
                        break;

                    case 6:
                        System.out.println("Ingrese DNI: ");
                        String dniBuscado = sc.nextLine();

                        System.out.println("ID del libro: ");
                        int idBuscado = Integer.parseInt(sc.nextLine());

                        Socio socioEncontrado = null;
                        for (Socio s : socios) {
                            if (s.getDni().equals(dniBuscado)) {
                                socioEncontrado = s;
                                break;
                            }
                        }

                        Libro libroEncontrar = null;
                        for (Libro l : libros) {
                            if (l.getIdMaterial() == idBuscado) {
                                libroEncontrar = l;
                                break;
                            }
                        }

                        if (socioEncontrado != null && libroEncontrar != null && libroEncontrar.isDisponible()) {
                            Prestamo nuevoPrestamo = new Prestamo(socioEncontrado, libroEncontrar);
                            prestamos.add(nuevoPrestamo);
                            libroEncontrar.setDisponible(false);
                            socioEncontrado.setCantidadPrestamosActivos(socioEncontrado.getCantidadPrestamosActivos() + 1);
                            System.out.println("Préstamo registrado con éxito");
                        } else {
                            System.out.println("No se pudo registrar el préstamo");
                        }
                        break;

                    case 7:
                        System.out.println("ID del libro a devolver: ");
                        int idDevolucion = Integer.parseInt(sc.nextLine());

                        Prestamo prestamoEncontrado = null;
                        for (Prestamo p : prestamos) {
                            if (p.getLibro().getIdMaterial() == idDevolucion && !p.isDevuelto()) {
                                prestamoEncontrado = p;
                                break;
                            }
                        }

                        if (prestamoEncontrado != null) {
                            prestamoEncontrado.marcarDevuelto();
                            Socio socioDelPrestamo = prestamoEncontrado.getSocio();
                            socioDelPrestamo.setCantidadPrestamosActivos(socioDelPrestamo.getCantidadPrestamosActivos() - 1);
                            System.out.println("Devolución registrada con éxito.");
                        } else {
                            System.out.println("No se pudo encontrar un préstamo activo con ese ID");
                        }
                        break;

                    case 8:
                        System.out.println("=== PRÉSTAMOS ACTIVOS ===");
                        for (Prestamo p : prestamos) {
                            if (!p.isDevuelto()) {
                                System.out.println(p);
                            }
                        }
                        break;

                    case 9:
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("informe.txt"))) {
                            bw.write("=== INFORME BIBLIOTECA UTN AVELLANEDA ===");
                            bw.newLine();
                            bw.write("Fecha de generación: " + LocalDateTime.now());
                            bw.newLine();
                            bw.write("Cantidad de socios registrados: " + socios.size());
                            bw.newLine();
                            bw.write("Cantidad de libros registrados: " + libros.size());
                            bw.newLine();

                            int librosDisponibles = 0;
                            for (Libro l : libros) {
                                if (l.isDisponible()) {
                                    librosDisponibles++;
                                }
                            }
                            bw.write("Cantidad de libros disponibles: " + librosDisponibles);
                            bw.newLine();

                            int prestamosActivos = 0;
                            for (Prestamo p : prestamos) {
                                if (!p.isDevuelto()) {
                                    prestamosActivos++;
                                }
                            }
                            bw.write("Cantidad de préstamos activos: " + prestamosActivos);
                            bw.newLine();

                            Libro libroMasPrestado = null;
                            int maxVeces = 0;
                            for (Libro l : libros) {
                                int veces = 0;
                                for (Prestamo p : prestamos) {
                                    if (p.getLibro().getIdMaterial() == l.getIdMaterial()) {
                                        veces++;
                                    }
                                }
                                if (veces > maxVeces) {
                                    maxVeces = veces;
                                    libroMasPrestado = l;
                                }
                            }

                            if (libroMasPrestado != null) {
                                bw.write("Libro más solicitado: " + libroMasPrestado.getTitulo() + " (" + maxVeces + " préstamos)");
                            } else {
                                bw.write("Libro más solicitado: sin datos de préstamos aún");
                            }
                            bw.newLine();

                            System.out.println("Informe generado con éxito en informe.txt");

                        } catch (IOException e) {
                            System.out.println("Error al generar informe: " + e.getMessage());
                        }
                        break;

                    case 0:
                        guardarSocios(socios);
                        guardarLibros(libros);
                        guardarPrestamos(prestamos);
                        System.out.println("Datos guardados. Cerrando el sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida, intente de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
                opcion = -1;
            }

        } while (opcion != 0);

        sc.close();
    }

   

    public static void guardarSocios(ArrayList<Socio> socios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("socios.dat"))) {
            oos.writeObject(socios);
        } catch (IOException e) {
            System.out.println("Error al guardar socios: " + e.getMessage());
        }
    }

    public static void guardarLibros(ArrayList<Libro> libros) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("libros.dat"))) {
            oos.writeObject(libros);
        } catch (IOException e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
        }
    }

    public static void guardarPrestamos(ArrayList<Prestamo> prestamos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("prestamos.dat"))) {
            oos.writeObject(prestamos);
        } catch (IOException e) {
            System.out.println("Error al guardar préstamos: " + e.getMessage());
        }
    }

  

    @SuppressWarnings("unchecked")
    public static ArrayList<Socio> cargarSocios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("socios.dat"))) {
            return (ArrayList<Socio>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se encontraron socios previos, se inicia vacío.");
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Libro> cargarLibros() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("libros.dat"))) {
            return (ArrayList<Libro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se encontraron libros previos, se inicia vacío.");
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Prestamo> cargarPrestamos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("prestamos.dat"))) {
            return (ArrayList<Prestamo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se encontraron préstamos previos, se inicia vacío.");
            return new ArrayList<>();
        }
    }
}