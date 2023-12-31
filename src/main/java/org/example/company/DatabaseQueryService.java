package org.example.company;

import org.example.database.Database;
import org.example.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.utils.ReaderFiles.readSqlFile;

public class DatabaseQueryService {
    private final Database database;

    public DatabaseQueryService(Database database) {
        this.database = database;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();

        String path = "./sql/find_max_salary_worker.sql";
        String sql = readSqlFile(path);

        ResultSet resultSet = database.executeQuery(sql);

        while (resultSet.next()) {
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");

                MaxSalaryWorker worker = new MaxSalaryWorker(name, salary);

                result.add(worker);
            }
        }

        return result;
    }

    public List<LongestProject> findLongestProject(){
        List<LongestProject> longestProjectList = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        try (ResultSet result = executeSelectSqlFile(connection, SQL_FILE_PATH)){
            while (result.next()){
                String clientName = result.getString("client_name");
                int projectMonthCount = result.getInt("project_month_count");
                LongestProject record = new LongestProject(clientName, projectMonthCount);
                longestProjectList.add(record);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return longestProjectList;
    }

//    public List<MaxSalaryWorker> findMaxSalaryWorker() {
//        List<MaxSalaryWorker> result = new ArrayList<>();
//
//        String path = "./sql/find_max_salary_worker.sql";
//        String sql = readSqlFile(path);
//
//        try (Statement statement = database.getConnection().createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                int salary = resultSet.getInt("salary");
//
//                MaxSalaryWorker worker = new MaxSalaryWorker(name, salary);
//
//                result.add(worker);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        String path = "./sql/find_max_projects_client.sql";
        String sql = readSqlFile(path);

        try (Statement statement = database.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("projects_client");

                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);

                result.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();

        String path = "./sql/find_longest_project.sql";
        String sql = readSqlFile(path);

        try (Statement statement = database.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int monthCount = resultSet.getInt("month_count");

                LongestProject project = new LongestProject(name, monthCount);

                result.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();

        String path = "./sql/find_youngest_eldest_workers.sql";
        String sql = readSqlFile(path);

        try (Statement statement = database.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String birthday = resultSet.getString("birthday");

                YoungestEldestWorkers worker = new YoungestEldestWorkers(type, name, birthday);

                result.add(worker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<ProjectPrices> printProjectPrices() {
        List<ProjectPrices> result = new ArrayList<>();

        String path = "./sql/print_project_prices.sql";
        String sql = readSqlFile(path);

        try (Statement statement = database.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");

                ProjectPrices project = new ProjectPrices(name, price);

                result.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
