package com.example.myeventbus

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class EventBus {
    open class Event()

    private val bus = BehaviorSubject.create<Event>()

    fun post(event: Event) {
        bus.onNext(event)
    }

    fun get(): Observable<Event> = bus
}