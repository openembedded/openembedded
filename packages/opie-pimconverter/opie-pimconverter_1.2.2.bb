include ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/tools/pimconverter \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"
