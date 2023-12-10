import { Module } from '@nestjs/common';
import { ProjectsModule } from './projects/projects.module';
import { EmployeesModule } from './employees/employees.module';
import { AppController } from './app.controller';

@Module({
  imports: [ProjectsModule, EmployeesModule],
  controllers: [AppController],
  providers: [],
})
export class AppModule {}
