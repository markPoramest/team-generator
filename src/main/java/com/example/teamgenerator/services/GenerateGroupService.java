package com.example.teamgenerator.services;

import com.example.teamgenerator.models.Team;
import com.example.teamgenerator.models.TeamGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class GenerateGroupService {

    public Team generateGroup(TeamGenerator teamGenerator) {
        try {
            List<String> allOfNames = teamGenerator.getTeamMembers();
            Collections.shuffle(allOfNames);

            List<String[]> groups = new ArrayList<>();
            for (int i = 0; i < teamGenerator.getNumberOfGroups(); i++) {
                String[] group = new String[teamGenerator.getNumberOfEachGroup()[i]];
                AddMemberToEachGroup(group, allOfNames, teamGenerator.getNumberOfEachGroup()[i]);
                groups.add(group);
            }
            Team team = new Team();
            team.setTeamMembers(groups);
            return team;
        } catch (Exception e) {
            return null;
        }
    }

    private void AddMemberToEachGroup(String[] group, List<String> allOfNames, int numOfGroup) {
        for (int j = 0; j < numOfGroup; j++) {
            group[j] = allOfNames.get(0);
            allOfNames.remove(0);
            if (allOfNames.size() == 0) {
                break;
            }
        }
    }
}
