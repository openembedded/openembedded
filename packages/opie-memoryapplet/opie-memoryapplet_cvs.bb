include ${PN}.inc

PV = "1.2.1+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/applets/memoryapplet \
           ${HANDHELDS_CVS};module=opie/noncore/settings/sysinfo \
           ${HANDHELDS_CVS};module=opie/pics"
