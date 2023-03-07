package services;

import com.example.teamgenerator.models.Team;
import com.example.teamgenerator.models.TeamGenerator;
import com.example.teamgenerator.services.GenerateGroupService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GenerateGroupServiceTest {

    GenerateGroupService generateGroupService = new GenerateGroupService();

    @Test
    void Should_Return_Two_Group_When_Generate_Success() {
        List<String> teamMembers = new ArrayList<>();
        teamMembers.add("A");
        teamMembers.add("B");
        teamMembers.add("C");
        teamMembers.add("D");
        teamMembers.add("E");
        teamMembers.add("F");

        TeamGenerator teamGenerator = new TeamGenerator();
        teamGenerator.setNumberOfGroups(2);
        teamGenerator.setNumberOfEachGroup(new int[]{2, 4});
        teamGenerator.setTeamMembers(teamMembers);

        Team  result = generateGroupService.generateGroup(teamGenerator);
        assert result.getTeamMembers().size() == 2;
        assert result.getTeamMembers().get(0).length == 2;
        assert result.getTeamMembers().get(1).length == 4;
    }

}