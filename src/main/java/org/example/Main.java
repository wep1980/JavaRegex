package org.example;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        /*
        METACARACTERES
        .  Qualquer caractere
        \d Digitos   [0-9]
        \D Não e digito [^0-9]
        \s Espaços [ \t\n\x0B\f\r]
        \S Não e espaço [^\s]
        \w Letra      [a-zA-Z_0-9]
        \W Não e letra
         */

        String texto = "JaVa";
        String texto2 = "a";
        String numero = "4";
        String letrasOuNumeros = "y";
        String espaco = " ";
        String CEP = "20520-052";


        String padrao = "(?i)java"; // (?i) -> busca a palavra indepeendente de ser maiuscula ou minuscula
        String buscaQualquerCaractere = "."; // busca apenas uma ocorrencia
        String busca2QualquerCaracteres = ".."; // busca apenas 2 ocorrenciase assim sucetivamente, serve para os demais casos abaixo
        String buscaQualquerNumero = "\\d";
        String buscaNumerosOuLetras = "\\w";
        String espacos = "\\s";
        String padraoCEP = "\\d\\d\\d\\d\\d-\\d\\d\\d";
        String padraoMewlhoradoCEP = "\\d{5}-\\d{3}";


        boolean resultado = texto.matches(padrao);
        boolean resultado2 = texto2.matches(buscaQualquerCaractere);
        boolean resultado3 = numero.matches(buscaQualquerNumero);
        boolean resultado4 = letrasOuNumeros.matches(buscaNumerosOuLetras);
        boolean resultado5 = espaco.matches(espacos);
        boolean resultado6 = CEP.matches(padraoCEP);


        System.out.println(resultado);
        System.out.println(resultado2);
        System.out.println(resultado3);
        System.out.println(resultado4);
        System.out.println(resultado5);
        System.out.println(resultado6);


        /*
        QUANTIFICADORES
        X{n}       X, Exatamente n vezes
        X{n,}      X, Pelo ao menos n vezes
        X{n, m}    X, Pelo ao menos n mas não mais do que m vezes
        X?         X, 0 ou 1 vez
        X*         X, 0 ou + vezes
        X+         X, 1 ou + vezes
        */

        String doisDigitos = "21";
        String data = "25/03/1980";

        String padraoDoisDigitos = "\\d{2}";
        String zeroOuUmaVez = ".?"; // qualquer caractere entre 0 e 1 vez
        String zeroOuMaisVezes = ".*"; // qualquer caractere entre 0 ou mais vezes
        String UmaOuMaisVezes = ".+"; // qualquer caractere entre 1 ou mais vezes
        String padraoData = "\\d{2}/\\d{2}/\\d{4}";

        boolean resultado7 = doisDigitos.matches(padraoDoisDigitos);
        boolean resultado8 = espaco.matches(zeroOuUmaVez);
        boolean resultado9 = espaco.matches(zeroOuMaisVezes);
        boolean resultado10 = espaco.matches(UmaOuMaisVezes);
        boolean resultado11 = CEP.matches(padraoMewlhoradoCEP);
        boolean resultado12 = data.matches(padraoData);


        System.out.println(resultado7);
        System.out.println(resultado8);
        System.out.println(resultado9);
        System.out.println(resultado10);
        System.out.println(resultado11);
        System.out.println(resultado12);

        /**
         * METACARACTERES DE FRONTEIRA
         * inicia ou finaliza com determinado padrão
         * ^ inicia
         * $ finaliza
         * | ou
         */

        String palavaraQualquer = "Pier21";
        String frase = "tem java aqui";
        String simOuNao = "sim";


        String verificaSeInicia = "^Pier.*"; // começa com Pier e termine com qualquer caractere 0 ou mais vezes
        String verificaSeFinaliza = ".*21$"; // começa com qualquer caractere e no final terminae com numero 21
        String verificaSeExisteAPalavraJava = ".*java.*"; // pode iniciar e terminar com qq quantidade de caracteres
        String verificaSeIniciaComTemEFinalizaComAqui = "^tem.*aqui$";
        String verificaSeExisteSimOuNao = "sim|nao";

        boolean resultado13 = palavaraQualquer.matches(verificaSeInicia);
        boolean resultado14 = palavaraQualquer.matches(verificaSeFinaliza);
        boolean resultado15 = frase.matches(verificaSeExisteAPalavraJava);
        boolean resultado16 = frase.matches(verificaSeIniciaComTemEFinalizaComAqui);
        boolean resultado17 = simOuNao.matches(verificaSeExisteSimOuNao);

        System.out.println(resultado13);
        System.out.println(resultado14);
        System.out.println(resultado15);
        System.out.println(resultado16);
        System.out.println(resultado17);

        /**
         * AGRUPADORES
         * [...]           Agrupamento
         * [A-Z]           Alcance
         * [a-e] [i-u]     Uniao
         * [a-z$$ [aeiou]] Interseção
         * [^abc]          Exceção
         * [a-z&& [^m-p]]  Subtração
         * \x              Fuga literal
         */

        String qualquerLetra = "x";
        String qualquerNumero = "3";
        String palavra = "true";
        String palavraOlho = "olho";
        String email = "wepbike@gmail.com";


        String procurarQualquerLetra = "[a-z]";
        String procurarQualquerNumero = "[0-9]";
        String verificaSeIniciaComLetraMinusculaOuMaiuscula = "[tT]rue";
        String verificaSeIniciaComLetraMinusculaOuMaiusculaPalavras = "[tT]rue|[Yy]es]";
        String verificaPrimewiroNomeLetraMaiuscula = "[A-Z][a-zA-Z]*"; // primeira letra maiuscula e o restante pode ser maiuscula ou minuscula
        String naoPodeComecarComABCeTerminarComLho = "[^abc]lho";
        String verificarPalavraCrauOuCreu = "cr[ae]u";
        String padraoValidacaoEmail = "\\w+@\\w+\\. \\w{2,3}"; // comaçando com letras ou numeros ocorrendom 1 ou mais vzs




        String padraoValidacaoEmailCompleta = "/^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+\\.([a-z]+)?$/i";

        boolean resultado18 = qualquerLetra.matches(procurarQualquerLetra);
        boolean resultado19 = palavra.matches(verificaSeIniciaComLetraMinusculaOuMaiuscula);
        boolean resultado20 = palavraOlho.matches(naoPodeComecarComABCeTerminarComLho);
        boolean resultado21 = email.matches(padraoValidacaoEmailCompleta);

        System.out.println(resultado18);
        System.out.println(resultado19);
        System.out.println(resultado20);
        System.out.println(resultado21);

        String fraseGrande = "Qual é o Doce mais doCe que o doce?";
        Matcher matcher = Pattern.compile("(?i)doce").matcher(fraseGrande); // procurando todas as ocorrencias da palavra doce independente de letras minusculas ou maiusculas
        while (matcher.find()) {
            System.out.println(matcher.group()); // imprimindo todas as palavras doce encontradas
        }

            /**
             * SUBSTITUIÇÕES
             */
        String r = fraseGrande.replaceAll("(?i)doce", "DOCINHO");
        System.out.println(r);

        String rato = "O rato roeu a roupa do rei de roma";
        String r1 = rato.replaceAll("r[aeiou]", "xx");
        System.out.println(r1);

        String tabular = "Tabular este texto";
        String r2 = rato.replaceAll("\\s", "\t"); // substituindo todos os espaços por tabulação
        System.out.println(r2);


        String url = "www.xti.com.br/clientes-2011.html";
        // http://www.xti.com.br/2011/clientes.jsp//

        String padraoNovaUrl = "www.xti.com.br/\\w{2,}-\\d{4}.html"; // validando o padrao
        boolean resposta = url.matches(padraoNovaUrl);
        System.out.println(resposta);

        padraoNovaUrl = "(www.xti.com.br)/(\\w{2,})-(\\d{4}).html"; // criando variaveis dentro do padrão

        String variaveis = "http://$1/$3/$2.jsp"; // capiturando as variaveis

        String resultadoFinal = url.replaceAll(padraoNovaUrl, variaveis);
        System.out.println("Url antes da mudança " + url);
        System.out.println("Url apos a mudança " + resultadoFinal);


    }
}