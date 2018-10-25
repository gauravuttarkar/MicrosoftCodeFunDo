from django.contrib import admin
from django.urls import path
from . import views

urlpatterns = [
    path('location/<str:lat>-<str:longi>', views.index),
]
