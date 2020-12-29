var app = new Vue({
    el: '#app',
    data: {
        operand: 0,
        operator: "plus",
        dot:0,
        lastno:0,
        ca:true,
        answer:0
    },
    methods: {
        calc: function (){
            if(this.ca == true) {
                if(this.operand==0)
                    this.operand = this.answer;
                fetch("http://localhost:8085/calc?operand=" + (this.operand) + "&operator=" + (this.operator))
                    .then(reponse => reponse.text())
                    .then(data => this.answer = data)
                this.operand = 0
                this.dot = 0
                this.operator = "+"
                this.ca = false;
            }
            else{
                fetch("http://localhost:8085/calc?operand=" + "u" + "&operator=" + (this.operator))
                    .then(reponse => reponse.text())
                    .then(data => this.answer = data)
            }
        },
        update_operand: function(no){
               if(no == -1){
                    this.operand = -this.operand
                    this.answer = this.operand
                }
                else if(no == -2){
                    if(this.dot==0) {
                        this.operand = this.operand - this.operand % 10
                        this.operand = this.operand / 10
                        this.answer = this.operand
                    }
                    else{
                        this.dot = this.dot+1
                        this.operand = this.operand - (this.lastno * (10 ** this.dot))
                        this.answer = this.operand
                        if(this.dot==-1)
                            this.dot = 0
                    }
                }
                else if(no == -3){
                    if(this.dot == 0)
                        this.dot = -1;
                }
                else {
                    if(this.operand>= 0) {
                        if (this.dot < 0){
                            this.operand = this.operand + no * (10 ** this.dot)}
                        else{
                            this.operand = this.operand * 10 + no}
                    }
                    else{
                        if (this.dot < 0){
                            this.operand = this.operand - no * (10** this.dot)}
                        else{
                            this.operand = this.operand * 10 - no}
                    }
                    if(this.dot<0)
                        this.dot = this.dot -1;
                    this.answer = this.operand
                    this.lastno = no
                    this.ca = true
                }
        },
        update_operater: function(op){
            if(op==1){
                this.operator = "perc"
                this.ca = true
            }
            if(op==2){
                this.operator = "div"
            }
            if(op==3){
                this.operator = "plus"
            }
            if(op==4){
                this.operator = "minus"
            }
            if(op==5){
                this.operator = "times"
            }
            if(op == 6) {
                this.operator = "CE"
                this.ca = true
            }
            if(op == 7) {
                this.operator = "C"
                this.ca = true
            }
            if(op == 8) {
                this.operator = "1/X"
                this.ca = true
            }
            if(op == 9) {
                this.operator = "X2"
                this.ca = true
            }
            if(op == 10) {
                this.operator = "sqrt(X)"
                this.ca = true
            }
            this.calc()
        }
    }

})