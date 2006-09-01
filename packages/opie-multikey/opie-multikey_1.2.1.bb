include ${PN}.inc

CVSDATE = "20060902"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/multikey \
           ${HANDHELDS_CVS};module=opie/share"
