/* script.js */
const form = document.getElementById('registrationForm');

form.addEventListener('submit', function(event) {
  event.preventDefault();
  validateForm();
});

function validateForm() {
  const fullName = document.getElementById('fullName').value.trim();
  const email = document.getElementById('email').value.trim();
  const phone = document.getElementById('phone').value.trim();
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;

  let isValid = true;

  // Full Name Validation
  if (fullName.length < 5) {
    showError('nameError', 'Name must be at least 5 characters long.');
    isValid = false;
  } else {
    clearError('nameError');
  }

  // Email Validation
  if (!email.includes('@')) {
    showError('emailError', 'Enter a valid email address.');
    isValid = false;
  } else {
    clearError('emailError');
  }

  // Phone Number Validation
  if (phone.length !== 10 || phone === '1234567890' || isNaN(phone)) {
    showError('phoneError', 'Enter a valid 10-digit phone number.');
    isValid = false;
  } else {
    clearError('phoneError');
  }

  // Password Validation
  if (password.length < 8 || password.toLowerCase() === 'password' || password.toLowerCase() === fullName.toLowerCase()) {
    showError('passwordError', 'Password must be at least 8 characters and not "password" or your name.');
    isValid = false;
  } else {
    clearError('passwordError');
  }

  // Confirm Password Validation
  if (password !== confirmPassword) {
    showError('confirmPasswordError', 'Passwords do not match.');
    isValid = false;
  } else {
    clearError('confirmPasswordError');
  }

  if (isValid) {
    alert('Form submitted successfully!');
    form.reset();
  }
}

function showError(elementId, message) {
  document.getElementById(elementId).textContent = message;
}

function clearError(elementId) {
  document.getElementById(elementId).textContent = '';
}
