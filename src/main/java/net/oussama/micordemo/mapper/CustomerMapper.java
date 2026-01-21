package net.oussama.micordemo.mapper;

import net.oussama.micordemo.dtos.CustomersDto;
import net.oussama.micordemo.entites.Customers;

public class CustomerMapper {
    public static CustomersDto maptoCustomerDto(Customers customers) {
        CustomersDto customersDto = new CustomersDto();
        customersDto.setAddress(customers.getAddress());
        customersDto.setName(customers.getName());
        customersDto.setEmail(customers.getEmail());
        customersDto.setPhone(customers.getPhone());
        return customersDto;
    }
    public static Customers maptoCustomers(CustomersDto customersDto) {
        Customers customers = new Customers();
        customers.setAddress(customersDto.getAddress());
        customers.setName(customersDto.getName());
        customers.setEmail(customersDto.getEmail());
        customers.setPhone(customersDto.getPhone());
        return customers;
    }
}
