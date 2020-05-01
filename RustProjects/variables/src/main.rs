

fn main() {
    // -------------------------------------------------------
    // VARIABLES

    let mut y = 5;
    println!("The value of y is {}", y);
    y = 6; // mutable variable
    println!("The new value of y is {}", y);

    let x = 5;

    let x = x + 1; // shadowing

    let x = x * 2; // should now be 12

    println!("The value of x is: {}", x);

    let spaces = "1   1";
    println!("The value of spaces is: {}", spaces);

    let spaces = spaces.len(); // good example of shadowing
    println!("The length of spaces is: {}", spaces);

    // This is not allowed because we cant mutate type
    // let mut spaces = "   ";
    // spaces = spaces.len();

    // -------------------------------------------------------
    // DATA TYPES

    // Floats
    let x = 2.0; // f64
    let y: f32 = 3.0; // f32

    // Bools
    let t = true;
    let f: bool = false; // with explicit type annotation

    // Special chars
    let c = 'z';
    let z = 'ℤ';
    let heart_eyed_cat = '😻';

    // Tuples
    let tup: (i32, f64, u8) = (500, 6.4, 1);
    let tup2 = (500, 6.4, 1);
    let (a, b, x) = tup2;
    println!("The value of y is: {}", b); // should be 6.4

    let d: (i32, f64, u8) = (500, 6.4, 1);
    let five_hundred = d.0;
    let six_point_four = d.1;
    let one = d.2;
    
    // Arrays
    let arr = [1, 2, 3, 4, 5];
    let months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    let arr2: [i32; 5] = [1, 2, 3, 4, 5]; // specifies type and size
    let first = arr2[0]; // accessing element
    let second = arr2[1];
}
