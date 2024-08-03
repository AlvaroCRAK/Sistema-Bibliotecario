import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class Biblioteca implements Persistible {
  String nombre = "Biblioteca unica";
  List<Libro> libros = new ArrayList<>();
  List<Usuario> usuarios = new ArrayList<>();
  List<Prestamo> prestamos = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  void addLibro(Libro libro){
    libros.add(libro);
  }
  void addUsuario(Usuario usuario){
    usuarios.add(usuario);
  }
  void addPrestamo(Prestamo prestamo){
    prestamos.add(prestamo);
  }

  private void menuOpciones(){
    while ( true ) {
      System.out.println("------ Biblioteca ------");
      System.out.println("1. Agregar Libro");
      System.out.println("2. Agregar Usuario");
      System.out.println("3. Realizar Prestamo");
      System.out.println("4. Mostrar informacion");
      System.out.println("5. Salir");
      System.out.println("Ingrese una opcion: ");
      char opc = scanner.nextLine().charAt(0);

      switch ( opc ) {
        case '1': addLibro(); break;
        case '2': addUsuario(); break;
        case '3': addPrestamo(); break;
        case '4': mostrarInformacion(); break;
        case '5': System.out.println("Saliendo"); return;
        default: System.out.println("Opcion no valida, intente de nuevo");
      }
    }
  }
  @Override
  public void guardar(){
    System.out.println("Guardado realizado con exito");
  }
  @Override
  public void cargar(){
    System.out.println("Carga realizado con exito");
  }
  @Override
  public void mostrarInformacion(){
    cargar();
    System.out.println("------ Libros -------");
    for ( Libro libro : libros ){
      libro.mostrarInformacion();
    }
    System.out.println();

    System.out.println("------ Usuarios -----");
    for ( Usuario usuario : usuarios ){
      usuario.mostrarInformacion();
    }
    System.out.println();

    System.out.println("----- Prestamos ------");
    for ( Prestamo prestamo : prestamos ){
      prestamo.mostrarInformacion();
    }
    System.out.println();
  } 
  void addLibro(){
    cargar();
    System.out.print("Ingrese el titulo del libro: ");
    String titulo = scanner.nextLine();
    System.out.print("Ingrese el autor del libro " + titulo + ": ");
    String autor = scanner.nextLine();
    System.out.print("Ingrese la fecha de publicacion del libro " + titulo + ": ");
    String fecha = scanner.nextLine();

    Libro libro = new Libro()
                      .setTitulo(titulo)
                      .setAutor(autor)
                      .setFecha(fecha);
    addLibro(libro);
    guardar();
  }
  void addUsuario(){
    cargar();
    System.out.print("Ingrese el nombre completo del usuario: " );
    String nombre = scanner.nextLine();
    System.out.print("Ingrese la edad del usuario " + nombre + ": ");
    int age = scanner.nextInt();
    scanner.nextLine();
    int id;
    if ( usuarios.isEmpty() )
      id = 1;
    else 
      id = usuarios.size() + 1;
    
    Usuario usuario = new Usuario()
                          .setNombre(nombre)
                          .setId(id)
                          .setAge(age);
    addUsuario(usuario);
    guardar();
  }
  void addPrestamo(){
    cargar();
    System.out.print("Ingrese el titulo del libro: ");
    String titulo = scanner.nextLine();

    Libro libro = new Libro();

    boolean temp = true;
    for ( int i = 0; i < libros.size(); i++ ){
      if ( libros.get(i).getTitulo().equalsIgnoreCase(titulo) ){
        temp = false;
        libro = libros.get(i);
        break;
      }
    }
    if ( temp ){
      System.out.println("Libro no encontrado");
      return;
    }

    System.out.print("Ingrese el nombre del usuario: ");
    String nombre = scanner.nextLine();
    Usuario usuario = new Usuario();
    temp = true;
    for ( int i = 0; i < usuarios.size(); i++ ){
      if ( usuarios.get(i).getNombre().equalsIgnoreCase(nombre) ){
        temp = false;
        usuario = usuarios.get(i);
        break;
      }
    }
    if ( temp ){
      System.out.println("Usuario no encontrado");
      return;
    }
    
    System.out.print("Ingrese la fecha del prestamo: " );
    String fecha = scanner.nextLine();

    Prestamo prestamo = new Prestamo()
                            .addLibro(libro)
                            .addUsuario(usuario)
                            .addFecha(fecha);
    addPrestamo(prestamo);
    guardar();
  }
  String getNombre(){
    return nombre;
  }
  List getLibros(){
    return libros;
  }
  List getUsuarios(){
    return usuarios;
  }
  List getPrestamos(){
    return prestamos;
  }
  public static void main(String[] args){
    Biblioteca biblioteca = new Biblioteca();
    biblioteca.menuOpciones();
    System.exit(0);
  }
}
