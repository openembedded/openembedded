include ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/applets/memoryapplet \
           ${HANDHELDS_CVS};module=opie/noncore/settings/sysinfo \
           ${HANDHELDS_CVS};module=opie/pics"
