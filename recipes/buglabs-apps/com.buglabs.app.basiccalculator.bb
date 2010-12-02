require bug-app.inc

DESCRIPTION = "A basic 4 function calculator for BUG. It uses the AWT toolkit. Since I believe it is mostly an example right now it pops up immediately, when people get BUGs to put it on, I will make it register with the menu since it is a rarely used utility. As always, email or comment any problems you encounter or any features you would like added, I am looking for ways to improve it."
HOMEPAGE = "http://buglabs.net/applications/BasicCalculator"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/454"

APIVERSION = ""
