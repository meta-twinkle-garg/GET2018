String.prototype.repeatify = function(count){
    var input=this;
    var result="";
    while(count>0){
        result+=input;
        count--;
    }
    console.log(result);
}