export function calcular() {
    
    var num6 = parseFloat(document.getElementById("num6").value);
    var num7 = parseFloat(document.getElementById("num7").value);
    var num8 = parseFloat(document.getElementById("num8").value);
    var num9 = parseFloat(document.getElementById("num9").value);
    var num10 = num6 + num7 + num8 + num9;     

    var num27 = parseFloat(document.getElementById("num27").value);
    var num28 = parseFloat(document.getElementById("num28").value);
    var num29 = parseFloat(document.getElementById("num29").value);
    var num30 = parseFloat(document.getElementById("num30").value);
    var num31 = num30 + num29 + num28 + num27;
    
    document.getElementById("num10").value = num10; 
    document.getElementById("num31").value = num31;
    
    var num11 = parseFloat(document.getElementById("11").value);
    var num12 = parseFloat(document.getElementById("12").value);
    var num13 = parseFloat(document.getElementById("13").value);
    var num17 = num11 + num12 + num13; 
    
    document.getElementById("17").value = num17;
    
}
