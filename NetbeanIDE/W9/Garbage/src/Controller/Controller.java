package Controller;

import Common.Validate;
import View.GarbageView;
import model.Truck;
import repo.GarbageRepository;

public class Controller {

    Validate valid;
    GarbageView view;
    GarbageRepository repo;
    Truck truck;

    public Controller() {
        valid = new Validate();
        repo = new GarbageRepository();
        truck = new Truck();
        view = new GarbageView();
    }

    public void run() {
        view.GarbageMenu();
        repo.calculateCost(truck);
    }
}
