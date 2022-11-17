
class GrandParent
{
    String grandFatherName;
    String grandMotherName;
    GrandParent()
    {

    }
    GrandParent(String grandFatherName, String grandMotherName)
    {
        this.grandFatherName=grandFatherName;
        this.grandMotherName=grandMotherName;
        System.out.println("GrandFather Name:"+grandFatherName+"GrandMother Name:"+grandMotherName);
    }

}

class Parent extends GrandParent
{
    String FatherName;
    String MotherName;
Parent()
{

}
    Parent(String FatherName, String MotherName, String grandFatherName, String grandMotherName)
    {
        this.FatherName=FatherName;
        this.MotherName=MotherName;
        this.grandFatherName=grandFatherName;
        this.grandMotherName=grandMotherName;
        System.out.println("GrandFather Name:"+"-"+grandFatherName+","+"GrandMother Name:"+"-"+grandMotherName+"Father Name:"+"-"+FatherName+","+"Mother Name:"+"-"+MotherName);
    }


    Parent(String x, String y)
    {
        super(x,y);
    }
}


class Child extends Parent {
    Child(String FatherName, String MotherName, String grandFatherName, String grandMotherName)
    {
        super(FatherName,MotherName, grandFatherName,grandMotherName);
    }

    public static void main(String[] args) {
        System.out.println("Program started");
        System.out.println("Created child class object");

        Child c=new Child("Basawaraj","Neelu","Mahesh","Meena");

        System.out.println("Program Ended");

    }

}
