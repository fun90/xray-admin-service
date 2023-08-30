package com.fun90.admin.controller;

import com.fun90.admin.VO.UserVO;
import com.fun90.admin.cache.UserCache;
import com.fun90.admin.model.Package;
import com.fun90.admin.repository.PackageRepository;
import com.fun90.admin.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.fun90.admin.constant.KVConstant.*;

@Controller
public class PlanController {
	@Autowired
    PackageRepository packageRepository;
	@Autowired
	UserCache userCache;

	@ResponseBody
	@GetMapping("/plan/{id}")
	public Result get(@PathVariable Integer id) {
		if (id == null) throw new NullPointerException("id不能为空");
		Package aPackage = packageRepository.findById(id).orElse(null);
		return Result.builder().code(Result.CODE_SUCCESS).obj(aPackage).build();
	}

	@ResponseBody
	@GetMapping("/plan")
	public Result findByPage(@CookieValue(value = COOKIE_NAME, defaultValue = "") String auth, Integer page, Integer pageSize) {
		if (page == null || pageSize == null) throw new NullPointerException("page, pageSize不能为空");

		UserVO cache = userCache.getCache(auth);
		String role = cache.getRole();
		Page<Package> pages = null;
		if (role.equals(ROLE_ADMIN)) {
			pages = packageRepository.findAll(PageRequest.of(page - 1, pageSize));

		} else {
			//寻找正常的，可以显示的
			pages = packageRepository.findAll(Example.of(Package.builder().status(V_TRUE).show(V_TRUE).build()),
					PageRequest.of(page - 1, pageSize));
		}
		return Result.buildPageObject(pages.getTotalElements(), pages.getContent());
	}

	@ResponseBody
	@PostMapping("/plan")
	public Result add(@RequestBody Package aPackage) {
		if (aPackage == null) throw new NullPointerException("Package不能为空");
		packageRepository.save(aPackage);
		return Result.doSuccess();
	}

	@ResponseBody
	@PutMapping("/plan")
	public Result put(@RequestBody Package aPackage) {
		if (aPackage == null) throw new NullPointerException("Package不能为空");
		if (aPackage.getId() == null) throw new NullPointerException("id 不能为空");
		packageRepository.save(aPackage);
		return Result.doSuccess();
	}

	@ResponseBody
	@DeleteMapping("/plan/{id}")
	public Result delete(@PathVariable Integer id) {
		if (id != null) throw new NullPointerException("id不能为空");
		Package aPackage = packageRepository.findById(id).orElse(null);
		if (aPackage == null) throw new NullPointerException("Package is null");
		aPackage.setStatus(0);
		packageRepository.save(aPackage);
		return Result.doSuccess();
	}


}
