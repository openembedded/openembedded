require ${PN}.inc

PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/multikey \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/share \
           file://fix-rpath.patch;patch=1"

#           file://friendly-button-names.patch;patch=1"
