package com.company;

/**
 * Created by User on 17.11.2018.
 */
//Klasa cyfry do wpisania cyfr  funkvje
public class Cyfry {
    char[][] Number = new char[3][3];
    char[] lit;
    int wielkosc;

    Cyfry(char lit1, char lit2, char lit3, char lit4, char lit5, char lit6, char lit7, char lit8, char lit9) {
        this.Number[0][0] = lit1;
        this.Number[0][1] = lit2;
        this.Number[0][2] = lit3;
        this.Number[1][0] = lit4;
        this.Number[1][1] = lit5;
        this.Number[1][2] = lit6;
        this.Number[2][0] = lit7;
        this.Number[2][1] = lit8;
        this.Number[2][2] = lit9;

    }

    public boolean sprawdzCzyCyfra(Cyfry czydobra)
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                if(this.Number[i][j]!=czydobra.Number[i][j])return false;
        }
        return true;
    }
    public void zmiananastring(char[]Zmiana)
    {
        int l=0;
       for(int i=0;i<3;i++)
       {
           for(int j=0;j<3;j++)
           {
               Zmiana[l]= this.Number[i][j];

               ++l;
           }
       }



    }
    public void wypisz()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {

                System.out.print(this.Number[i][j]);


            }
        }
    }

}
