package com.SportsClasses.controller;

import com.SportsClasses.domain.Trainer.SearchForm;
import com.SportsClasses.domain.Trainer.Trainer;
import com.SportsClasses.domain.User.User;
import com.SportsClasses.domain.Wrapper;
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
import java.util.*;

/**
 * Created by Влад on 08.11.2014.
 */
@Controller
@RequestMapping("/trainer")
public class TrainerController {    //Продумать удаление если есть ползователи, то кинуть на страничку со списком пользователей, поля которых надо изменить
    @Autowired
    UserService userService;

    @Autowired
    TrainerService trainerService;



    /*@Autowired
    private TrainerValidator trainerValidator;*/

    private static final Logger Mylogger = Logger.getLogger(UserController.class);


   /* @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(trainerValidator);
    }*/

    @RequestMapping("/register")
    public ModelAndView registerTrainer(@ModelAttribute Trainer trainer) {


        List<Integer> rankList = new ArrayList<>();
        rankList.add(1);
        rankList.add(2);
        rankList.add(3);


        Map<String, List> map = new HashMap<>();
        map.put("rankList", rankList);
       // map.put("trainersList", trainersList);
        return new ModelAndView("trainer/trainerRegister", "map", map);
    }

    @RequestMapping("/insert")
    public String insertData(@ModelAttribute @Valid Trainer trainer,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "redirect:register";
        }
        if (trainer != null){
            // user.setTrainer(trainerService.getTrainer(user.getTr_name()));
            trainerService.insertData(trainer);
        }
        return "redirect:getList";
    }

    @RequestMapping("/request")
    public ModelAndView getRequest(@ModelAttribute @Valid SearchForm searchForm){
        searchForm.setWord("Let's find it!");
      return new ModelAndView("trainer/request","searchForm",searchForm);
    }


    @RequestMapping("/search")
    public ModelAndView search(@ModelAttribute @Valid SearchForm searchForm){
        List<Trainer> trainersList;

            trainersList=trainerService.getTrainersByParam(searchForm);

        if (trainersList.size()==0){
            searchForm.setWord("There are no such trainers");
            return new ModelAndView("trainer/request","searchForm",searchForm);
        }
        //SearchForm nextSearchForm = new SearchForm();
        Map map = new HashMap();
        map.put("trainersList", trainersList);
        return new ModelAndView("trainer/trainerList", "map",map);
    }


    @RequestMapping("/getList")
    public ModelAndView getTrainersList() {
        List<Trainer> trainersList = trainerService.getTrainerList();
        Map map = new HashMap();
        map.put("trainersList", trainersList);
        return new ModelAndView("trainer/trainerList", "map",map);
    }

    //------------------------------------------------------------------------------
    @RequestMapping("/edit")
    public ModelAndView editTrainer(@RequestParam int id,
                                    @ModelAttribute @Valid Wrapper wrapper) {

        Trainer trainer = trainerService.getTrainer(id);
        ArrayList<String> usernames = new ArrayList<>();

        for (User username :trainer.getUsers()) {
            usernames.add(username.getFirstName()+" "+username.getLastName());
        }

        for (User user :userService.getFreeUsers()) {
            usernames.add(user.getFirstName()+" "+user.getLastName());
        }

        String[] arr = new String[usernames.size()];

        for (int i = 0; i < usernames.size(); i++) {
            arr[i]=usernames.get(i);
        }

        String[] initArr = new String[trainer.getUsers().size()];

        Iterator<User> it = trainer.getUsers().iterator();
        for (int i = 0; i <initArr.length ; i++) {
           initArr[i]=it.next().toString();
        }

        wrapper = new Wrapper();
        wrapper.setTrainer(trainer);
        wrapper.setUsernames(arr);
        wrapper.setInitClients(initArr);


        ArrayList<Integer> rankList = new ArrayList<>();
        rankList.add(1);
        rankList.add(2);
        rankList.add(3);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rankList", rankList);
       // map.put("trainersList", trainersList);
        map.put("wrapper", wrapper);


        return new ModelAndView("trainer/trainerEdit", "map", map);

    }

    @RequestMapping("/update")
    public String updateTrainer(@ModelAttribute @Valid Wrapper wrapper,BindingResult result) {
        if (result.hasErrors()){
            return "redirect:edit?id="+wrapper.getTrainer().getTrainerId();
        }
        trainerService.resetData(wrapper,userService);

        return "redirect:getList";
    }

    @RequestMapping("/delete")
    public String deleteTrainer(@RequestParam int id) {
        System.out.println("Trainer id = " + id+ " deletion");
        trainerService.deleteData(id);
        return "redirect:getList";  // /user
    }


}
