/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.letter.cryptography;
/**
 *
 * @author Nitish Ranjan Bhownmik
 */
public class LetterInNumber 
{
    char letter;
    int number;
    
    public LetterInNumber(char letter) 
    {
        //this.letter = letter;
        //this.number = number;
        int letterAsciiValue = (int) letter;
        letterAsciiValue = letterAsciiValue - 64;
        //System.out.println(letterAsciiValue);
        this.number = letterAsciiValue;
    }
    
    public LetterInNumber(int number) 
    {
        //this.letter = letter;
        //this.number = number;
        int letterAsciiValue = number + 64;
        char asciiValueToCharacter = (char) letterAsciiValue;
        //System.out.println(asciiValueToCharacter);
        this.letter = asciiValueToCharacter;
    }
    
    
    
    public char getLetter() 
    {
        return letter;
    }

    public void setLetter(char letter) 
    {
        this.letter = letter;
    }

    public int getNumber() 
    {
        return number;
    }

    public void setNumber(int number) 
    {
        this.number = number;
    }

}
