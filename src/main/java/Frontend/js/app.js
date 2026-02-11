// REGISTER
document.getElementById("registerForm")?.addEventListener("submit", function(e) {
    e.preventDefault();

    alert("User Registered Successfully!");
    window.location.href = "login.html";
});

// LOGIN
document.getElementById("loginForm")?.addEventListener("submit", function(e) {
    e.preventDefault();

    alert("Login Successful!");
    window.location.href = "dashboard.html";
});

// CREATE RIDE
document.getElementById("rideForm")?.addEventListener("submit", function(e) {
    e.preventDefault();

    alert("Ride Created Successfully!");
    window.location.href = "dashboard.html";
});

// NAVIGATION
function goCreateRide() {
    window.location.href = "createRide.html";
}

function goMyBookings() {
    window.location.href = "myBookings.html";
}

function goDashboard() {
    window.location.href = "dashboard.html";
}

function logout() {
    alert("Logged out!");
    window.location.href = "login.html";
}

function showRides() {
    alert("Show all rides (connect backend later)");
}
