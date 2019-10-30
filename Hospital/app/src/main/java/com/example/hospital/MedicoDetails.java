package com.example.hospital;

public class MedicoDetails {
    String id;
    String nombre;
    String fono;
    String direccion;
    public MedicoDetails()
    {

    }
    public MedicoDetails(String id,String name,String fon,String dir)
    {
        this.id=id;
        this.nombre=name;
        this.fono=fon;
        this.direccion=dir;
    }
    public String getId()
    {
        return id;
    }
    public String getNombre()
    {
        return nombre;
    }
    public String getFono()
    {
        return fono;
    }
    public String getDireccion()
    {
        return direccion;
    }

    public void setId(String id)
    {
        this.id=id;
    }
    public void setNombre(String name)
    {
        this.nombre=name;
    }
    public void setFono(String telefono)
    {
        this.fono=telefono;
    }
    public void setDireccion(String direction)
    {
        this.direccion=direction;
    }
}
