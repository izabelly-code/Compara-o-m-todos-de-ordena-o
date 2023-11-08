/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
public class Mavenproject1 {
public static void salvar(long [][] dados){

  // Crie um novo arquivo Excel (.xlsx)
  try (Workbook workbook = new XSSFWorkbook()) {

    for (int i = 0; i < 5; i++) {
      
      // Crie uma nova planilha
      Sheet sheet = workbook.createSheet("Planilha " + (i+1));
      
      // Crie uma linha na planilha  
      Row headerRow = sheet.createRow(0);

      // Crie células na primeira linha (cabeçalho)
      String[] headers = {"Bubble Sort", "Quick Sort", "Merge Sort"};
      
      for (int j = 0; j < headers.length; j++) {
        Cell cell = headerRow.createCell(j);
        cell.setCellValue(headers[j]);
      }
    
      
      int rowNum = 1;
      for (long[] row : dados) {
        Row dataRow = sheet.createRow(rowNum++);
        int colNum = 0;
        for (long field : row) {
          Cell cell = dataRow.createCell(colNum++);
         /* if (field instanceof String) {
            cell.setCellValue((String) field);
          } else if (field instanceof long) {*/
            cell.setCellValue((long) field);
          
        }
      }
    
    }
    
    // Salve o arquivo Excel
    try (FileOutputStream outputStream = new FileOutputStream("tudopronto.xlsx")) {
      workbook.write(outputStream);
    }

    System.out.println("Arquivo Excel criado com sucesso!");

  } catch (IOException e) {
    e.printStackTrace();
  }

}





    public static void main(String[] args) {
        Random rand = new Random();
        rand.setSeed(10);
            
        int[] registers50Bs = new int[10000];
        int[] registers50Qs = new int[10000];
        int[] registers50Ms = new int[10000];

        
        //mattizes ordenadas por tamanho 
        
        // colunas bubble sort,quick sort, heap sort
        //linhas tempo,iteração, trocas
        //matriz 50
        long [][] resultado50= new long[3][3];
        
        
        Ordenacao o=new Ordenacao();
        for(int j=0;j<5;j++){
            for (int i = 0; i < 10000; i++) {
              registers50Bs[i] = rand.nextInt();
              registers50Qs[i]= rand.nextInt();
              registers50Ms[i]= rand.nextInt();

            }

            long []temp=o.bubbleSort(registers50Bs, 10000);
            long startTime = System.nanoTime();
            int []tempQs=o.quicksort(registers50Qs,0,9999);
            long endTime = System.nanoTime();
            resultado50[0][1] += endTime - startTime;
            startTime = System.nanoTime();
            int []tempMs=o.mergeSort(registers50Ms,10000);
            endTime = System.nanoTime();
            resultado50[0][2] += endTime - startTime;

            for(int i=0;i<3;i++){
                resultado50[i][0]+=temp[i];

              }
            for(int i=0;i<2;i++){
               resultado50[i+1][1]+=tempQs[i];
               resultado50[i+1][2]+=tempMs[i];
              }
        }
        for(int i=0;i<3;i++){
          resultado50[i][0]=(resultado50[i][0]/5);
          resultado50[i][1]=(resultado50[i][1]/5);
          resultado50[i][2]=(resultado50[i][2]/5);

              }
        

       salvar(resultado50);
        }
}
