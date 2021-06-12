# Application Type: This is a Spring Boot Rest service Application.

The Business Rules are configured in the application config file. 

The user needs to configure one product and for that product they need to choose the list of operations to be done.

Url endpoint for service:  /payment/{productname}
the mentioned productname is any of the product names that are configured in the application file. 

# Config Steps:
1) All product names are configured

2) for each product one needs to configure the operations.

3) for each operation the action needs to be configured. 

## We can also design it like, for each operation the action can be configured as a Method name, and that particular nethod will be invoked using Java reflection.
## Currently we are just returning the action string Only.



