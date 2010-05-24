require ${PN}.inc

PR = "${INC_PR}.1"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
           file://fix-titleheight.patch;apply=yes \
           file://unbreak-logging.patch;apply=yes \
           file://citytime-path-2.patch;apply=yes \
           file://no-include-pro.patch;apply=yes \
           file://unhide_lnkproperties_destructor.patch;apply=yes \
          "

