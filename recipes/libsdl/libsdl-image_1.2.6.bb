require libsdl-image.inc

PR = "${INC_PR}.1"

DEPENDS += "tiff"

do_configure_prepend() {
	# Removing this file fixes a libtool version mismatch.
	rm -f acinclude/libtool.m4
	rm -f acinclude/sdl.m4
}

SRC_URI[md5sum] = "b866dc4f647517bdaf57f6ffdefd013e"
SRC_URI[sha256sum] = "88fcb1dbf934af33163667a6677312065c7d0a7f01cd764e3374c4c19b386ec4"
