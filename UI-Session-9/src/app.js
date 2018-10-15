import { sum, product } from './modules/math-functions';

result.addEventListener("click", function(){
  const a = parseInt(document.getElementById('firstInput').value);
const b = parseInt(document.getElementById('secondInput').value);
const resultSum=document.getElementById('resultSum');
const resultProduct=document.getElementById('resultProduct');
resultSum.innerHTML = `The sum of ${a} and ${b} is ${sum(a)(b)}.`;
resultProduct.innerHTML = `The product of ${a} and ${b} is ${product(a,b)}.`;  
});

