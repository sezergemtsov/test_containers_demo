package ru.netology.bootdemo.classes;

import ru.netology.bootdemo.interfaces.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
