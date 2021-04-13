package plantillas;


public class Poligono {
	
	//propiedades
	private int num_lados;
	private double lado;
	private double posX,posY;
	
	
	//constructores
	public Poligono (int num_lados, double lado){
		this.setLado(lado);
		this.setNum_lados(num_lados);
	}
	
	public Poligono (int num_lados, double lado, double posX, double posY){
		this (num_lados, lado);
		this.setPosX(posX);
		this.setPosY(posY);
	}
	
	//métodos get y set
	public void setNum_lados(int num_lados) {
		if (num_lados <3){
			throw new IllegalArgumentException ("El poligono debe tener al menos 3 lados");
		}
		this.num_lados = num_lados;
	}
	

	public int getNum_lados() {
		return num_lados;
	}
	
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		if (lado <=0.0){
			throw new IllegalArgumentException ("El lado debe ser mayor de 0");
		}
		this.lado = lado;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	public double damePerimetro(){
		return this.getNum_lados()*this.getLado();
	}
	
	@Override
	public  String toString(){
		return " [Lados: "+this.getNum_lados()+ " * Perimetro: " + this.damePerimetro()+"]";
	}

} //fin de la clase
