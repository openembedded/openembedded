require ${PN}.inc
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/pim/notes \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   file://gcc-4.5-non-trivially-copyable-fix.patch \
	  "
