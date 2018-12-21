package org.sj.msuserrepo;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
@Autowired
UserStoreRepo userRepo;

	@PostMapping("/addUser")
	public UserRepo addUser(@Valid @RequestBody UserRepo user) {
		UserRepo savedUser=userRepo.save(user);
		return savedUser;
	}
	
	@GetMapping("/getUser/{id}")
	public UserRepo getUser(@PathVariable (value="id") UUID id) {
		return userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("UserRepo","id",id));
	}

	@GetMapping("/getAllUsers")
	@ResponseBody
	public List<UserRepo> getAllUsers() {
		return userRepo.findAll();
	}

	
	@PatchMapping("/updateUser/{id}")
	public UserRepo updateUser(@PathVariable (value="id") UUID id, @RequestBody UserRepo receivedUser) {
		UserRepo savedUser=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("UserRepo","id",id));
		savedUser.setPoaFileID(receivedUser.getPoaFileID());
		savedUser.setPoiFileID(receivedUser.getPoiFileID());
		return savedUser;
	}

}
