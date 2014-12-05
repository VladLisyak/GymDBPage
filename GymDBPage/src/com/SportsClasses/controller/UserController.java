package com.SportsClasses.controller;

import com.SportsClasses.domain.Trainer.SearchForm;
import com.SportsClasses.domain.Trainer.Trainer;
import com.SportsClasses.domain.User.User;
import com.SportsClasses.domain.User.UserSearchForm;
import com.SportsClasses.services.TrainerService;
import com.SportsClasses.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

    @Autowired
    TrainerService trainerService;

    private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping("/register")
	public ModelAndView registerUser(@ModelAttribute("user") User user) {

		List<String> genderList = new ArrayList<>();
		genderList.add("male");
		genderList.add("female");

		List<Trainer> trainersList = new ArrayList<>();

        for (Trainer trainer :trainerService.getTrainerList()) {
            trainersList.add(trainer);
        }


        Map<String, List> map = new HashMap<>();
		map.put("genderList", genderList);
		map.put("trainersList", trainersList);
		return new ModelAndView("user/register", "map", map);
	}



	@RequestMapping("/insert")
	public String inserData(@ModelAttribute("user") @Valid User user,BindingResult result) {
		if (result.hasErrors()){
            return "redirect:register";
        }
        if (user != null){
           // user.setTrainer(trainerService.getTrainer(user.getTr_name()));
			userService.insertData(user,trainerService);}
		return "redirect:getList";
	}


    @RequestMapping("/request")
    public ModelAndView getRequest(@ModelAttribute @Valid UserSearchForm searchForm){
        searchForm.setWord("Let's find it!");
        return new ModelAndView("user/request","searchForm",searchForm);
    }


    @RequestMapping("/search")
    public ModelAndView search(@ModelAttribute @Valid UserSearchForm searchForm){
        List<User> userList;

        userList=userService.getUsersByParam(searchForm);

        if (userList.size()==0){
            searchForm.setWord("There are no such users");
            return new ModelAndView("user/request","searchForm",searchForm);
        }
        //SearchForm nextSearchForm = new SearchForm();
        Map map = new HashMap();
        map.put("userList", userList);
        return new ModelAndView("user/userList", "userList",userList);
    }

	@RequestMapping("/getList")
	public ModelAndView getUserLIst() {
		List<User> userList = userService.getUserList();
		return new ModelAndView("user/userList", "userList", userList);
	}

	@RequestMapping("/edit")
	public ModelAndView editUser(@RequestParam int id,
			@ModelAttribute User user) {

		user = userService.getUser(id);

		List<String> genderList = new ArrayList<String>();
		genderList.add("male");
		genderList.add("female");

		List<Trainer> trainersList = new ArrayList<>();
        for (Trainer trainer :trainerService.getTrainerList()) {
            trainersList.add(trainer);
        }

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("genderList", genderList);
		map.put("trainersList", trainersList);
		map.put("user", user);

		return new ModelAndView("user/edit", "map", map);

	}

    @RequestMapping("/emptyUsers")
    public ModelAndView getEmpty(){
        List<User> userList = userService.getEmpty();
        SearchForm searchForm = new SearchForm();
        if (userList.size()==0){
            searchForm.setWord("There are no such users");
            return new ModelAndView("user/request","searchForm",searchForm);
        }
       return new ModelAndView("user/userList","userList",userList);
    }

	@RequestMapping("/update")
	public String updateUser(@ModelAttribute("user")@Valid User user,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){

            return "redirect:edit?id="+user.getUserId();
        }
		userService.updateData(user, trainerService);

		return "redirect:getList";

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam int id) {
		System.out.println("User id = " + id+ " deletion");
		userService.deleteData(id,trainerService);
		return "redirect:getList";  // /user
	}
}