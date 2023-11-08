package com.mycompany.mavenproject1;
public class Ordenacao {
    public Ordenacao(){}
    
    //TODO trocar o retorno para long []
    public long [] bubbleSort(int [] recebido,int tamanho){
    //0-tempo 1-iteracao 2-trocas
     long [] total= {0,0,0};
 
        long startTime = System.nanoTime();
        int temp = 0; 
        for(int i=0; i < tamanho; i++){
          for(int j=1; j < (tamanho-i); j++){
            total[1]++;
            if(recebido[j-1] > recebido[j]){
               //trocar elementos
               temp = recebido[j-1];
               recebido[j-1] = recebido[j];
               recebido[j] = temp;
               total[2]++;
            }
          }
        }
        long endTime = System.nanoTime();

        total[0] += endTime - startTime;
    
        
        
    return total;
    }
 int []dados=new int[2];
 int []dadosMs=new int[2];
      //0-iteracao 1-trocas
  public int[] quicksort(int[] array, int inicio, int fim){
  dados[0]=0;
  dados[1]=0;
  recquicksort(array,inicio,fim);
  return dados;
  }
  public void recquicksort(int[] array, int inicio, int fim) {
    if (inicio >= fim) {// o array está ordenado
        return;}
    else {
      int pivo = particiona(array, inicio, fim);
        //aqui eu ordeno a metade que falta
      recquicksort(array, inicio, pivo);
      //aqui eu ordeno a outra metade que falta

      recquicksort(array, pivo + 1, fim);
    }
    
  }
  
  private int particiona(int[] array, int inicio, int fim) {
    int pivot = array[inicio];
    //para poder analisar todos os valores
    int i = inicio - 1;
    int j = fim + 1;
    
    while (true) {
        dados[0]++;
        //incrementa até ser maior que o pivo, estrutura de andar e comparar
      do {
        i++;
      } while(array[i] < pivot);
      //decrementa até ser menor que o pivo
      do {
        j--;
      } while(array[j] > pivot);
      //aqui quer dizer que já percorreu todo o lado
      if (i >= j) {
        return j;
      }
      //troca as posições 
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      dados[1]++;    
    }
  }
 public int [] mergeSort(int [] desordenado,int size){
     int [] workSpace= new int[size];
     dadosMs[0]=0;
     dadosMs[1]=0;

     recMergeSort(workSpace,0,size-1,desordenado);
     return dadosMs;
     

 }
private void recMergeSort (int[] workSpace, int limiteInferior,int limiteSuperior,int []desordenado){
       
    if (limiteInferior == limiteSuperior)
       return;
    else
    {
        int medio =(limiteInferior + limiteSuperior) / 2;
        //vai abrindo chamados onde cada função tem a média decrementada até zero
        //ordenar metade , a ideia é ir picando em partes menores
        recMergeSort (workSpace, limiteInferior, medio,desordenado); 
        //ordenar outra metade
        recMergeSort (workSpace, medio+1, limiteSuperior,desordenado);
        //menor pedaço vai vir para cá 
        merge(workSpace, limiteInferior, medio+1, limiteSuperior,desordenado);
    }
}
public void merge(int[] workSpace, int lowPtr, int highPtr, int limiteSuperior, int []desordenado){

int j=0;
int limiteInferior = lowPtr;

int medio=highPtr-1;

int n =limiteSuperior-limiteInferior+1;

while(lowPtr <= medio && highPtr <= limiteSuperior) {
    //jogar o menor para o workspace
    if( desordenado[lowPtr] < desordenado[highPtr]){
        workSpace[j++] = desordenado[lowPtr++];

    }

    else {
            workSpace[j++] = desordenado[highPtr++];
            }    
    dadosMs[0]++;
    dadosMs[1]++;

}   
while(lowPtr <= medio) {
    workSpace[j++]=desordenado[lowPtr++];
    dadosMs[0]++;
}

while (highPtr <= limiteSuperior){ 
    workSpace [j++] = desordenado[highPtr++];
    dadosMs[0]++;}

for(j=0; j<n; j++) {
    desordenado[limiteInferior+j]= workSpace[j];} // fim da mesclagem()
    dadosMs[0]++;

}

}
