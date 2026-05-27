package ApiCarteiraDigital.demo.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ServiceTaxasDeJuros  {

   public BigDecimal Baixa(BigDecimal ValorDeEntrada,BigDecimal valor, int parcelas){
       BigDecimal valorTotal = valor.subtract(ValorDeEntrada);

         BigDecimal x = new BigDecimal("0.02");

         BigDecimal parcela = valorTotal.divide(BigDecimal.valueOf(parcelas),2, RoundingMode.CEILING);

         BigDecimal taxa = valor.multiply(x);

        return parcela.add(taxa);
   }

   public BigDecimal Alta(BigDecimal ValorDeEntrada, BigDecimal valor, int parcelas){
       BigDecimal valorTotal = valor.subtract(ValorDeEntrada);

       BigDecimal x = new BigDecimal("0.06");

       BigDecimal parcela = valorTotal.divide(BigDecimal.valueOf(parcelas),2, RoundingMode.CEILING);

       BigDecimal taxa = valor.multiply(x);

       return parcela.add(taxa);
   }

}
