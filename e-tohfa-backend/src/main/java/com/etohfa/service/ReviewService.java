package com.etohfa.service;

import java.util.List;

import com.etohfa.entity.Product;
import com.etohfa.entity.Review;
import com.etohfa.entity.User;

public interface ReviewService {
	
	Review addReview(Review review);
	
	List<Review> fetchProductReviews(List<Product> products);

	List<Review> fetchSellerProductReview(User seller);
	
}
