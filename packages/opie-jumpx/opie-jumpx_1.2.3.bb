require ${PN}.inc

FILE_PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/inputmethods/jumpx \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"
