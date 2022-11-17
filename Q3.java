class Shape
{
    void draw()
    {
        System.out.println("draw method of parent shape class ");
    }

    void erase()
    {
        System.out.println("erase method of parent shape class");
    }

}

class circle extends Shape
{
    void draw()
    {
        System.out.println("draw method of child circle class ");
    }

    void erase()
    {
        System.out.println("erase method of child circle class ");
    }

}

class triangle extends Shape
{
    void draw()
    {
        System.out.println("draw method of child triangle class ");
    }

    void erase()
    {
        System.out.println("erase method of child triangle class ");
    }
}

class Square extends Shape
{
    void draw()
    {
        System.out.println("draw method of child Square class ");
    }

    void erase()
    {
        System.out.println("erase method of child Square class ");
    }
}



public class Q3 {
    public static void main(String[] args) {
        System.out.println("Program started");
        circle c=new circle();
        triangle t=new triangle();
        Square s=new Square();

        System.out.println("calling draw() methods Overriden from parent class shape in all child classes ");
        c.draw();
        t.draw();
        s.draw();

        System.out.println("calling erase() methods Overriden from parent class shape in all child classes ");
        c.erase();
        t.erase();
        s.erase();
        System.out.println("Program completed");


    }
}
