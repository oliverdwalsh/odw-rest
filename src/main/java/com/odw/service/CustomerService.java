package com.odw.service;

import java.util.List;

public interface CustomerService {
    List<String> getSubscriptionsForCustomer(String customerId);
}
