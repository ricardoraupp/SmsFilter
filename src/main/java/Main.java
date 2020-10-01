import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        // your directory
        File f = new File("d:\\lojas");
        File[] matchingFiles = f.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("GESTAO_ESCALA_SMS_") && name.endsWith(".txt");
            }
        });

        String line = "";
        for(int i=0; i < matchingFiles.length; i++){
            try {
                FileWriter newFile = new FileWriter("d:\\lojas\\enviar\\"+matchingFiles[i].getName());
                Scanner scan = new Scanner(matchingFiles[i]);
                List<Sms> lista = new ArrayList<Sms>();
                while(scan.hasNextLine()){
                    line = scan.nextLine();
                    if(!line.startsWith("#")){
                        if(!line.equalsIgnoreCase("")){
                            lista.add(splitLine(line));
                        }else{
                            newFile.write(line+"\n");
                        }
                    }else{
                        newFile.write(line+"\n");
                    }

                }

                List<Sms> distinctElements = lista.stream()
                        .filter( distinctByKey(s -> s.getLogonID()) )
                        .collect( Collectors.toList() );
                distinctElements.stream().forEach(s -> {
                    try {
                        newFile.write(s.toString()+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                scan.close();
                newFile.flush();
                newFile.close();
                move(matchingFiles[i]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static Sms splitLine(String line){
        String[] result = line.split("\\|",-1);
        Sms sms = new Sms();
        sms.setMsisdn(result[0]);
        sms.setMessage_id(result[1]);
        sms.setRe(result[2]);
        sms.setLoja(result[3]);
        sms.setSistema(result[4]);
        sms.setDate(result[5]);
        sms.setTz(result[6]);
        sms.setCustID(result[7]);
        sms.setMuID(result[8]);
        sms.setTvID(result[9]);
        sms.setAcdID(result[10]);
        sms.setLogonID(result[11]);
        sms.setSsn(result[12]);
        sms.setAgentName(result[13]);
        sms.setModify(result[14]);
        sms.setException(result[15]);
        sms.setMinutes(result[16]);
        sms.setExternalID(result[17]);
        return sms;
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    static void move(File file) throws IOException
    {
        String path = "d:\\lojas\\original\\"+file.getName();
        Path temp = Files.move
                (Paths.get(file.getAbsolutePath()),
                        Paths.get(path));

        if(temp != null)
        {
            System.out.println("File renamed and moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
        String path2 = "d:\\lojas\\original\\"+file.getName()+".rpt";
        try{
            Path temp2 = Files.move
                    (Paths.get(file.getAbsolutePath()+".rpt"),
                            Paths.get(path2));
            if(temp2 != null)
            {
                System.out.println("RPT File renamed and moved successfully");
            }
            else
            {
                System.out.println("RPT Failed to move the file");
            }
        }catch(Exception e){
            System.out.println("RPT Failed to move the file");
        }


    }
}
