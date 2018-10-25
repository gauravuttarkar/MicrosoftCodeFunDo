from django.http import HttpResponse
import requests

def index(request,lat=None,longi=None):
	api = "147b79daa29884e1dab8fac91b7526d6"
	print(type(lat))
	url = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+longi+"&appid="+api;
	response = requests.get(url)
	print(response.text)
	print(lat,longi)
	return HttpResponse("Hello, world. You're at the polls index.") 