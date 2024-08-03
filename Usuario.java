class Usuario implements Persistible {
  private String nombre;
  private int id;
  private int age;

  Usuario setNombre(String nombre){
    this.nombre = nombre;
    return this;
  }
  Usuario setId(int id){
    this.id = id;
    return this;
  }
  Usuario setAge(int age){
    this.age = age;
    return this;
  }
  @Override
  public void guardar(){
    System.out.println("Guardando usuario: " + nombre);
  }
  @Override
  public void cargar(){
    System.out.println("Cargando usuario: " + nombre);
  }
  @Override
  public void mostrarInformacion(){
    System.out.println("Nombre: " + nombre);
    System.out.println("Id: " + id);
    System.out.println("Edad: " + age);
  }
  String getNombre(){
    return nombre;
  }
  int getId(){
    return id;
  }
  int getAge(){
    return age;
  }
}
