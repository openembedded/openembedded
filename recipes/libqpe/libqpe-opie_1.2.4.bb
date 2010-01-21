require ${PN}.inc

PR = "${INC_PR}.1"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
           file://fix-titleheight.patch;patch=1 \
           file://unbreak-logging.patch;patch=1 \
           file://citytime-path-2.patch;patch=1 \
           file://no-include-pro.patch;patch=1 \
           file://unhide_lnkproperties_destructor.patch;patch=1 \
          "

