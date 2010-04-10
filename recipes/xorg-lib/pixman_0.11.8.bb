require pixman.inc
PR = "${INC_PR}.0"

SRC_URI += " \
           file://pixman-arm.patch;patch=1 \
	   file://pixman-x888-565.patch;patch=1 \
	  "

SRC_URI[archive.md5sum] = "7b5db768c51337b5e5e954fc9c961cd3"
SRC_URI[archive.sha256sum] = "720db5ef6ed0e744b9bac5360ade9a7c024f9fb3fab05c83a90ee28b08e66e01"
