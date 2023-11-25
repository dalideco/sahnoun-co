import { Injectable } from '@nestjs/common';
import {ProjectDto} from "../projects/dto/project.dto";
import {RecruitmentDto} from "./dto/recruitment.dto";

@Injectable()
export class EmployeesService {

    checkRecruitment(recruitment: RecruitmentDto) {
        const randomValue = Math.random();
        if (randomValue < 0.5) {
            return { status: true };
        } else {
            const reasons = [
                "Budget constraints",
            ];

            const randomReason = reasons[Math.floor(Math.random() * reasons.length)];

            return { status: false, reason: randomReason };
        }
    }
}
