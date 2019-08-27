package com.example.iosteam.myfirstconstraints.model;

import com.example.iosteam.myfirstconstraints.contract.MVPContract;

public class MVPModel implements MVPContract.Model {
    @Override
    public String getData() {
        return "Hiiiii";
    }
}
