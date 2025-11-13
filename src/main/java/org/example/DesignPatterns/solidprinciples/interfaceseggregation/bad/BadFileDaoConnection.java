package org.example.DesignPatterns.solidprinciples.interfaceseggregation.bad;

public class BadFileDaoConnection implements BadDAOInterface {
    @Override
    public void openConnection() {
        //We can't open connection in file system
    }

    @Override
    public void createRecord() {

    }

    @Override
    public void openFile() {

    }

    @Override
    public void deleteRecord() {

    }
}
