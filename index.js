let signUpButton = document.getElementById("signUp");

signUpButton.addEventListener('click', async(event)=>
{
    event.preventDefault();
    window.location.replace("registerPage.html")//Switches to register page
})

let loginButton = document.getElementById('signInButton');
loginButton.addEventListener('click', async(event)=>
{
    event.preventDefault();

    let username = document.getElementById('userField').value;
    let password = document.getElementById('passwordField').value;

    // console.log(username);
    // console.log(password);
    let loginInfo = 
    {

        userName: username,
        pass_word:password,
    };

    let json = JSON.stringify(loginInfo);
    try
    {
        const raw_response = await fetch('http://localhost:8080/login',
        {
            method: "POST",
            body:json
        });

        if(!raw_response.ok)
        {
            throw new Error(raw_response.status);
        }

        raw_response.json().then((data)=>
        {
            let loggedInUser = JSON.stringify(data);
            localStorage.setItem("currentUser", loggedInUser);
            console.log(data);
        })

        setTimeout(()=>
        {
            window.location.replace('Homepage.html');
        },3000)

    }
    catch(error)
    {
        console.log(error);
    }


})