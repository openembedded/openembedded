include ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/tools/calculator \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/etc"
