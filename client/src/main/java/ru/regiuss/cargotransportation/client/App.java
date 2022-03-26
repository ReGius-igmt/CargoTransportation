package ru.regiuss.cargotransportation.client;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.regiuss.cargotransportation.client.core.ModelFactory;
import ru.regiuss.cargotransportation.client.core.ViewHandler;
import ru.regiuss.cargotransportation.client.core.ViewModelFactory;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        vh.init();
    }
}
