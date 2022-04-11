This is a solution to the address book spring boot technical challenge.

Written by Isabella Scollo for ReeceTech in 2022

<u>Context</u>

I implemented an in memory database using H2. This can be queried using localhost:8080/hs-console. HTTP requests can be sent to localhost:8080/api (/contacts/{id}). I have used REST mapping that can be seen in the contact controller and should be fairly self explanatory.

I initially tried to implement one to many relationship between and AddressBook class and Contact Class but was having issues with the different entities being able to see each other in memory. Spring boot is a new platform for me but is similar to Python API framework I've used before. Looking forward to hearing your feedback

Isabella Scollo

