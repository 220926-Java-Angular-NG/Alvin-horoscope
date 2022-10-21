/**Intro to fetch api
 * The Fetch API provides a fetch() method defined on the window object. 
 * This method used to send requests and returns a Promise that retrieved from the response. 
 * A Promise object represents a value that may not be available now but, will be resolved in the future. 
 * It allows us to write asynchronous code.
 */






var properZodiac = "";

//get our button
let button = document.getElementById("button")

//add event listener
button.addEventListener('click', async() =>
    {
        //get the value from our user input field (ie the text box)
        let zodiac = document.getElementById('field').value;
        properZodiac = zodiac.toLowerCase();
        //send request to the pokemon api
        //to do that we have to wrap our code in a try catch
        console.log(zodiac);
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
            console.log(json_data);
            console.log(properZodiac);


        }
        catch(error)
        {
            console.log(error);
        }
    }
 )


 function getZodiac(json_data)
 {//This is where we will manipulate our DOM
    var input = document.getElementById("input");
    var Horo = document.createElement("h2");
    
    //Note: append vs appendChild
    Horo.innerHTML = `Horoscope: ${json_data.horoscope}`;
    input.append(Horo);
 }



 let buttonMood = document.getElementById("moodButton")

//add event listener
buttonMood.addEventListener('click', async() =>
    {
        console.log(properZodiac);
        //get the value from our user input field (ie the text box)
        let zodiac = document.getElementById('field').value;
        properZodiac = zodiac.toLowerCase();
        //send request to the pokemon api
        //to do that we have to wrap our code in a try catch
        console.log(zodiac);
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
    var Horo = document.createElement("h2");
    
    //Note: append vs appendChild
    let mood = json_data.meta.mood;
    console.log(mood);
    let moodProper = mood[0].toUpperCase() + mood.substring(1);

    Horo.innerHTML = 'Mood: ' + moodProper;
    // Horo.innerHTML = `Mood: ${json_data.meta.mood}`;
    moodSpace.append(Horo);
 }

//  function getZodiac(json_data)
//  {//This is where we will manipulate our DOM
//     var input = document.getElementById("input");
//     var Horo = document.createElement("h2");
    
//     //Note: append vs appendChild
//     Horo.innerHTML = `Horoscope: ${json_data.horoscope}`;
//     input.append(Horo);
//  }