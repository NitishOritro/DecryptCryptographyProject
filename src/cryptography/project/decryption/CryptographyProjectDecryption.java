/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography.project.decryption;

import com.letter.cryptography.LetterInNumber;

/**
 *
 * @author ahsan
 */
public class CryptographyProjectDecryption 
{
    public static void main(String[] args) 
    {
        String cipherText = "EESMSIMODT PTQLLLJZR UH YGZPTH 12#@&";
        //String plaintext = "";
        int lengthOfPlaintext = cipherText.length();
        System.out.println("Length of plaintext is "+lengthOfPlaintext);
        LetterInNumber letterInNumberCheck = new LetterInNumber(cipherText.charAt(1));
        System.out.println("Character number conversion is "+letterInNumberCheck.getNumber());
        
        LetterInNumber numberInLetterCheck = new LetterInNumber(26);
        System.out.println("Number conversion is in Character "+numberInLetterCheck.getLetter());
        
        
        int i,j,k,row=16,column=0;
        
        if(cipherText.length() % 16 == 0) 
        {
            column = cipherText.length() / 16;
        }
        else 
        {
            column = cipherText.length() / 16 + 1;
        }
        
        
        char ciphertextRotor [][] = new char [row][column];
        int pointer = 0;
        for(i=0;i<column;i++)
        {
            for(j=0;j<row;j++)
            {
                if(pointer != cipherText.length())
                {
                    ciphertextRotor [j][i] = cipherText.charAt(pointer);
                    pointer++;
                }
                else 
                {
                    break;
                }
            }
            //System.out.println(pointer);
        }
        
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                //ciphertextRotor [row][column] = plaintext.charAt(j);
                 System.out.print(" ("+i+" "+j+")"+ciphertextRotor [i][j]+"   ");
            }
            System.out.println();
        }
        
        
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                if(Character.isLetter(ciphertextRotor[i][j]) && ciphertextRotor[i][j] != ' ')
                {
                    LetterInNumber cipherInNumber = new LetterInNumber(ciphertextRotor[i][j]);
                    int cipherValue =  (cipherInNumber.getNumber() - i) % 26;       //(c-rowNum) mod 26
                    
                    if(cipherValue < 0)
                    {
                        cipherValue = cipherValue + 26;
                    }
                    
                    if(cipherValue == 0)
                    {
                        cipherValue = 26;
                    }

                    LetterInNumber cipherInLetter = new LetterInNumber(cipherValue);
                    ciphertextRotor[i][j] = cipherInLetter.getLetter();
                }
            }
        }
        
        
        System.out.println();System.out.println();
        for(i=0;i<row;i++)
        {
            for(j=0;j<column;j++)
            {
                //ciphertextRotor [row][column] = plaintext.charAt(j);
                 System.out.print(" ("+i+" "+j+")"+ciphertextRotor [i][j]+"   ");
            }
            System.out.println();
        }
        
        
        String CipherTextToPlaintext = "";
        String generatePlaintext = "";
        for(i=0;i<column;i++)
        {
            for(j=0;j<row;j++)
            {
                CipherTextToPlaintext = CipherTextToPlaintext + ciphertextRotor [j][i];
            }
        }
        
        System.out.println("Generate Plaintext is : " +CipherTextToPlaintext);
        
        
        for(i=0;i<CipherTextToPlaintext.length();i++)
        {
            if(Character.isLetter(CipherTextToPlaintext.charAt(i)) && CipherTextToPlaintext.charAt(i) != ' ')
            {
                LetterInNumber letterInNumber = new LetterInNumber(CipherTextToPlaintext.charAt(i));
                int cipherValue =  (letterInNumber.getNumber() - 3) % 26;       //(p+n) mod 26
                
                if(cipherValue == 0)
                {
                    cipherValue = 26;
                }
                if(cipherValue < 0)
                {
                    cipherValue = cipherValue + 26;
                }
                    
                LetterInNumber numberInLetter = new LetterInNumber(cipherValue);
                
                char cipherCharacter = numberInLetter.getLetter();
                generatePlaintext = generatePlaintext + cipherCharacter;
            }
            else if(CipherTextToPlaintext.charAt(i) != ' ' || Character.isWhitespace(CipherTextToPlaintext.charAt(i)))
            {
                generatePlaintext = generatePlaintext + CipherTextToPlaintext.charAt(i);
            }
        }
        System.out.println("\nGenerate CipherText is : " +generatePlaintext);
        

    }    
}
