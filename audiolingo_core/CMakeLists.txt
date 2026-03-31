cmake_minimum_required(VERSION 3.10)

project(audiolingo_core)

add_library(audiolingo_core SHARED core.cpp)

target_include_directories(audiolingo_core PRIVATE ${CMAKE_SOURCE_DIR})