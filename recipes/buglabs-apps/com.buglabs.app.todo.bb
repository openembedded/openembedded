require bug-app.inc

DESCRIPTION = "v1.0.1\
Updated one method call to match fix of a typo in the new SDK. Thanks for reminding me wex :-)\
v1.0.0\
First pass at a location-aware to-do list manager. It has (for now) 3 hard-coded lists: home, work and supermarket. Each list has a LatLon associated with it. I set it up with latlons from the default NYC route. If you select NEAREST from the menu it will automatically switch the todo list shown to be the one for the nearest location. You can also override it by selecting a specific list, in which case it will still show you the distance from that list's location, but it won't switch to the nearest list again until you select NEAREST.\
If you run the VirtualBUG, install the LCD and GPS modules it should show you the nearest list as 'home' for a while, then switch to 'work' then finally to 'supermarket' (assuming you use the default GPS data that's built into the VirtualBUG and that you don't choose a list from the menu).\
Things to figure out:\
\
How would a user edit a list, create a list, etc? The Bug LCD doesn't have a keyboard unless we create one, iPhone style or whatever. Also, a servlet interface might work quite nicely for this but of course it wouldn't be too usefull while you're out and about.\
\
User needs to be able to go somewhere and at least create an empty list at that location; otherwise they need to enter the latlon for the list by hand which would be tedious.\
\
Allow the user to check off completed items? I had it running with check boxes next to the items but couldn't get the repaint to work when I switched lists. That's probably just my lack of Java GUI knowledge though. (I had the lower section as a Panel that I removedAll()ed on a list switch, set it to a GridLayout of x,1 where x=# items in list, added in sub panels with BorderLayout containing the check box and the item).\
\
Make it pretty!\
"
HOMEPAGE = "http://buglabs.net/applications/todo"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/728"

APIVERSION = ""
