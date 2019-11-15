package sudakova.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudakova.onlineshop.dto.request.WishListRequest;
import sudakova.onlineshop.entity.User;
import sudakova.onlineshop.entity.WishList;
import sudakova.onlineshop.repository.ProductRepository;
import sudakova.onlineshop.repository.UserRepository;
import sudakova.onlineshop.repository.WishListRepository;

@Service
public class WishListService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WishListRepository wishListRepository;


    public boolean addToWishList(WishListRequest wishListRequest) {
        User user = userRepository.getOne(wishListRequest.getUserId());
        if (user.getWishList() == null) {
            WishList wishList = new WishList();
            wishList.setUser(user);
            user.setWishList(wishListRepository.save(wishList));

        }
        user.getWishList().getProduct().add(productRepository.getOne(wishListRequest.getProductId()));
        userRepository.save(user);
        wishListRepository.save(user.getWishList());
        return true;
    }

    public boolean removeFromWishList(WishListRequest wishListRequest) {
        User user = userRepository.getOne(wishListRequest.getUserId());
        if (user.getWishList() == null) {
            return false;
        }
        user.getWishList().getProduct().remove(productRepository.getOne(wishListRequest.getProductId()));
        userRepository.save(user);
        wishListRepository.save(user.getWishList());
        return true;
    }

}
