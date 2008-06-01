require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r2"

SRC_URI = "${HANDHELDS_CVS};module=opie/library \
           file://fix-titleheight.patch;patch=1 \
           file://unbreak-logging.patch;patch=1 \
           file://citytime-path.patch;patch=1 \
          "

