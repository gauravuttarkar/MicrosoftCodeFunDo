from django.contrib import admin
from django.urls import path
from . import views
import json
from django.conf import settings
import os
import numpy as np
import pandas as pd
from keras.models import Sequential
from keras.layers import Dense, Dropout
from keras.models import model_from_json



json_file = open(os.path.join(settings.PROJECT_ROOT, 'model1.json'),'r')
loaded_model_json = json_file.read()
print(loaded_model_json)
json_file.close()
loaded_model = model_from_json(loaded_model_json)
print(loaded_model)
# load weights into new model
loaded_model.load_weights(os.path.join(settings.PROJECT_ROOT, 'model1.h5'))
print(loaded_model)

# evaluate loaded model on test data
loaded_model.compile(loss='binary_crossentropy', optimizer='rmsprop', metrics=['accuracy'])


urlpatterns = [
    path('location/<str:lat>-<str:longi>', views.index,{'data':loaded_model}),
]