require bug-app.inc

DESCRIPTION = "This application displays local businesses near where you are, such as Starbucks, Duane Reade, and Sephora (for my fellow female geeks). You can customize the list in LocalSearch class. \
More to follow:  \
make the map scrollable\
display a list of establishments with info (title, rating, etc)\
"
HOMEPAGE = "http://buglabs.net/applications/LocalSearch"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/155"

APIVERSION = ""
