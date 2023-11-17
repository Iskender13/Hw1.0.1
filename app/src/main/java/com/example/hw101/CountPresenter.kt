package com.example.hw101

class CountPresenter( private val counterView: CounterView) {
    private var model=CountModel()
    fun increment(){
        model.increment()
        counterView.showChangeCount(model.count)
        if(model.count==10){
            counterView.showToast()
        }
        if(model.count==15){
            counterView.changeColor()
        }
    }
    fun decrement(){
        model.decrement()
        counterView.showChangeCount(model.count)
    }

}