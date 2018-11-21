package com.company;

import java.io.*;

public class Main {
//zmienne liczbowe aby wszedzie bylo widoczne i nie trzeba było pisać we wszyskich funkcjach
    static Cyfry cyfra1 = new Cyfry(' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '|');
    static  Cyfry cyfra2 = new Cyfry(' ', '_', ' ', ' ', '_', '|', '|', '_', ' ');
    static  Cyfry cyfra3 = new Cyfry(' ', '_', ' ', ' ', '_', '|', ' ', '_', '|');
    static  Cyfry cyfra4 = new Cyfry(' ', ' ', ' ', '|', '_', '|', ' ', ' ', '|');
    static  Cyfry cyfra5 = new Cyfry(' ', '_', ' ', '|', '_', ' ', ' ', '_', '|');
    static  Cyfry cyfra6 = new Cyfry(' ', '_', ' ', '|', '_', ' ', '|', '_', '|');
    static  Cyfry cyfra7 = new Cyfry(' ', '_', ' ', ' ', ' ', '|', ' ', ' ', '|');
    static   Cyfry cyfra8 = new Cyfry(' ', '_', ' ', '|', '_', '|', '|', '_', '|');
    static   Cyfry cyfra9 = new Cyfry(' ', '_', ' ', '|', '_', '|', ' ', '_', '|');
    static   Cyfry cyfra0 = new Cyfry(' ', '_', ' ', '|', ' ', '|', '|', '_', '|');


   // public static Cyfry[][] readFile(String filePath) throws IOException {

   //     return Konto;
  //  }
    public static int rliczwiersze(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int licz=0;
        String textLine = bufferedReader.readLine();
        do {

            licz+=1;
            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();
        return licz;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        {

            String nazwapliku= "bank_ocr_dojo_us3";
            int wartosc= rliczwiersze(nazwapliku);
//wczytywanie z pliku
            String []Zpliku=new String[wartosc];
            FileReader fileReader = new FileReader(nazwapliku);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            char []  zmiana;
            String textLine = bufferedReader.readLine();

            //Zpliku[0]=textLine;
            int i=0;
            do {

                Zpliku[i]=textLine;
                System.out.println(Zpliku[i]);

                textLine = bufferedReader.readLine();
                ++i;
            } while(textLine != null);
//próba zmiany typu string na char
            bufferedReader.close();
            System.out.println(Zpliku[0]);
            int pom=wartosc/4;
            int dl=wartosc-pom;
            int ilosc=(12-pom)/3;
            Cyfry[][]Konto=new Cyfry[ilosc][9];
            int pom2=0;

            char doZmainy[][] = new char[wartosc][27];
            for(int d=0;d<wartosc;d++)
            {

                zmiana=Zpliku[d].toCharArray();

                kopitab(doZmainy[d],zmiana,27);
                ++pom2;
            }
            pom2=0;
            char poms;

           i=0;
            int l=0;

            //tworzenie obiektów kont
for(int k=0;k<ilosc;++k){
            for(int j=0;j<9;j++)
            {

                Konto[k][j]=new Cyfry(doZmainy[i][l],doZmainy[i][l+1],doZmainy[i][l+2],
                        doZmainy[i+1][l],doZmainy[i+1][l+1],doZmainy[i+1][l+2],doZmainy[i+2][l],doZmainy[i+2][l+1],doZmainy[i+2][l+2]);l+=3;
                if(l>24)l=0;


            }i+=3;
}for(int k=0;k<ilosc;++k){
            for(int j=0;j<9;j++)

            {
                //System.out.print("eeee ");
                Konto[k][j].wypisz();
                if(j==8) System.out.println();


            }}
             for(int o=0;o<ilosc;++o) {CzytoPoprawne(Konto[o],9);
             }




            CzytakaMozebyc2();


        }
    }

    private static void zmianaStringNaChar(char[] chars, String s)
    {    chars=s.toCharArray();
    }

    public static void kopitab(char []tab1,char[]tab2,int wart)
    {
        for(int d=0;d<wart;d++)
        {
            tab1[d]=tab2[d];
        }
    }



    public static void CzytoPoprawne(Cyfry []podana,int n) throws IOException
    {

        int suma=0;
        int []pom=new int[9];
        String []pom2=new String[3];
        char[]pop=new char[9];

        char[]pop2=new char[9];
        char[]pop3=new char[9];
        char[]pop4=new char[9];
        char[]pop5=new char[9];
        char[]pop6=new char[9];
        char[]pop7=new char[9];
        char[]pop8=new char[9];
        char[]pop9=new char[9];
        String []pom3 = new String[4];

        podana[0].zmiananastring(pop);
        podana[1].zmiananastring(pop2);
        podana[2].zmiananastring(pop3);
        podana[3].zmiananastring(pop4);
        podana[4].zmiananastring(pop5);
        podana[5].zmiananastring(pop6);
       podana[6].zmiananastring(pop7);
        podana[7].zmiananastring(pop8);
       podana[8].zmiananastring(pop9);


        pom3[1]= String.valueOf(pop[3]+pop[4]+pop[5]+pop2[3]+pop2[4]+pop2[5]+ pop3[2]+pop3[3]+pop3[4]+ pop4[3]+pop4[4]+pop4[5]+ pop5[3]+pop5[4]+pop5[5]+ pop6[3]+pop6[4]+pop6[5]+ pop7[3]+pop7[4]+pop7[5]+ pop8[3]+pop8[4]+pop8[5]+ pop9[3]+pop9[4]+pop9[5]);
        pom3[0]= String.valueOf(pop[0]+pop[1]+pop[2]+pop2[0]+pop2[1]+pop2[2]+ pop3[0]+pop3[1]+pop3[2]+ pop4[0]+pop4[0]+pop4[2]+ pop5[0]+pop5[1]+pop5[2]+ pop6[0]+pop6[1]+pop6[2]+ pop7[0]+pop7[1]+pop7[2]+ pop8[0]+pop8[1]+pop8[2]+ pop9[0]+pop9[1]+pop9[2]);
        pom3[2]= String.valueOf(pop[6]+pop[7]+pop[8]+pop2[6]+pop2[7]+pop2[8]+ pop3[6]+pop3[7]+pop3[8]+ pop4[6]+pop4[7]+pop4[8]+ pop5[6]+pop5[7]+pop5[8]+ pop6[6]+pop6[7]+pop6[8]+ pop7[6]+pop7[7]+pop7[8]+ pop8[6]+pop8[7]+pop8[8]+ pop9[6]+pop9[7]+pop9[8]);
        System.out.println(pom[2]);
     for(int i=0;i<9;i++) {
            if ((cyfra1.sprawdzCzyCyfra(podana[i]) || cyfra2.sprawdzCzyCyfra(podana[i]) || cyfra3.sprawdzCzyCyfra(podana[i]) || cyfra4.sprawdzCzyCyfra(podana[i]) ||
                    cyfra5.sprawdzCzyCyfra(podana[i]) || cyfra6.sprawdzCzyCyfra(podana[i]) || cyfra7.sprawdzCzyCyfra(podana[i]) || cyfra8.sprawdzCzyCyfra(podana[i]) || cyfra9.sprawdzCzyCyfra(podana[i]) ||
                    cyfra0.sprawdzCzyCyfra(podana[i])) == false) {
               //zapisywanie do pliku
                PrintWriter fileWriter = new PrintWriter(" costam.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                pom3[3]="ill";
                try {
                    for (String line : pom3) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }

                } finally {
                    bufferedWriter.close();
                     return;
                }



            }

        } for(int ii=0;ii<9;ii++)
        {
            pom[ii]=zmien(podana[ii]);
            suma+=pom[ii];
        }
       if(suma%11==0){ PrintWriter fileWriter = new PrintWriter(" dobre.txt");
           BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
           pom3[3]="";
           try {
               for (String line : pom3) {
                   bufferedWriter2.write(line);
                   bufferedWriter2.newLine();
               }

           } finally {
               bufferedWriter2.close();
           }return;
       }

        else
       { PrintWriter fileWriter = new PrintWriter("costam.txt");
           BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
           pom3[3]="err";
           try {
               for (String line : pom3) {
                   bufferedWriter2.write(line);
                   bufferedWriter2.newLine();
               }

           } finally {
               bufferedWriter2.close();
           }return;
       }

    }
    public static void KopiujTab(String []tab,String []tab2)
    {
        for(int k=0;k<3;k++)
        {
            tab[k]=tab2[k];
        }
    }
//sprawdza z funkcji popwrawnosc i poprawia na daną liczbą coś dodając
    public static void CzytakaMozebyc1(Cyfry danaCyfra)
    {
        Pewna0(danaCyfra);
        Pewna1(danaCyfra);
        Pewna2(danaCyfra);
        Pewna3(danaCyfra);
        Pewna4(danaCyfra);
        Pewna5(danaCyfra);
        Pewna6(danaCyfra);
        Pewna7(danaCyfra);
        Pewna8(danaCyfra);
        Pewna9(danaCyfra);

    }
    public static void CzytakaMozebyc2()throws IOException
    {
        String nazwapliku2="bank_ocr_dojo_us4";
        int wartosc2= rliczwiersze(nazwapliku2);
//wczytywanie z pliku
        String []Zpliku2=new String[wartosc2];
        System.out.print(wartosc2);
        FileReader fileReader2 = new FileReader(nazwapliku2);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        char []  zmiana2;
        String textLine2 = bufferedReader2.readLine();


        int i=0;
        do {

            Zpliku2[i]=textLine2;
            System.out.println(Zpliku2[i]);

            textLine2 = bufferedReader2.readLine();
            ++i;
        } while(textLine2 != null);
//próba zmiany typu string na char
        bufferedReader2.close();
        System.out.println(Zpliku2[0]);
        int pome=wartosc2/4;
        int dl2=wartosc2-pome;
        int ilosc2=(12-pome)/3;
        Cyfry[][]Konto2=new Cyfry[ilosc2][9];


        char doZmainy2[][] = new char[wartosc2][27];
        for(int d=0;d<wartosc2;d++)
        {

            zmiana2=Zpliku2[d].toCharArray();

            kopitab(doZmainy2[d],zmiana2,27);

        }


        i=0;
       int  l=0;
        //tworzenie obiektów kont
        for(int k=0;k<ilosc2;++k){
            for(int j=0;j<9;j++)
            {

                Konto2[k][j]=new Cyfry(doZmainy2[i][l],doZmainy2[i][l+1],doZmainy2[i][l+2],
                        doZmainy2[i+1][l],doZmainy2[i+1][l+1],doZmainy2[i+1][l+2],doZmainy2[i+2][l],doZmainy2[i+2][l+1],doZmainy2[i+2][l+2]);l+=3;
                if(l>24)l=0;


            }i+=3;
        }

        int suma = 0;
        int[] poma = new int[9];
        String []poma2=new String[3];
        char[]pom4=new char[9];
        String []pom3 = new String[4];
        for(int ii=0;ii<9;ii++) {
            for (int j = 0; j < ilosc2; j++) {

                if (nieznane(Konto2[ii][j])) {
                    //do wczytania},gdyż ma zbyt wiele możliwości

                    String []pom2=new String[3];
                    char[]pop=new char[9];
                    char[]pop1=new char[9];
                    char[]pop2=new char[9];
                    char[]pop3=new char[9];
                    char[]pop4=new char[9];
                    char[]pop5=new char[9];
                    char[]pop6=new char[9];
                    char[]pop7=new char[9];
                    char[]pop8=new char[9];
                    char[]pop9=new char[9];
                    String []pom33 = new String[4];

                    Konto2[ii][0].zmiananastring(pop);
                    Konto2[ii][1].zmiananastring(pop2);
                    Konto2[ii][2].zmiananastring(pop3);
                    Konto2[ii][3].zmiananastring(pop4);
                    Konto2[ii][4].zmiananastring(pop5);
                    Konto2[ii][5].zmiananastring(pop6);
                    Konto2[ii][6].zmiananastring(pop7);
                    Konto2[ii][7].zmiananastring(pop8);
                    Konto2[ii][8].zmiananastring(pop9);
                    // for(int k=0;k<3;k++)

                    for(int k=0;k<3;++k)
                        for(int l1=0;l1<9;l1+=3){{
                            pom3[k]= String.valueOf(pop[l1]+pop[l1+1]+pop[l1+2]+pop2[l1]+pop2[l1+1]+pop2[l1+2]+ pop3[l1]+pop3[l1+1]+pop3[l1+2]+ pop4[l1]+pop4[l1+1]+pop4[l1+2]+ pop5[l1]+pop5[l1+1]+pop5[l1+2]+ pop6[l1]+pop6[l1+1]+pop6[l1+2]+ pop7[l1]+pop[l1+1]+pop7[l1+2]+ pop8[l1]+pop8[l1+1]+pop8[l1+2]+ pop9[l1]+pop9[l1+1]+pop9[l1+2]);
                        }}


                    PrintWriter fileWriter = new PrintWriter("costam.txt");
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                    pom3[3]="amb";
                    try {
                        for (String line : poma2) {
                            bufferedWriter2.write(line);
                            bufferedWriter2.newLine();
                        }

                    } finally {
                        bufferedWriter2.close();
                    }
                }

                CzytakaMozebyc1(Konto2[ii][j]);
                CzytoPoprawne(Konto2[ii],9);
            }
        }



    }

//tu zamienia sprawdzając
    public static int zmien(Cyfry podana)
    {

        int pozmianie=0;
        if(cyfra1.sprawdzCzyCyfra(podana)){pozmianie=1;}
         if(cyfra2.sprawdzCzyCyfra(podana))pozmianie=2;
        if(cyfra3.sprawdzCzyCyfra(podana))pozmianie=3;
        if(cyfra4.sprawdzCzyCyfra(podana))pozmianie=4;
        if(cyfra5.sprawdzCzyCyfra(podana))pozmianie=5;
        if(cyfra6.sprawdzCzyCyfra(podana))pozmianie=6;
        if(cyfra7.sprawdzCzyCyfra(podana))pozmianie=7;
         if(cyfra8.sprawdzCzyCyfra(podana))pozmianie=8;
         if(cyfra9.sprawdzCzyCyfra(podana))pozmianie=9;
       if(cyfra0.sprawdzCzyCyfra(podana))pozmianie=0;

        return pozmianie;
    }

    public static void cosBrakuje(Cyfry podana,Cyfry pewienBlad,Cyfry danaCyfra)
    {

       if(podana.sprawdzCzyCyfra(pewienBlad))podana=danaCyfra;
    }
    //do dodania cos cyfry do zmiany i możliwości
    public static void Pewna1(Cyfry podana)
    {
         Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ');
         Cyfry cyfrablad2 = new Cyfry(' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|');
        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)) podana=cyfra1;
    }
    public static void Pewna2(Cyfry podana)
    {
        Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', ' ', '_', '|', '|', '_', ' ');
         Cyfry cyfrablad2 = new Cyfry(' ', '_', ' ', ' ', '_', ' ', '|', '_', ' ');
         Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', ' ', ' ', '|', '|', '_', ' ');
        Cyfry cyfrablad4 = new Cyfry(' ', '_', ' ', ' ', '_', '|', '|', ' ', ' ');
        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)||podana.sprawdzCzyCyfra(cyfrablad3)
                ||podana.sprawdzCzyCyfra(cyfrablad4)) podana=cyfra2;
    }
    public static void Pewna3(Cyfry podana)
    {
        Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', ' ', '_', '|', ' ', '_', '|');
        Cyfry cyfrablad2 = new Cyfry(' ', '_', ' ', ' ', ' ', '|', ' ', '_', '|');
        Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', ' ', '_', '|', ' ', ' ', '|');

        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)
                ||podana.sprawdzCzyCyfra(cyfrablad3)) podana=cyfra3;
    }
    public static void Pewna4(Cyfry podana)

    {
        Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', ' ', '_', '|', ' ', ' ', '|');
        Cyfry cyfrablad2 = new Cyfry(' ', ' ', ' ', '|', ' ', '|', ' ', ' ', '|');
        Cyfry cyfrablad3 = new Cyfry(' ', ' ', ' ', '|', '_', ' ', ' ', ' ', '|');
        Cyfry cyfrablad4 = new Cyfry(' ', ' ', ' ', '|', '_', '|', ' ', ' ', ' ');
        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)||podana.sprawdzCzyCyfra(cyfrablad3)
                ||podana.sprawdzCzyCyfra(cyfrablad4)) podana=cyfra4;
    }
    public static void Pewna5(Cyfry podana)
    {
        Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', '|', '_', ' ', ' ', '_', '|');
        Cyfry cyfrablad2 = new Cyfry(' ', '_', ' ', '|', ' ', ' ', ' ', '_', '|');
        Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', '|', '_', ' ', ' ', '_', ' ');
        Cyfry cyfrablad4 = new Cyfry(' ', '_', ' ', '|', '_', ' ', ' ', ' ', '|');
        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)||podana.sprawdzCzyCyfra(cyfrablad3)
                ||podana.sprawdzCzyCyfra(cyfrablad4)) podana=cyfra5;
    }
    public static void Pewna6(Cyfry podana)
    {
        Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', '|', '_', ' ', '|', '_', '|');
        Cyfry cyfrablad2 = new Cyfry(' ', '_', ' ', ' ', '_', ' ', '|', '_', '|');
        Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', '|', '_', ' ', '|', '_', ' ');
        Cyfry cyfrablad4 = new Cyfry(' ', '_', ' ', '|', '_', ' ', '|', ' ', '|');

        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)
                ||podana.sprawdzCzyCyfra(cyfrablad3)||podana.sprawdzCzyCyfra(cyfrablad4))podana=cyfra6;
    }
    public static void Pewna7(Cyfry podana)
    {
        Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '|');
        Cyfry cyfrablad2 = new Cyfry(' ', '_', ' ', ' ', ' ', ' ', ' ', ' ', '|');
        Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', ' ', ' ', '|', ' ', ' ', ' ');

        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)||podana.sprawdzCzyCyfra(cyfrablad3)
                ) podana=cyfra7;
    }
    public static void Pewna8(Cyfry podana)
    {
        Cyfry cyfrablad1 = new Cyfry(' ', '_', ' ', '|', ' ', '|', '|', '_', '|');
        Cyfry cyfrablad2 = new Cyfry(' ', ' ', ' ', '|', '_', '|', '|', '_', '|');
        Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', '|', '_', '|', '|', ' ', '|');
        Cyfry cyfrablad4 = new Cyfry(' ', '_', ' ', '|', '_', '|', '|', '_', ' ');
        Cyfry cyfrablad5 = new Cyfry(' ', '_', ' ', '|', '_', ' ', '|', '_', '|');
        Cyfry cyfrablad6 = new Cyfry(' ', '_', ' ', '|', '_', '|', ' ', '_', '|');
        Cyfry cyfrablad7 = new Cyfry(' ', '_', ' ', ' ', '_', '|', '|', '_', '|');

        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)
                ||podana.sprawdzCzyCyfra(cyfrablad3)||podana.sprawdzCzyCyfra(cyfrablad4)
                ||podana.sprawdzCzyCyfra(cyfrablad5)||podana.sprawdzCzyCyfra(cyfrablad6)||podana.sprawdzCzyCyfra(cyfrablad7)) podana=cyfra8;
    }
    public static void Pewna9(Cyfry podana)
    {
        Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', '|', '_', '|', ' ', '_', '|');
        Cyfry cyfrablad2 = new Cyfry(' ', '_', ' ', ' ', '_', '|', ' ', '_', '|');
        Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', '|', '_', ' ', ' ', '_', '|');
        Cyfry cyfrablad4 = new Cyfry(' ', '_', ' ', '|', '_', '|', ' ', '_', '|');
        Cyfry cyfrablad5 = new Cyfry(' ', '_', ' ', '|', '_', '|', ' ', '_', ' ');
        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)||podana.sprawdzCzyCyfra(cyfrablad3)
                ||podana.sprawdzCzyCyfra(cyfrablad4)||podana.sprawdzCzyCyfra(cyfrablad5)) podana=cyfra9;
    }
    public static void Pewna0(Cyfry podana)
    {
        Cyfry cyfrablad1 = new Cyfry(' ', ' ', ' ', '|', ' ', '|', '|', '_', '|');
        Cyfry cyfrablad2 = new Cyfry(' ', '_', ' ', '|', ' ', '|', '|', '_', ' ');
        Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', '|', ' ', '|', '|', ' ', '|');
        Cyfry cyfrablad4 = new Cyfry(' ', '_', ' ', '|', ' ', ' ', '|', '_', '|');
        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)||podana.sprawdzCzyCyfra(cyfrablad3)||podana.sprawdzCzyCyfra(cyfrablad4)) podana=cyfra0;
    }
    public static boolean nieznane(Cyfry podana){
        Cyfry cyfrablad1 = new Cyfry(' ', '_', ' ', ' ', '_', '|', ' ', '_', ' ');
        Cyfry cyfrablad2 = new Cyfry(' ', '_', ' ', ' ', '_', ' ', ' ', '_', '|');
        Cyfry cyfrablad3 = new Cyfry(' ', '_', ' ', '|', ' ', ' ', '|', '_', '|');
        Cyfry cyfrablad4 = new Cyfry(' ', '_', ' ', '|', ' ', '|', ' ', '_', '|');
        if(podana.sprawdzCzyCyfra(cyfrablad1)||podana.sprawdzCzyCyfra(cyfrablad2)||podana.sprawdzCzyCyfra(cyfrablad3)||podana.sprawdzCzyCyfra(cyfrablad4)==true)
            return true;
        return false;
    }
}