package com.example.teamgenerator.controller;

import com.example.teamgenerator.models.Team;
import com.example.teamgenerator.models.TeamGenerator;
import com.example.teamgenerator.services.GenerateGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/team")
public class TeamGenerateController {

    @Autowired
    private GenerateGroupService generateGroupService;

    @PostMapping("/generate")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    public Team generateGroup(@RequestBody TeamGenerator teamGenerator) {
        return generateGroupService.generateGroup(teamGenerator);

    }
}
