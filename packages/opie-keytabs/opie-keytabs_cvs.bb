include ${PN}.inc

# Remove the dash below when 1.2.1 changes in PV
PV = "1.2.1+cvs-${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/etc"
