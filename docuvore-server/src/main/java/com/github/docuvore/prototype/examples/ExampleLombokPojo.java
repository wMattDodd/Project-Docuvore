package com.github.docuvore.prototype.examples;

import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExampleLombokPojo {
	@NonNull String name;
	int age;
	@Singular
	List<String> awards;
}
