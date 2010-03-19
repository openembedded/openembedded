require pixman.inc
PR = "${INC_PR}.0"

SRC_URI += " \
           file://pixman-arm.patch;patch=1 \
	   file://pixman-x888-565.patch;patch=1 \
	  "
