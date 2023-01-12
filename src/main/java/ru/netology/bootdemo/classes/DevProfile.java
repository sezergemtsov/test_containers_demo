package ru.netology.bootdemo.classes;

import ru.netology.bootdemo.interfaces.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
