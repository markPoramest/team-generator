package com.example.teamgenerator.models;

import lombok.Data;

import java.util.List;

@Data
public class TeamGenerator {

    private int numberOfGroups;

    private int[] numberOfEachGroup;

    private List<String> teamMembers;
}
