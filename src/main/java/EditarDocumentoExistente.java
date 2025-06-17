import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EditarDocumentoExistente  {

    public static void main(String[] ars){
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        String currentDateTime = dataHoraAtual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        String arquivoEntrada = "./lista_autorizacao.docx";
        String arquivoSaida = "Autorizacao_Preenchida_" + currentDateTime + ".docx";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do proprietário: ");
        String nomeProprietario = scanner.nextLine();

        try (FileInputStream fis = new FileInputStream(arquivoEntrada);
             XWPFDocument documento = new XWPFDocument(fis)) {

            substituirTexto(documento, "_______________________________", nomeProprietario);

            try (FileOutputStream fos = new FileOutputStream(arquivoSaida)) {
                documento.write(fos);
                System.out.println("Documennto editado com sucesso e salvo como '" + arquivoSaida + ".docx'");
            }


        scanner.close();
        } catch (IOException e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void substituirTexto(XWPFDocument doc, String textoAntigo, String textoNovo){
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                StringBuilder textoDoParagrafo = new StringBuilder();
                for (XWPFRun r  : runs) {
                    textoDoParagrafo.append(r.getText(0));
                }

                if (textoDoParagrafo.toString().contains(textoAntigo)) {
                    String textoAtualizado = textoDoParagrafo.toString().replace(textoAntigo, textoNovo);

                    for (int i = runs.size() -1; i>=0; i--) {
                        p.removeRun(i);
                    }
                    p.createRun().setText(textoAtualizado);
                }
            }
        }

    }
}

