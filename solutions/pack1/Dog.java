package solutions.pack1;


public class Dog{
    private Breed breed;
    private int weight;
    public Dog(Breed b, int w){
        breed = b;
        weight = w;
    }
    public Breed getbreed(){
        return breed;
    }
    public int getweight(){
        return weight;
    }
    @Override
    public String toString(){
        return "Dog [breed=" + breed + ", weight=" + weight + "]";
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + weight;
        return result;
    }
}