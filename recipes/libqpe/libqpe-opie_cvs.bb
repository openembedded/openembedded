require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "${INC_PR}.0"

SRC_URI = "${HANDHELDS_CVS};module=opie/library \
           file://fix-titleheight.patch;patch=1 \
           file://unbreak-logging.patch;patch=1 \
           file://citytime-path-2.patch;patch=1 \
           file://no-include-pro.patch;patch=1 \
          "
