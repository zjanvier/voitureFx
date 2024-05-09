package com.example.voiturefx;

/**
 * @author : jzagabe
 * @Description : Classe qui définit le modèle Car
 * @created : 2024-04-15, Monday
 **/
public class Car
{
    int carId;
    String make;
    String model;
    int year;

    //Constructeur
    public Car()
    { }
    public Car(String make)
    {
        this.make=make;

    }
    public Car(int carId,String make, String model, int year)
    {
        this.carId=carId;
        this.make = make;
        this.model = model;
        this.year=year;
    }
    // Getters & Setters
    public int getCarId()
    {
        return carId;
    }

    public void setCarId(int carId)
    {
        this.carId = carId;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }
/*
Cette méthode a été définie pour permettre de pouvoir afficher
les données d'une voiture (sinon l'affichage devrait montrer l'objet car)
Il s'agit d'une redefinition de la méthode toString qui existe déjà en java
(la methode toString existe dans la classe object de java)
  */
    @Override
    public String toString()
    {
        String voiture=this.getMake() + " " + this.getModel()+ " " + this.year;
        return voiture;
    }

}
