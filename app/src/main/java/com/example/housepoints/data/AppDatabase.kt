package com.example.housepoints.data

abstract class AppDatabase {
    abstract fun getPointsDao(): PointsDao
}