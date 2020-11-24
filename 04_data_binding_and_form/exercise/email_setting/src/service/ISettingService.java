package service;

import model.Setting;

import java.util.List;

public interface ISettingService {
    Setting saveSetting(Setting setting);
    public List<String> getLanguageList();
    public List<Integer> getPageList();
}
