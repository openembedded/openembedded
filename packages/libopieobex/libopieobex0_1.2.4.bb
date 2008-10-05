require libopieobex0.inc
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/obex \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           file://disable-bt-check.patch;patch=1"
