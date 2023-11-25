import {Body, Controller, Post} from '@nestjs/common';
import {EmployeesService} from "./employees.service";
import {RecruitmentDto} from "./dto/recruitment.dto";

@Controller('employees')
export class EmployeesController {
    constructor(private readonly employeesService: EmployeesService) {}

    @Post('recruitment-acceptance')
    checkProject(@Body() recruitment: RecruitmentDto) {
        return this.employeesService.checkRecruitment(recruitment);
    }
}
