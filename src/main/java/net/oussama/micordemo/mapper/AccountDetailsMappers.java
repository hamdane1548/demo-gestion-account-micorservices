package net.oussama.micordemo.mapper;

import net.oussama.micordemo.dtos.CustomersDetailsDto;
import net.oussama.micordemo.dtos.CustomersDto;
import org.springframework.beans.BeanUtils;

public class AccountDetailsMappers {
    public static CustomersDetailsDto customertoAccountDetailsMappers(CustomersDto customerdto){
        CustomersDetailsDto customersDetailsDto = new  CustomersDetailsDto();
        BeanUtils.copyProperties(customerdto,customersDetailsDto);
        return customersDetailsDto;
    }
}
