package calculadora;

public class CaluladoraImpl implements Calculadora {
	
	@Override
	public int calcular(int i1, char op, int i2) {
		switch(op){
			case '+':
				return i1+i2;
			case '-':
				return i1-i2;
			default:
				return 0;
		}
	}

}
