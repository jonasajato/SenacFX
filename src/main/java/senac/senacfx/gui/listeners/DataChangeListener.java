package senac.senacfx.gui.listeners;

import senac.senacfx.model.services.FabricService;

public interface DataChangeListener {

    void onDataChanged();

    void setFabricService(FabricService fabricService);
}
