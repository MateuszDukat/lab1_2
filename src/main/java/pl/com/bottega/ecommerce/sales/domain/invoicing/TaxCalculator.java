package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class TaxCalculator implements ITaxCalculator{

    @Override
    public Tax calculate(RequestItem item) {
        Money net = item.getTotalCost();
        BigDecimal ratio = null;
        String desc = null;

        switch(item.getProductData().getType()){
            case DRUG:
                ratio = BigDecimal.valueOf(0.05);
                desc = "5% (D)";
                break;
            case FOOD:
                ratio = BigDecimal.valueOf(0.07);
                desc = "7% (F)";
                break;
            case STANDARD:
                ratio = BigDecimal.valueOf(0.23);
                desc = "23%";
                break;

            default:
                throw new IllegalArgumentException("couldn't find: " +item.getProductData().getType()+" type");
        }

        Money taxValue = net.multiplyBy(ratio);

        return new Tax(taxValue,desc);


    }
}
