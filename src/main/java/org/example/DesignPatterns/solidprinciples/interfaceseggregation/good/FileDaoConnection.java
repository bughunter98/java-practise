package org.example.DesignPatterns.solidprinciples.interfaceseggregation.good;

//Here dont need to bother about db part.

public class FileDaoConnection implements DaoInterface,FileInterface{
    @Override
    public void createRecord() {

    }

    @Override
    public void deleteRecord() {

    }

    @Override
    public void openFile() {

    }
}
