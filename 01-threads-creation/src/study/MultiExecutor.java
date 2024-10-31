/*
 * Copyright (c) 2024. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

package study;

import java.util.List;

public class MultiExecutor {
    private List<Runnable> tasks;

    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void executeAll() {
        this.tasks.stream()
                  .map(Thread::new)
                  .forEach(Thread::start);
    }
}
