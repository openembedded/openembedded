require ${PN}.inc

PR = "${INC_PR}.0"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
           file://fix-titleheight.patch \
           file://unbreak-logging.patch \
           file://citytime-path.patch \
           file://fix-sd-card-path.patch \
          "
