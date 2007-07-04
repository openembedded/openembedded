require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r4"

SRC_URI = "${HANDHELDS_CVS};module=opie/inputmethods/multikey \
           ${HANDHELDS_CVS};module=opie/share \
           file://fix-rpath.patch;patch=1"

#           file://friendly-button-names.patch;patch=1"
