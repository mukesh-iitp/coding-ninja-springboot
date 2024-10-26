package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.ExpenseType;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.IncomeType;
import com.example.cnExpense.entities.User;
import com.example.cnExpense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/filteredUserListByCalendar")
    public List<User> filteredUserListByCalendar(@RequestParam(value = "day", required = false) String day,
                                               @RequestParam(value = "month", required = false) String month,
                                               @RequestParam(value = "year", required = false) String year) {
        List<User> filteredList = new ArrayList<>();
        List<User> userList= getAllUsers();
        for (User user : userList) {
            List<Income> filteredIncomes = new ArrayList<>();
            for (Income income : user.getIncomes()) {
                if ((income.getDate()!=null) && (day != null && !day.isEmpty() && !(Integer.parseInt(day)==income.getDate().getDayOfMonth()))) {
                    continue;
                }
                else if ((income.getDate()!=null) && (month != null && !month.isEmpty() && !(Integer.parseInt(month)==income.getDate().getMonthValue()))) {
                    continue;
                }
                else if ((income.getDate()!=null) && (year != null && !year.isEmpty() && !(Integer.parseInt(year)==income.getDate().getYear()))) {
                    continue;
                }
                filteredIncomes.add(income);
            }
            user.setIncomes(filteredIncomes);
            filteredList.add(user);
        }
        return filteredList;
    }

    @GetMapping("/filteredUserListByType")
    public List<User> filterUserListByType(@RequestParam(value = "incomeType", required = false) String incomeType,
                                           @RequestParam(value = "expenseType", required = false) String expenseType) {
        List<User> userList = userService.getAllUsers();
        List<User> filteredList = new ArrayList<>();
        for (User user : userList) {
            List<Income> filteredIncomes = new ArrayList<>();
            for (Income income : user.getIncomes()) {
                if (incomeType != null && !incomeType.isEmpty()) {
                    boolean foundIncomeType = false;
                    for (IncomeType type : income.getIncomeTypes()) {
                        if (type.getName().equalsIgnoreCase(incomeType)) {
                            foundIncomeType = true;
                            break;
                        }
                    }
                    if (!foundIncomeType) {
                        continue;
                    }
                }
                else if (expenseType != null && !expenseType.isEmpty()) {
                    boolean foundExpenseType = false;
                    for (ExpenseType type : income.getExpense().getExpenseTypes()) {
                        if (type.getName().equalsIgnoreCase(expenseType)) {
                            foundExpenseType = true;
                            break;
                        }
                    }
                    if (!foundExpenseType) {
                        continue;
                    }
                }
                filteredIncomes.add(income);
            }
            user.setIncomes(filteredIncomes);
            filteredList.add(user);
        }
        return filteredList;
    }

    @GetMapping("allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/checkUserExist")
    public boolean checkUserExist(@RequestBody User user) {
        return userService.checkUserExist(user);
    }

    @PostMapping("/find")
    @ResponseBody
    public User findUser(@RequestBody User newUser){
        User user=userService.findUser(newUser);
        return user;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
       return userService.saveUser(user);
    }
}
