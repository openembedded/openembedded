include ${PN}.inc


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/tools/opie-sh \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/help \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/share \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/bin"
