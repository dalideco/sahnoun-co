import { Injectable } from '@nestjs/common';
import {ProjectDto} from "./dto/project.dto";

@Injectable()
export class ProjectsService {
    checkProject(project: ProjectDto) {
        const randomValue = Math.random();
        if (randomValue < 0.5) {
            return { status: true };
        } else {
            const reasons = [
                "Insufficient resources",
                "Financial resources allocated elsewhere",
                "Not cost-effective",
            ];

            const randomReason = reasons[Math.floor(Math.random() * reasons.length)];

            return { status: false, reason: randomReason };
        }
    }
}
