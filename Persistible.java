interface Persistible {
  void guardar();
  void cargar();
  default void mostrarInformacion(){
    System.out.println("Mostrando informacion vacia");
  }
  static Persistible instaciar(){
    return new DefaultPersistible();
  }
}
