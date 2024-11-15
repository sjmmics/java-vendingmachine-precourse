package vendingmachine.service;

import vendingmachine.repository.VMRepository;

public class VMService {

    private final VMRepository repository;

    public VMService(VMRepository repository) {
        this.repository = repository;
    }

}
