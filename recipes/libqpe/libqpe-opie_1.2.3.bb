require ${PN}.inc

PR = "${INC_PR}.0"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
           file://fix-titleheight.patch;patch=1 \
           file://unbreak-logging.patch;patch=1 \
           file://citytime-path.patch;patch=1 \
           file://fix-sd-card-path.patch;patch=1 \
          "

