console.log("scirpt loaded");

let currentTheme = getTheme();
document.addEventListener('DOMContentLoaded', () => {
    changeTheme(currentTheme);
});

function changeTheme() {
    console.log(currentTheme);
    // set to web page
    document.querySelector("html").classList.add(currentTheme);

    //set the listner to change theme button
    const changeThemeButton = document.querySelector("#theme_change_button");
    changeThemeButton.querySelector('span').textContent = currentTheme === "dark" ? " Light" : " Dark";
    changeThemeButton.addEventListener("click", (event) => {
        const oldTheme = currentTheme;
        console.log("change theme button clicked")
        if(currentTheme === "dark"){
            currentTheme = "light";
        }else{
            currentTheme = "dark";
        }
        setTheme(currentTheme);

        document.querySelector("html").classList.remove(oldTheme);
        document.querySelector("html").classList.add(currentTheme);

        changeThemeButton.querySelector('span').textContent = currentTheme === "dark" ? " Light" : " Dark";
    });
    

}

function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

function getTheme() {
    let theme = localStorage.getItem("theme");
    if (theme) return theme;
    else return "light"; 
}