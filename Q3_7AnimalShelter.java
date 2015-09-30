package cc150;

import java.util.LinkedList;
public class Q3_7AnimalShelter {
	private class Animal {
		private String name;
		private int num;
		private Animal(String name, int num) {
			this.name = name;
			this.num = num;
		}
		
		public String toString() {
			return name + " " + num;
		}
	}
	private String cat = "cat";
	private String dog = "dog";
	private LinkedList<Animal> dogs = new LinkedList<Animal>();
	private LinkedList<Animal> cats = new LinkedList<Animal>();
	private int n = 0;					//unique number of the animals
	public void enqueque(String name) {
		if (!name.equals(cat) && !name.equals(dog)) {
			System.out.println("We only accept dog and cat.");
			return;
		}
		n++;
		Animal newAnimal = new Animal(name, n);
		if (name.equals(cat)) {
			cats.addLast(newAnimal);
		} 
		if (name.equals(dog)) {
			dogs.addLast(newAnimal);
		}
	}
	
	public Animal dequeueAny() {
		if (dogs.isEmpty() && cats.isEmpty()) {
			System.out.println("there is no dog or cat in the shelter now");
			return null;
		} else if (dogs.isEmpty() && !cats.isEmpty()) {
			return cats.removeFirst();
		} else if (!dogs.isEmpty() && cats.isEmpty()) {
			return dogs.removeFirst();
		} else if (cats.getFirst().num < dogs.getFirst().num) {
			return cats.removeFirst();
		} else return dogs.removeFirst();
	}
	public Animal dequeueDog() {
		if (dogs.isEmpty()) {
			System.out.println("there is no dog in the shelter now");
			return null;
		}
		return dogs.removeFirst();
	}
	public Animal dequeueCat() {
		if (cats.isEmpty()) {
			System.out.println("there is no cat in the shelter now");
			return null;
		}
		return cats.removeFirst();
	}
	
	public static void main(String[] args) {
		Q3_7AnimalShelter test = new Q3_7AnimalShelter();
		test.enqueque("cat");
		test.enqueque("cat");
		test.enqueque("dog");
		test.enqueque("cat");
		test.enqueque("dog");
		test.enqueque("dog");
		
		System.out.println(test.dequeueDog().toString());
		System.out.println(test.dequeueAny().toString());
		System.out.println(test.dequeueDog().toString());
		System.out.println(test.dequeueAny().toString());
		System.out.println(test.dequeueAny().toString());
		System.out.println(test.dequeueAny().toString());
		
	}
}
