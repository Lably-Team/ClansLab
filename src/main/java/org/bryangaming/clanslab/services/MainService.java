package org.bryangaming.clanslab.services;
import org.bryangaming.clanslab.ClansLab;
import org.bryangaming.clanslab.loader.FileLoader;
import org.bryangaming.clanslab.utils.TextUtils;

public class MainService implements Service{

    private final ClansLab clansLab;

    private FileLoader fileLoader;

    private LoaderService loaderService;
    private ManagerService managerService;

    private TextUtils textUtils;

    public MainService(ClansLab clansLab) {
        this.clansLab = clansLab;
        setup();
    }

    @Override
    public void setup(){
        fileLoader = new FileLoader(this);

        managerService = new ManagerService(this);
        loaderService = new LoaderService(this);

        textUtils = new TextUtils(this);
    }

    public ClansLab getPlugin(){
        return clansLab;
    }

    public LoaderService getLoaderService() {
        return loaderService;
    }

    public ManagerService getManagerService() {
        return managerService;
    }

    public TextUtils getStringUtils(){
        return textUtils;
    }

    public FileLoader getFiles() {
        return fileLoader;
    }
}
