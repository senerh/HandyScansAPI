package service;

import dao.LirescanDAO;
import dao.ScanDAO;

public class AbstractService {

    protected ScanDAO scanDAO;

    public AbstractService() {
        scanDAO = new LirescanDAO();
    }
}
