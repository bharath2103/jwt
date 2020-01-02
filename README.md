# jwt
Here instead of allowing Spring to select a username and password. We are writing custom class to override the authentication.

MySecurity class extends the WebSecurityConfigurerAdapter and overrides configure() method, Since the AuthenticationManager is required to enable inmemory authentication 
