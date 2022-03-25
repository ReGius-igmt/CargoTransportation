package ru.regiuss.client.core;

import ru.regiuss.client.viewmodel.UserVM;

public class ViewModelFactory {
    private final ModelFactory mf;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public UserVM getUserVM() {
        return new UserVM(mf.getUserDao());
    }
}
