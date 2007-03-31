DESCRIPTION = "The OpenMoko Messaging Application"
SECTION = "openmoko/applications"

PV = "0.0.1+svn${SRCDATE}"
PR = "r2"

inherit openmoko

SRC_URI += "file://unbreak-messages.patch;patch=1"
