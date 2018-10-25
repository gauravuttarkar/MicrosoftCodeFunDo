
from django.http import HttpResponse
import requests
# Create your views here.

def index(request, location = None):
	apikey = "7c22a8eb36304b108285c4164e8893a6"
	url = "https://newsapi.org/v2/everything?q="+location+"&from=2018-09-23&sortBy=publishedAt&apiKey=" + apikey
	response = requests.get(url)
	print(response.text)
	return HttpResponse("Hello, world. You're at the polls index.") 
	#print(lat,longi)
