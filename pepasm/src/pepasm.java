import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class pepasm {
    public static void main(String[] args){

        Map<String, String> instructionsWithoutState = new HashMap<>();
        instructionsWithoutState.put("STOP","00");
        instructionsWithoutState.put("ASLA","0A");
        instructionsWithoutState.put("ASRA","0C");

        Map<String, String> immediateInstructions = new HashMap<>();
        immediateInstructions.put("LDBA","D0");
        immediateInstructions.put("LDWA","C0");
        immediateInstructions.put("ANDA","80");
        immediateInstructions.put("CPBA","B0");
        immediateInstructions.put("ADDA","60");
        immediateInstructions.put("SUBA","70");
        immediateInstructions.put("BRNE","1A");

        Map<String, String> directInstructions = new HashMap<>();
        directInstructions.put("LDBA","D1");
        directInstructions.put("STBA","F1");
        directInstructions.put("LDWA","C1");
        directInstructions.put("STWA","E1");
        directInstructions.put("ANDA","81");
        directInstructions.put("CPBA","B1");
        directInstructions.put("ADDA","61");
        directInstructions.put("SUBA","71");

        String inputFile = args[0];
        try {
            Scanner scan = new Scanner(new File(inputFile));
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] lineParts = line.split(" ");
                if(lineParts.length >= 3){
                    for(String part: lineParts){
                        if(part.equals("i")){
                            boolean operandFound = false;
                            for(String operand: lineParts){
                                if(operandFound){
                                    if(operand.length() ==  7){
                                        System.out.print(operand.substring(2,4) + " ");
                                        System.out.print(operand.substring(4,6) + " ");
                                    }
                                    else if (operand.length() ==  6){
                                        System.out.print("0" + operand.substring(2,3) + " ");
                                        System.out.print(operand.substring(3,5) + " ");
                                    }
                                    else if(operand.length() ==  5){
                                        System.out.print("00 ");
                                        System.out.print(operand.substring(2,4) + " ");
                                    }
                                    else{
                                        System.out.print("00 ");
                                        System.out.print("0" + operand.substring(2,3) + " ");
                                    }
                                    break;
                                }
                                for(String key: immediateInstructions.keySet()){
                                    if(operand.equals(key)){
                                        System.out.print(immediateInstructions.get(key)+ " ");
                                        operandFound = true;
                                        break;
                                    }
                                }
                                if (operand.equals("BRNE")){
                                    break;
                                }
                            }
                        }
                        if(part.equals("d")) {
                            boolean operandFound = false;
                            for(String operand: lineParts){
                                if(operandFound){
                                    if(operand.length() ==  7){
                                        System.out.print(operand.substring(2,4) + " ");
                                        System.out.print(operand.substring(4,6) + " ");
                                    }
                                    else if (operand.length() ==  6){
                                        System.out.print("0" + operand.substring(2,3) + " ");
                                        System.out.print(operand.substring(3,5) + " ");
                                    }
                                    else if(operand.length() ==  5){
                                        System.out.print("00 ");
                                        System.out.print(operand.substring(2,4) + " ");
                                    }
                                    else{
                                        System.out.print("00 ");
                                        System.out.print("0" + operand.substring(2,3) + " ");
                                    }
                                    break;
                                }
                                for(String key: directInstructions.keySet()){
                                    if(operand.equals(key)){
                                        System.out.print(directInstructions.get(key)+ " ");
                                        operandFound = true;
                                        break;
                                    }
                                }
                                if (operand.equals("BRNE")){
                                    break;
                                }
                            }
                        }
                    }
                }
                else{
                    for(String key: instructionsWithoutState.keySet()){
                        if(lineParts[0].equals(key)){
                            System.out.print(instructionsWithoutState.get(key)+ " ");
                            break;
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
