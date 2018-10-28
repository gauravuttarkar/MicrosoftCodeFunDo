from django.http import HttpResponse, JsonResponse
import requests
import json
from django.conf import settings
import os
import numpy as np
import pandas as pd
from keras.models import Sequential
from keras.layers import Dense, Dropout
from keras.models import model_from_json

def predict(weather,loaded_model):
    wedata=np.asarray(weather)
    result=loaded_model.predict(weather, batch_size=120, verbose=0, steps=None)
    return result


def index(request,lat=None,longi=None,data = None):
	api = "147b79daa29884e1dab8fac91b7526d6"
	print(type(lat))
	url = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+longi+"&appid="+api;
	response = requests.get(url)
	print(type(response))
	print(response.text)
	res = response.json()
	print(lat,longi)
	print(data)
	temp = res['main']['temp']
	pressure = res['main']['pressure']
	humidity = res['main']['humidity']
	temp_min = res['main']['temp_min']
	temp_max = res['main']['temp_max']
	windspeed = res['wind']['speed']
	winddeg = res['wind']['deg']
	
	

	print(type(temp))
	print(type(pressure))
	print(type(humidity))
	print(type(temp_min))
	print(type(temp_max))
	print(type(windspeed))
	print(type(winddeg))
	weather = [temp, pressure, humidity, temp_min, temp_max, windspeed, winddeg]
	weather=np.asarray([weather])
	# result=data.predict(weather, batch_size=120, verbose=0, steps=None)
	# print(weather)
	print(predict(weather,data))
	#print(result)

	
	return JsonResponse(json.loads(response.text),safe=False)