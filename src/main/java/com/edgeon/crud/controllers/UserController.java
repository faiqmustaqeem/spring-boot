package com.edgeon.crud.controllers;

import com.edgeon.crud.models.Response;
import com.edgeon.crud.models.TaskModel;
import com.edgeon.crud.models.UserModel;
import com.edgeon.crud.repositories.UserRepository;
import com.edgeon.crud.storage.FileSystemStorageService;
import com.edgeon.crud.storage.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    UserRepository userRepository;
    public UserController(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers()
    {
        List<UserModel> list=this.userRepository.findAll();
        return list;
    }

    @GetMapping("/getUserById")
    public Response getUserById(@RequestParam("id")String id)
    {
        Optional<UserModel> userModel= this.userRepository.findById(id);
        if(userModel.isPresent())
        {
            return new Response("success" , "user found" , userModel);
        }
        else {
            return new Response("failure" , "incorrect id" , null);
        }
    }

//    @PostMapping
//    private void insert(@RequestBody UserModel model)
//    {
//        this.userRepository.insert(model);
//    }

    @PostMapping("/signup")
    public Response signup(@RequestBody UserModel userModel)
    {
        UserModel user= this.userRepository.findByEmail(userModel.getEmail());
        if(user==null)
        {
            this.userRepository.insert(userModel);
            return new Response("success" , "user added successfully");
        }
        else {
            return new Response("failed" , "email already exist");
        }

    }
    @PutMapping("/update/{id}")
    public Response update(@PathVariable("id") String id , @RequestBody UserModel userModel)
    {
        Optional<UserModel> user=this.userRepository.findById(id);
        if(!user.isPresent())
        {
            return new Response("failed" , "incorrect id");
        }
        else
        {
            userModel.setId(id);
            this.userRepository.save(userModel);
            return new Response("success" , "user data updated");
        }
    }


    @GetMapping("/getAllAgeLessThan")
    public List<UserModel> getAllUsersLessThan(@RequestParam("age") int age)
    {
        List<UserModel> list=this.userRepository.findByAgeLessThan(age);
        return list;
    }

    @Autowired
    private FileSystemStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public Response handleFileUpload(@RequestParam("file") MultipartFile file , @RequestBody TaskModel taskModel) {

        fileStorageService.store(file);

        return new Response("success" , taskModel.getTaskName() +" received");
    }






}
