const sum = (a,b) => (b || b==0) ? a+b : (b) => a+b;

const product = (a,b) => (b || b==0) ? a*b : (b) => a*b;
export {sum, product};
