require ${PN}.inc

FILE_PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/keyboard \
	file://fix-rpath.patch;patch=1 "
