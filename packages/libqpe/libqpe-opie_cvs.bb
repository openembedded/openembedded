require ${PN}.inc

PV = "1.2.2+cvs${SRCDATE}"
PR = "r7"

SRC_URI = "${HANDHELDS_CVS};module=opie/library \
           file://fix-titleheight.patch;patch=1"

