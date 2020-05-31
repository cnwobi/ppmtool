package com.cnwobi.ppmtool.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cnwobi.ppmtool.model.Project;
import com.cnwobi.ppmtool.services.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith({SpringExtension.class})
@WebMvcTest(controllers = ProjectController.class)
public class ProjectControllerTest {

  @MockBean
  private ProjectService projectService;
  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() throws Exception {

  }

  @Test
  public void testCreateNewProject() throws Exception {
    Project project = Project.builder()
        .projectName("Test project")
        .projectIdentifier("Test Identifier")
        .build();

    mockMvc.perform(post("/api/project")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(project)))
        .andExpect(status().isCreated())
         .andReturn();

    ArgumentCaptor<Project> projectArgumentCaptor = ArgumentCaptor.forClass(Project.class);

    verify(projectService, times(1)).saveOrUpdateProject(projectArgumentCaptor.capture());
    assertThat(projectArgumentCaptor.getValue().getProjectName()).isEqualTo(project.getProjectName());
    assertThat(projectArgumentCaptor.getValue().getProjectIdentifier()).isEqualTo(project.getProjectIdentifier());


  }
}