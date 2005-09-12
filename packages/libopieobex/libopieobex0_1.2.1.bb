include libopieobex0.inc


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/obex \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics      \
	   file://chdir-patch.patch;patch=1;pnum=0           "
