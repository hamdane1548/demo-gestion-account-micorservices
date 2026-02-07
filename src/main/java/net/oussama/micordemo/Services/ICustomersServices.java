package net.oussama.micordemo.Services;

import net.oussama.micordemo.dtos.CustomersDetailsDto;

public interface ICustomersServices {
    CustomersDetailsDto getCustomers(String phone_number , String correlationId);
}
