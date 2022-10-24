/**Intro to fetch api
 * The Fetch API provides a fetch() method defined on the window object. 
 * This method used to send requests and returns a Promise that retrieved from the response. 
 * A Promise object represents a value that may not be available now but, will be resolved in the future. 
 * It allows us to write asynchronous code.
 */

let currentUser = localStorage.getItem("currentUser");
currentUser = JSON.parse(currentUser);
console.log(currentUser);

let welcomeLabel = document.getElementById("welcome");
welcomeLabel.innerHTML = `Welcome ${currentUser.firstName}!`




complimentUser();
async function complimentUser()
{
    try
    {
    const raw_response = await fetch(`https://complimentr.com/api`, 
    {
        method: "GET"
    });

        if(!raw_response.ok)
            throw new Error(raw_response.status);

        const json_data = await raw_response.json();

        generateCompliment(json_data);
    }
    catch(error)
    {
        console.log(error);
    }
}

function generateCompliment(json_data)
{
 let complimentLabel = document.getElementById("compliment");   
 comString = json_data.compliment
 firstLetter = comString[0].toUpperCase();
 sentence = comString.substring(1) + ".";
 totalCompli = firstLetter + sentence;

complimentLabel.innerHTML = totalCompli;

}


var properZodiac = "";           
properZodiac = currentUser.zodiac.toLowerCase();
//console.log(properZodiac);
async function horoscope()
{
    try
    {
        //this fetch method implicitely returns a promise
        const raw_response = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/${properZodiac}/today`);

        if(!raw_response.ok)
        {
            //throw new Error(raw_response.status);
            alert(`Error status: ${raw_response.status}`);
        }
        
        const json_data = await raw_response.json();
        
        getZodiac(json_data);

        
        
    }
    catch(error)
    {
        console.log(error);
    }
}


 function getZodiac(json_data)
 {
    var input = document.getElementById("input");
    input.innerHTML = `Horoscope: ${json_data.horoscope}`;
 }


horoscope();



 let buttonMood = document.getElementById("moodButton")

//add event listener
buttonMood.addEventListener('click', async() =>
    {
        try
        {
            console.log(properZodiac);
            properZodiac = currentUser.zodiac.toLowerCase();
            //this fetch method implicitely returns a promise
            const raw_response = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/${properZodiac}/today`);

            if(!raw_response.ok)
            {
                //throw new Error(raw_response.status);
                alert(`Error status: ${raw_response.status}`);
            }

            const json_data = await raw_response.json();

            getMood(json_data);
            console.log(json_data);
            

        }
        catch(error)
        {
            console.log(error);
        }
    }
 )

 function getMood(json_data)
 {
    var moodSpace = document.getElementById("moodInput");
    var mood = json_data.meta.mood;
    let moodProper = mood[0].toUpperCase() + mood.substring(1);

    moodSpace.innerHTML = 'Mood: ' + moodProper;

    setMood(moodProper);
 }

async function setMood(moodCurrent)
{
    let moodPut =
    {
        userId: currentUser.userId,
        mood: moodCurrent
    };
    let json = JSON.stringify(moodPut); 
    try
    {
        const raw_response = await fetch ('http://localhost:8080/user',
        {
            method: "PUT",
            body: json
        });

        if(!raw_response.ok)
        {
            throw new Error(raw_response.status);
        }

    }
    catch(error)
    {
        console.log(error);
    }
}