require ${PN}.inc
PR = "r2"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/multikey \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/share \
           file://friendly-button-names.patch;patch=1"
