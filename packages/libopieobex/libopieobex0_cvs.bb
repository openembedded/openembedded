require libopieobex0.inc
PV = "${OPIE_CVS_PV}"
FILE_PR = "r7"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/obex \
           ${HANDHELDS_CVS};module=opie/pics \
           file://disable-bt-check.patch;patch=1"
