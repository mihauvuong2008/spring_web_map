package spring_web_map.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring_web_map.model.UserInfo;

@Component
public class UserValidator implements Validator {
	// Các class được hỗ trợ Validate
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == UserInfo.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserInfo userInfo = (UserInfo) target;

		// Kiểm tra các field của ApplicantInfo.
		// (Xem thêm file property: messages/validator.property)
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.applicantForm.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hovaten", "NotEmpty.applicantForm.hovaten");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ngaysinh", "NotEmpty.applicantForm.ngaysinh");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lienhe", "NotEmpty.applicantForm.lienhe");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gioithieu", "NotEmpty.applicantForm.gioithieu");

	}
}
