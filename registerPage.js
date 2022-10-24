let signInButton = document.getElementById("signIn");

signInButton.addEventListener('click', async(event)=>
{
    event.preventDefault();
    window.location.replace("index.html")//Switches to register page
})

let loginButton = document.getElementById('signInButton');
loginButton.addEventListener('click', async(event)=>
{
    event.preventDefault();
    let firstname = document.getElementById('firstName').value;
    let lastname = document.getElementById('lastName').value;
    let username = document.getElementById('userField').value;
    let password = document.getElementById('passwordField').value;
    let zodiacReg = document.getElementById('zodiacField').value;

    // console.log(username);
    // console.log(password);
    let registerInfo = 
    {
        firstName: firstname,
        lastName: lastname,
        userName: username,
        pass_word:password,
        zodiac: zodiacReg
    };

    let json = JSON.stringify(registerInfo);
    try
    {
        const raw_response = await fetch('http://localhost:8080/user',
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