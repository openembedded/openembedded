require ${PN}.inc

PV = "1.2.3+cvs${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/library \
           file://fix-titleheight.patch;patch=1 \
           file://unbreak-logging.patch;patch=1 \
          "

