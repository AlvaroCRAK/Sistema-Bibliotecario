class Prestamo implements Persistible {
  private Usuario usuario;
  private Libro libro;
  private String fecha;

  Prestamo addUsuario(Usuario usuario){
    this.usuario = usuario;
    return this;
  }
  Prestamo addLibro(Libro libro){
    this.libro = libro;
    return this;
  }
  Prestamo addFecha(String fecha){
    this.fecha = fecha;
    return this;
  }
  @Override 
  public void guardar(){
    System.out.println("Guardando prestamo del usuario: " + usuario.getNombre());
  }
  @Override
  public void cargar(){
    System.out.println("Cargando prestamo del libro: " + libro.getTitulo());
  }
  @Override
  public void mostrarInformacion(){
    System.out.println("Usuario: " + usuario.getNombre());
    System.out.println("Libro: " + libro.getTitulo());
  }
  Usuario getUsuario(){
    return usuario;
  }
  Libro getLibro(){
    return libro;
  }
  String getFecha(){
    return fecha;
  }
}

