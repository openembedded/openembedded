require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r5"

SRC_URI = "${HANDHELDS_CVS};module=opie/inputmethods/multikey \
           ${HANDHELDS_CVS};module=opie/share \
           file://fix-rpath.patch"

#           file://friendly-button-names.patch"
