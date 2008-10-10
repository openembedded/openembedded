require libsdl-image.inc

do_unpackpost() {
	# Removing this file fixes a libtool version mismatch.
	rm acinclude/libtool.m4
}

addtask unpackpost after do_unpack before do_patch
