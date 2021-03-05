package com.example.httpdemo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class DemoController {
	
	
	@GetMapping(path="/add/{a}/{b}")
	public ResponseEntity<Integer> calc(@PathVariable final int a, @PathVariable final int b) {
		return ResponseEntity.ok(a + b);
	}

	@PostMapping(path="/addieren", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> calc2(@RequestBody final Params p) {
		return ResponseEntity.ok(Integer.toString(p.getA() + p.getB()));
	}
	
	

}
