package com.saru.service;

import com.saru.model.Screen;

import java.util.List;
import java.util.Optional;

public interface ScreenService {
    Screen addScreen(Screen screen);

    List<Screen> getAllScreen();

    Optional<Screen> getScreenById(Long id);

    void deleteScreen(Long id);
}
