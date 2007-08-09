require ${PN}.inc

PV = "1.2.2+cvs${SRCDATE}"
PR = "r10"

SRC_URI = "${HANDHELDS_CVS};module=opie/library \
           file://fix-titleheight.patch;patch=1 \
           file://unbreak-logging.patch;patch=1 \
          "

