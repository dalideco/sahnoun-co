import { Module } from '@nestjs/common';
import { ProjectsModule } from './projects/projects.module';
import { EmployeesModule } from './employees/employees.module';

@Module({
  imports: [ProjectsModule, EmployeesModule],
  controllers: [],
  providers: [],
})
export class AppModule {}
