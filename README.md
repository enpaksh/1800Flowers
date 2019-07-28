# 1800Flowers
Following enpoints have been created

# Reading the json array via http://jsonplaceholder.typicode.com/posts directly and loading the data
POST: http://localhost:8085/object/list

# get the total count
GET: http://localhost:8085/count

# update the content for a given object
PATCH: http://localhost:8085/object/{ID}

sample:
{
    "userId": 10,
    "id": 4,
    "title": "1800Flowers",
    "body": "1800Flowers"
}

# Get total number of unique userid 
GET: http://localhost:8085/count/unique/userid

# Get a list of unique userids
GET: http://localhost:8085/unique/userid

# Get all objects
GET: localhost:8085/objects