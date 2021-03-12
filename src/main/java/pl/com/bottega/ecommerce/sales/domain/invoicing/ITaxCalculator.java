package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface ITaxCalculator {
    Tax calculate(RequestItem item);
}
