package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name){
       switch (name){
           case "ann":
               return this.annsTasks;
           case "bob":
               return this.bobsTasks;
           case "carol":
               return this.carolsTasks;
           case "all":
               return getUnion(bobsTasks, annsTasks, carolsTasks);
       }
       return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task>... sets){
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> set : sets) {
            unionSet.addAll(set);
        }
        return unionSet;
    }
       public Set<Task> getIntersection(Set<Task> task1, Set<Task> task2){
           Set<Task> intersection = new HashSet<>(task1);
           intersection.retainAll(task2);
           return intersection;
       }
       public Set<Task> getDifferences(Set<Task> task1, Set<Task> task2){
           Set<Task> difference = new HashSet<>(task1);
           difference.removeAll(task2);
           return difference;
       }
}
