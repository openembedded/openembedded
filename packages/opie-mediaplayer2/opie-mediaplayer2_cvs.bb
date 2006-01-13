include ${PN}.inc

# Remove the dash below when 1.2.1 changes in PV
PV = "1.2.1+cvs-${SRCDATE}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/multimedia/opieplayer2 \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
