// 以下是用JavaScript编写的求一元二次方程的根的算法
function solveQuadraticEquation(a, b, c) {
    let discriminant = b * b - 4 * a * c;
    let result = [];
    if (discriminant > 0) {
        let root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        let root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        result.push(root1, root2);
    } else if (discriminant === 0) {
        let root = -b / (2 * a);
        result.push(root);
    } else {
        let realPart = -b / (2 * a);
        let imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
        result.push(realPart + " + " + imaginaryPart + "i", realPart + " - " + imaginaryPart + "i");
    }

    return result;
}

// 示例用法
let roots = solveQuadraticEquation(1, -3, 2);
console.log(roots); // 输出 [2, 1]

// 在这个示例中，`solveQuadraticEquation` 函数接受三个参数 `a`、`b` 和 `c`，分别代表一元二次方程的系数。根据判别式的值，函数计算并返回方程的根。
