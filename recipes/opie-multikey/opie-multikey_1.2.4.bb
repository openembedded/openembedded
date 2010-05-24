require ${PN}.inc

PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/multikey \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/share \
           file://fix-rpath.patch;apply=yes"

#           file://friendly-button-names.patch;apply=yes"
