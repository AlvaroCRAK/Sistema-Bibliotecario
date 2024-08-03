class DefaultPersistible implements Persistible {
  @Override
  public void guardar(){
    System.out.println("Guardando nada en class Persistible");
  }
  @Override
  public void cargar(){
    System.out.println("Cargando nada en class Persistible");
  }
  @Override
  public void mostrarInformacion(){
    System.out.println("vacio class DefaultPersistible");
  }
}
