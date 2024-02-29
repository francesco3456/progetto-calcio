package utils;

public final class ClassSingleton {
	
	private static ClassSingleton INSTANCE;
	
	private ClassSingleton() {}

	public static ClassSingleton getInstance() {
		
		if (INSTANCE == null) {
			
			INSTANCE = new ClassSingleton();
		} else {
			System.out.println("Istanza già esistente");
		}
		
		return INSTANCE;
	}
}
