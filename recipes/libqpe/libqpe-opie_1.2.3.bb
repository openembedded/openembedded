require ${PN}.inc

PR = "${INC_PR}.0"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
           file://fix-titleheight.patch;apply=yes \
           file://unbreak-logging.patch;apply=yes \
           file://citytime-path.patch;apply=yes \
           file://fix-sd-card-path.patch;apply=yes \
          "

