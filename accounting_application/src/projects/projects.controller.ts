import {Body, Controller, Post} from '@nestjs/common';
import {ProjectsService} from "./projects.service";
import {ProjectDto} from "./dto/project.dto";

@Controller('projects')
export class ProjectsController {
    constructor(private readonly projectsService: ProjectsService) {}


    @Post('project-acceptance')
    checkProject(@Body() project: ProjectDto) {
        return this.projectsService.checkProject(project);
    }
}
