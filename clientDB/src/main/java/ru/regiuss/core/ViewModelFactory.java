package ru.regiuss.core;

import ru.regiuss.viewmodel.UserVM;

public class ViewModelFactory {
    private final ModelFactory mf;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public UserVM getUserVM() {
        return new UserVM(mf.getUserDao());
    }
}
