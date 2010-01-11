require ${PN}.inc

PR = "${INC_PR}.0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/apps/opie-reader \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

