class Libro implements Persistible {
  private String titulo;
  private String autor;
  private String fecha;

  Libro setTitulo(String titulo){
    this.titulo = titulo;
    return this;
  }
  Libro setAutor(String autor){
    this.autor = autor;
    return this;
  }
  Libro setFecha(String fecha){
    this.fecha = fecha;
    return this;
  }
  @Override 
  public void guardar(){
    System.out.println("Guardando libro: " + titulo);
  }
  @Override
  public void cargar(){
    System.out.println("Cargando libro: " + titulo);
  }
  @Override
  public void mostrarInformacion(){
    System.out.println("Titulo: " + titulo);
    System.out.println("Autor: " + autor);
    System.out.println("Fecha de publicacion: " + fecha);
  }
  String getTitulo(){
    return titulo;
  }
  String getAutor(){
    return autor;
  }
  String getFecha(){
    return fecha;
  }
}
