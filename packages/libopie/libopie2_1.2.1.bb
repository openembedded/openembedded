include ${PN}.inc

PR = "r3"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
	   file://openzaurus-branding.patch;patch=1 \
	   file://tosa-bl.patch;patch=1 \
	   file://poodle-collie-bl.patch;patch=1 \
           file://include.pro"
