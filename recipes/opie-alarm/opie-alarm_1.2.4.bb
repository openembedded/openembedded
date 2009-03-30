require ${PN}.inc

PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/opiealarm \
           file://01opiealarm \
	   file://dirdefines.patch;patch=1 "
