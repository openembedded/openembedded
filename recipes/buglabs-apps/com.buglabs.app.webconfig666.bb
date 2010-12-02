require bug-app.inc

DESCRIPTION = "Updated!!!\
\
This application lets you manage configurations from the web.\
Manage your own Maps by browsing to 10.10.10.10/666 for the BUG or localhost:8082/666 with the virtual BUG.\
Manage ConfigurationAdmin configurations by going to 10.10.10.10/configuration666 for the BUG or localhost:8082/configuration666 with the virtual BUG.\
\
Manage Your Own Maps!\
Track service webconfig666.IConfig666\
Use the service like this:\
// I put this in my ServiceTracker::doStart() method\
config = new HashMap(); //config is a private member variiable\
config.put('mykey','my value');\
IConfig666 ddd = (IConfig666) getService(IConfig666.class);\
ddd.register('monkey', config);\
\
You can now modifiy the values in config at the url /666?monkey.  You can register as many Maps as you need.  This config is only persistent as long as the underlying Map object is around.  Chances are this is the lifetime of your running app, so when you restart your app, the values will be back to their default.  To persist config information, see below.\
\
Access Configuration Manager\
To manage ConfigurationAdmin configs, create or get a reference to the config you want, then register it with IConfigAdmin666::register(Configuration config). The configs will then be available at /configuration666.  The ConfigurationAdmin will persist configuration data so you can reset your BUG and the data won't go away.\
Here's some sample code:\
configuration = configAdmin.getConfiguration(CONFIGURATION_ID);\
IConfigAdmin666 fff = (IConfigAdmin666)\
    service_provider.getService(IConfigAdmin666.class);\
fff.register(configuration);\
\
"
HOMEPAGE = "http://buglabs.net/applications/WebConfig666"

DEPENDS += "service-tracker com.buglabs.osgi.http com.buglabs.osgi.cm com.sun.javax.servlet com.buglabs.common com.buglabs.osgi "

PV = "13"

SRC_LINK = "http://buglabs.net/program_version/download/436"

APIVERSION = ""
