include ${PN}.inc

# Remove the dash below when 1.2.1 changes
PV = "1.2.1+cvs-${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/library \
           file://fix-titleheight.patch;patch=1"

