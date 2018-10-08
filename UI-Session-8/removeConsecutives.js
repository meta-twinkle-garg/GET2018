function removeConsecutives(inputString){
    var length=inputString.length;
    var count,count2;
    var stringToReplace;
    for(count=0;count<length;count++){
        stringToReplace="";
        count2=count+1;
        if(inputString.charAt(count)==inputString.charAt(count2)){
            stringToReplace+=inputString.charAt(count);
            while(inputString.charAt(count)==inputString.charAt(count2)){
                stringToReplace+=inputString.charAt(count);
                count2++;
            }
            inputString=inputString.replace(stringToReplace,"");
            length-=(count2-count);
            count=0; 
            console.log(inputString);
        }
    }
    
}

