package sudakova.onlineshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudakova.onlineshop.dto.request.DiscountRequest;
import sudakova.onlineshop.dto.response.DiscountResponse;
import sudakova.onlineshop.entity.Discount;
import sudakova.onlineshop.exception.WrongInputDataException;
import sudakova.onlineshop.repository.DiscountRepository;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;


    public DiscountResponse getById(Long id) {
        return new DiscountResponse(getEntityObjectById(id));
    }

    public DiscountResponse save(DiscountRequest discountRequest) {
        Discount discount = new Discount();
        discount.setName(discountRequest.getName());
        return new DiscountResponse(discountRepository.save(discount));
    }


    public void update(Long id, DiscountRequest discountRequest) {
        Discount discount = getEntityObjectById(id);
        discount.setName(discountRequest.getName());
        discountRepository.save(discount);
    }

    public boolean delete(Long id) {
        Discount discount = getEntityObjectById(id);
        if (discount.getUser().isEmpty()) {
            discountRepository.delete(discount);
            return true;
        } else {
            throw new WrongInputDataException("Discount with id: " + id + " has users.");
        }
    }

    private Discount getEntityObjectById(Long id) {
        return discountRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("Discount with id: " + id + " not found."));
    }
}
