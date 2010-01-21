require libsdl-image.inc

PR = "${INC_PR}.1"

DEPENDS += "tiff"

do_unpackpost() {
	# Removing this file fixes a libtool version mismatch.
	rm acinclude/libtool.m4
	rm acinclude/sdl.m4
}

addtask unpackpost after do_unpack before do_patch
