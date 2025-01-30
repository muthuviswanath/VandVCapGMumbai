package fundamentals;

public class Impementation {
public static void main(String[] args) {
	Predictable p = new Predictable() {
		@Override
		public void display() {
			System.out.println("Hello. Welcome to the world of Java");
		}
	};
	p.display();
}
}
