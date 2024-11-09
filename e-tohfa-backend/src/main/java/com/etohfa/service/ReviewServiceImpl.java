package com.etohfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etohfa.dao.ReviewDao;
import com.etohfa.entity.Product;
import com.etohfa.entity.Review;
import com.etohfa.entity.User;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;

	@Override
	public Review addReview(Review review) {
		return reviewDao.save(review);
	}

	@Override
	public List<Review> fetchProductReviews(List<Product> products) {
		return reviewDao.findByProductIn(products);
	}

	@Override
	public List<Review> fetchSellerProductReview(User seller) {
		return reviewDao.findAllOrdersBySeller(seller);
	}

}
