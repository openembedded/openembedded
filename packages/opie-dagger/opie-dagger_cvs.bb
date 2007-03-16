require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/dagger \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

SRC_URI += " file://opie-dagger-missing-include.patch;patch=1"
