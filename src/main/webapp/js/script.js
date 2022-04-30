function showProfile(view){
    var profile = document.getElementById("edit-profile");
    var blog = document.getElementById("create-blog");
    // if (profile.style.display === "none") {
    //     profile.style.display = "block";
    //     blog.style.display = "none";
    // } else {
    //     profile.style.display = "none";
    //     blog.style.display = "block";
    // }
    if (view == 1) {
        profile.style.display = "block";
        blog.style.display = "none";
    } else {
        profile.style.display = "none";
        blog.style.display = "block";
    }
}

