import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws IOException {

        // 1) Lendo o arquivo de entrada
        BufferedReader reader;

        ArrayList Dishes = new ArrayList<String>();
        ArrayList Prices = new ArrayList<Double>();
        int i = 0;
        int j = 0;
        int Ndishes = 0, People = 0;

        try {
            reader = new BufferedReader(new FileReader("order1.txt"));
            String line = reader.readLine();

            while (line != null) {
                //System.out.println(line);
                if (i == 0) {
                    Ndishes = Integer.parseInt(line);
                    i = i + 1;
                } else if (i == 1) {
                    People = Integer.parseInt(line);
                    i = i + 1;
                } else if (i > 1) {
                    String[] tokens = line.split(" ");
                    Dishes.add(tokens[0]);
                    Prices.add(tokens[1]);
                    i = i + 1;
                }
                // read next line
                line = reader.readLine();
            } // while
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    // 2) Organizando os dados
        // dishes counter
        int counter = 0;
        double value = 0.0;
        int flag = 1;

        ArrayList DiffDishes = new ArrayList<String>();
        ArrayList DishesCounter = new ArrayList<String>();
        ArrayList SumValues = new ArrayList<Double>();

        for (i = 0;i < Dishes.size();i++){
            for (j = 0;j < Dishes.size();j++){

                if (Dishes.get(i).equals(Dishes.get(j)) && (j<i)){
                    break;
                }

                if (Dishes.get(i).equals(Dishes.get(j)) && (j>=i)){
                    counter = counter + 1;
                    value = value + Double.parseDouble(Prices.get(j).toString());
                    flag = 1;
                }
            }

            if (flag == 1){
                DiffDishes.add(Dishes.get(i));
                DishesCounter.add(counter);
                SumValues.add(value);
                flag = 0;
            }

            j = 0;
            counter = 0;
            value = 0; // reinicializa contadores
        } // for


        // sort
        ArrayList<Double> SumValuesStore = new ArrayList<Double> (SumValues);
        Collections.sort(SumValuesStore,Collections.reverseOrder());
        int[] indexes = new int[SumValues.size()];

        for (int n = 0;n < SumValues.size(); n++){
            indexes[n] = SumValues.indexOf(SumValuesStore.get(n));
        }


    // 3) Criando arquivo output com resultados

        // Criando o arquivo order2.txt

        File myObj = new File("orders.txt");
        myObj.createNewFile();

        try {
            FileWriter myWriter = new FileWriter("orders.txt");

            // Escrevendo resposta no order2.txt
            for (i=0;i<SumValues.size();i++) {
                myWriter.write(DiffDishes.get(indexes[i]) + " " + " | " + DishesCounter.get(indexes[i]) + "x | " +
                        SumValues.get(indexes[i]) + "\n");
            }

            myWriter.write("\n");
            myWriter.write("====================");
            myWriter.write("\n");

            // Soma
            double sum = 0;
            for (i=0;i<SumValues.size();i++){
                sum = sum + Double.parseDouble(SumValues.get(i).toString());
            }

            myWriter.write("Total: $" + sum);
            myWriter.write("\n");
            myWriter.write("Total per person: $" + sum/People);

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}