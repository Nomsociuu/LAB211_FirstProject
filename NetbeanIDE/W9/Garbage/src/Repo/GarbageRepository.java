package repo;

import DataAccess.GarbageDao;
import model.Truck;

public class GarbageRepository implements IGarbageRepository {

    @Override
    public void calculateCost(Truck truck) {
        GarbageDao.Instance().calculateCost(truck);
    }

}
