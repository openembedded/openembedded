include ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/lockapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics "
