package General;

import Characters.Personaje;

import java.io.PrintWriter;
import java.util.ArrayList;

import General.Utilidad;


public class CentralNuclear {
    private static CentralNuclear miCentral;  //Atributo del patrÃ³n Singleton
    private int turno;           //Turno de la simulaciÃ³n
    //                                   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63
    final private int[][] adyacencia = {{0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//0
            ,{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//1
            ,{0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//2
            ,{0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//3
            ,{0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//4
            ,{0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//5
            ,{0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//6
            ,{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//7
            ,{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//8
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//9
            ,{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//10
            ,{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//11
            ,{0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//12
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//13
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//14
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//15
            ,{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//16
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//17
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//18
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//19
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//20
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//21
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//22
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//23
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//24
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//25
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//26
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//27
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//28
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//29
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//30
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//31
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//32
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//33
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//34
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//35
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//36
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//37
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//38
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//39
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//40
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//41
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//42
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//43
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//44
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//45
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}//46
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}//47
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}//48
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}//49
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//50
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}//51
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}//52
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0}//53
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0}//54
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1}//55
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}//56
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0}//57
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}//58
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}//59
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0}//60
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0}//61
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1}//62
            ,{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0}};//63  //Matriz de adyacencia*/
    //                                   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63

    private Celda[][] matriz;    //Matriz que contiene todas las celdas

    private ArrayList<Personaje> list_de_personajes_central;

    private int TurnosNecesarios;

    /* Constructor clase CentralNuclear
           Será privado, ya que estamos utilizando el patrón Singleton (así obligamos
           a utilizar el método getInstancia, asegurando de esta manera que exista
           una única instancia */
    private CentralNuclear(){
        this.turno = 0;
        this.matriz = new Celda[Constantes.FILAS][Constantes.COLUMNAS];

        this.list_de_personajes_central = new ArrayList<Personaje>();
        int cont = 0;
        for(int i = 0; i < this.matriz.length;i++){
            for(int j = 0; j < this.matriz[i].length;j++){
                this.matriz[i][j] = new Celda(cont);
                cont++;
            }
        }
    }

    //INSTANCIA PATRÓN SINGLETON
    public static CentralNuclear getInstancia(){
        if  (miCentral == null){
            miCentral = new CentralNuclear();
        }
        return miCentral;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    //Inicializa los kilos de escombros de una serie de celdas
    public void inicializarEscombros(){
        this.matriz[0][1].setEscombros(5);
        this.matriz[0][3].setEscombros(2);

        this.matriz[2][4].setEscombros(3);

        this.matriz[5][3].setEscombros(3);

        this.matriz[6][4].setEscombros(6);
    }

    public boolean hayCamino(int celdaOrigen, int celdaDestino) {
        int tamanno = this.adyacencia.length;

        if (celdaOrigen >= 0 && celdaOrigen < tamanno && celdaDestino >= 0 && celdaDestino < tamanno) {
            if (this.adyacencia[celdaOrigen][celdaDestino] == 1) {
                return true;
            }
        } else {
            return false;

        }

        return false;
    }



    public Celda getCelda(int fila, int columna) {
        return matriz[fila][columna];
    }

    public Celda getCeldaPorId(int idCelda) {
        for (Celda[] fila : matriz) {
            for (Celda celda : fila) {
                if (celda.getIdentificador_celda() == idCelda) {
                    return celda;
                }
            }
        }
        return null;
    }


    public void insPersonaje(Personaje personaje) {

        int celda_personaje = personaje.getIdCeldaActual();
        int columna = Utilidad.calcularColumna(celda_personaje);
        int fila = Utilidad.calcularFila(celda_personaje);
        matriz[fila][columna].insPersonaje(personaje);

    }

    public void insLlave(Llave llave) {


        int columna = Utilidad.calcularColumna(llave.getCeldaActual());
        int fila = Utilidad.calcularFila(llave.getCeldaActual());
        matriz[fila][columna].setLlave(llave);
    }


    public void borrarLlave(Llave llave) {
        int columna = Utilidad.calcularColumna(llave.getCeldaActual());
        int fila = Utilidad.calcularFila(llave.getCeldaActual());

        matriz[fila][columna].setLlave(null);

        while(true) {
            if(llave.getIdLlave() == this.matriz[fila][columna].getLlave().getIdLlave()) {
                llave=null;

            }
        }
    }


    public void insPuertaSalida(Puerta puerta) {

        int celda_puerta = puerta.getIdentificador_celda();
        int columna = Utilidad.calcularColumna(celda_puerta);
        int fila = Utilidad.calcularFila(celda_puerta);
        matriz[fila][columna].setPuerta(puerta);
    }


    public void mostrarCeldasRefrigeradas(PrintWriter escribidor) {
        boolean salto = false;
        //System.out.println(Constantes.CELDAS_REFRIGERADAS);
        for (Celda[] fila : matriz) {
            for (Celda celda : fila) {
                if (celda.isRefrigerada()) {
                    escribidor.print("[" + celda.getIdentificador_celda() + "]");
                    salto = true;
                }
            }
            if(salto)
                escribidor.println();

        }
    }

    public ArrayList<Personaje> getListaPersonajes() {
        return list_de_personajes_central;
    }

    public void insertarPersonajeLista(Personaje personaje) {
        list_de_personajes_central.add(personaje);

    }

    public int longitudListaPersonajesCentral() {
        return list_de_personajes_central.size();
    }



    public Personaje getPersonajeCentral(int posicion) {
        if(posicion >=0 && posicion < list_de_personajes_central.size()) {
            return list_de_personajes_central.get(posicion);

        }else {
            return null;
        }

    }





    public ArrayList<Integer> getAdyacentes(int fila, int columna) {
        ArrayList<Integer> celdasAdyacentes = new ArrayList<>();

        int filaStart = Math.max(0, fila - 1);
        int filaEnd = Math.min(matriz.length - 1, fila + 1);
        int colStart = Math.max(0, columna - 1);
        int colEnd = Math.min(matriz[0].length - 1, columna + 1);

        for (int i = filaStart; i <= filaEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (!(i == fila && j == columna)) {
                    Celda celda = matriz[i][j];
                    if (celda != null) {
                        celdasAdyacentes.add(celda.getIdentificador_celda());
                    }
                }
            }
        }

        return celdasAdyacentes;
    }








    /***************************************************************************************/
    /***************************************************************************************/
    /********************** MÉTODOS PARA PINTAR LA CENTRAL NUCLEAR *************************/
    /***************************************************************************************/
    /***************************************************************************************/

    /* Retorna true si la celda NO es accesible (hay un edificio, un árbol, ...) */
    private boolean celdaNoAccesible(int idCelda){
        boolean noAccesible = true;
        int j = 0;
        while((j < (Constantes.FILAS*Constantes.FILAS))&&(noAccesible)){
            if  (this.adyacencia[idCelda][j] == 1){
                noAccesible = false;
            }
            j++;
        }
        return noAccesible;
    }


    /*********************METODOS MATRIZ POR PANTALLA*********************************/




    /*private void pintarLineaSuperior(int i){
        int celdaOrigen, celdaDestino, j;
        if  (i == 0){
            //Línea superior. Empezamos dejando un hueco para dejas un primer hueco para pintar la línea izquierda
            System.out.print(" ");
            for(j = 0; j < this.matriz[0].length;j++){
                System.out.print("------- ");
            }
        }
        else{
            System.out.print("|");
            for(j = 0; j < this.matriz[i].length-1;j++){
                //Calculamos celdaOrigen y celdaDestino
                celdaOrigen = (Constantes.FILAS * i) + j;
                celdaDestino = celdaOrigen - Constantes.FILAS;
                if  (hayCamino(celdaOrigen, celdaDestino)){
                    System.out.print("        ");
                }
                else{
                    System.out.print("------- ");
                }
            }
            //Calculamos celdaOrigen y celdaDestino
            celdaOrigen = (Constantes.FILAS * i) + j;
            celdaDestino = celdaOrigen - Constantes.FILAS;
            if  (hayCamino(celdaOrigen, celdaDestino)){
                System.out.print("       |");
            }
            else{
                System.out.print("-------|");
            }
        }
        //Ponemos el cursor en la siguiente línea
        System.out.print("\n");
    }

    /* Pinta línea inferior del CentralNuclear.
    l metodo es privado porque sólo se utiliza

       en la clase CentralNuclear */

    /*private void pintarLineaInferior(){
        //Línea inferior. Empezamos dejando un hueco para dejas un primer hueco para pintar la línea izquierda
        System.out.print(" ");
        for(int j = 0; j < this.matriz[0].length;j++){
            System.out.print("------- ");
        }
        //Ponemos el cursor en la siguiente línea
        System.out.print("\n");
    }*/

    /* Pinta la columna 0 de la matriz.
       en la clase CentralNuclear */

    /*
    private void pintarColumnaCero(int celdaOrigen, int celdaDestino, int i, int j, int x){

        if  (celdaNoAccesible(celdaOrigen)){
            System.out.print("|///////|");
        }
        else{
            if  (hayCamino(celdaOrigen, celdaDestino)){
                //Si estamos en la primera o última de las 3 líneas
                if (x % 2 == 0){
                    System.out.print("|        ");
                }
                else{  //Si estamos en la línea central
                    System.out.print("|   "+this.matriz[i][j].toString()+"    ");
                }
            }
            else{
                //Si estamos en la primera o última de las 3 líneas
                if (x % 2 == 0){
                    System.out.print("|       |");
                }
                else{  //Si estamos en la línea central
                    System.out.print("|   "+this.matriz[i][j].toString()+"   |");
                }
            }
        }

    }
    */


    /*
    private void pintarRestoColumnas(int celdaOrigen, int celdaDestino, int i, int j, int x){

        if  (celdaNoAccesible(celdaOrigen)){
            System.out.print("///////|");
        }
        else{
            if  (hayCamino(celdaOrigen, celdaDestino)){
                //Si estamos en la primera o última de las 3 líneas
                if (x % 2 == 0){
                    System.out.print("        ");
                }
                else{  //Si estamos en la línea central
                    System.out.print("   "+this.matriz[i][j].toString()+"    ");
                }
            }
            else{
                //Si estamos en la primera o última de las 3 líneas
                if (x % 2 == 0){
                    System.out.print("       |");
                }
                else{  //Si estamos en la línea central
                    System.out.print("   "+this.matriz[i][j].toString()+"   |");
                }
            }
        }
    }
    */



    /*

    private void pintarFila(int i){
        int j, x;
        int celdaOrigen, celdaDestino;
        for(x = 0; x < 3;x++){  //Cada celda la dividimos en 3 líneas
            for(j = 0; j < this.matriz[i].length;j++){  //Columnas
                //Calculamos celdaOrigen y celdaDestino
                celdaOrigen = (Constantes.FILAS * i) + j;
                celdaDestino = celdaOrigen + 1;

                //Si estamos en la primera columna
                if  (j == 0){
                    pintarColumnaCero(celdaOrigen, celdaDestino, i, j, x);
                }
                else{  //Si estamos en cualquier columna del medio
                    pintarRestoColumnas(celdaOrigen, celdaDestino, i, j, x);
                }
            }
            //Ponemos el cursor en la siguiente línea
            System.out.print("\n");
        }
    }*/

   /*

   public void mostrarMatriz(){
        int i;

        for(i = 0; i < this.matriz.length;i++){  //Filas
            pintarLineaSuperior(i);
            pintarFila(i);

        }
        pintarLineaInferior();
    }
   */



    /******************************METODOS FICHEROS*********************/

    private void pintarLineaSuperior(PrintWriter escribidor, int i) {
        int celdaOrigen, celdaDestino, j;
        if (i == 0) {
            // Línea superior. Empezamos dejando un hueco para dejar un primer hueco para pintar la línea izquierda
            escribidor.print(" ");
            for (j = 0; j < this.matriz[0].length; j++) {
                escribidor.print("------- ");
            }
        } else {
            escribidor.print("|");
            for (j = 0; j < this.matriz[i].length - 1; j++) {
                // Calculamos celdaOrigen y celdaDestino
                celdaOrigen = (Constantes.FILAS * i) + j;
                celdaDestino = celdaOrigen - Constantes.FILAS;
                if (hayCamino(celdaOrigen, celdaDestino)) {
                    escribidor.print("        ");
                } else {
                    escribidor.print("------- ");
                }
            }
            // Calculamos celdaOrigen y celdaDestino
            celdaOrigen = (Constantes.FILAS * i) + j;
            celdaDestino = celdaOrigen - Constantes.FILAS;
            if (hayCamino(celdaOrigen, celdaDestino)) {
                escribidor.print("       |");
            } else {
                escribidor.print("-------|");
            }
        }
        // Ponemos el cursor en la siguiente línea
        escribidor.print("\n");
    }

    private void pintarLineaInferior(PrintWriter escribidor) {
        // Línea inferior. Empezamos dejando un hueco para dejas un primer hueco para pintar la línea izquierda
        escribidor.print(" ");
        for (int j = 0; j < this.matriz[0].length; j++) {
            escribidor.print("------- ");
        }
        // Ponemos el cursor en la siguiente línea
        escribidor.print("\n");
    }

    private void pintarColumnaCero(PrintWriter escribidor, int celdaOrigen, int celdaDestino, int i, int j, int x) {
        if (celdaNoAccesible(celdaOrigen)) {
            escribidor.print("|///////|");
        } else {
            if (hayCamino(celdaOrigen, celdaDestino)) {
                // Si estamos en la primera o última de las 3 líneas
                if (x % 2 == 0) {
                    escribidor.print("|        ");
                } else {  // Si estamos en la línea central
                    escribidor.print("|   " + this.matriz[i][j].toString() + "    ");
                }
            } else {
                // Si estamos en la primera o última de las 3 líneas
                if (x % 2 == 0) {
                    escribidor.print("|       |");
                } else {  // Si estamos en la línea central
                    escribidor.print("|   " + this.matriz[i][j].toString() + "   |");
                }
            }
        }
    }

    private void pintarRestoColumnas(PrintWriter escribidor, int celdaOrigen, int celdaDestino, int i, int j, int x) {
        if (celdaNoAccesible(celdaOrigen)) {
            escribidor.print("///////|");
        } else {
            if (hayCamino(celdaOrigen, celdaDestino)) {
                // Si estamos en la primera o última de las 3 líneas
                if (x % 2 == 0) {
                    escribidor.print("        ");
                } else {  // Si estamos en la línea central
                    escribidor.print("   " + this.matriz[i][j].toString() + "    ");
                }
            } else {
                // Si estamos en la primera o última de las 3 líneas
                if (x % 2 == 0) {
                    escribidor.print("       |");
                } else {  // Si estamos en la línea central
                    escribidor.print("   " + this.matriz[i][j].toString() + "   |");
                }
            }
        }
    }

    private void pintarFila(PrintWriter escribidor, int i) {
        int j, x;
        int celdaOrigen, celdaDestino;
        for (x = 0; x < 3; x++) {  // Cada celda la dividimos en 3 líneas
            for (j = 0; j < this.matriz[i].length; j++) {  // Columnas
                // Calculamos celdaOrigen y celdaDestino
                celdaOrigen = (Constantes.FILAS * i) + j;
                celdaDestino = celdaOrigen + 1;

                // Si estamos en la primera columna
                if (j == 0) {
                    pintarColumnaCero(escribidor, celdaOrigen, celdaDestino, i, j, x);
                } else {  // Si estamos en cualquier columna del medio
                    pintarRestoColumnas(escribidor, celdaOrigen, celdaDestino, i, j, x);
                }
            }
            // Ponemos el cursor en la siguiente línea
            escribidor.print("\n");
        }
    }

    public void pintarMatriz(PrintWriter escribidor) {
        for (int i = 0; i < this.matriz.length; i++) {  // Filas
            pintarLineaSuperior(escribidor, i);
            pintarFila(escribidor, i);
        }
        pintarLineaInferior(escribidor);
    }































    public int getTurnosNecesarios() {
        return TurnosNecesarios;
    }

    public void setTurnosNecesarios(int turnosNecesarios) {
        this.TurnosNecesarios = turnosNecesarios;
    }





}
