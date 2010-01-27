require libsdl-image.inc

PR = "${INC_PR}.1"

DEPENDS += "tiff"

# Disable the run-time loading of the libs and bring back the soname dependencies.
EXTRA_OECONF += "--disable-jpg-shared --disable-png-shared -disable-tif-shared"

do_unpackpost() {
	# Removing this file fixes a libtool version mismatch.
	rm acinclude/libtool.m4
	rm acinclude/sdl.m4
	rm acinclude/pkg.m4
	rm acinclude/lt~obsolete.m4
	rm acinclude/ltoptions.m4
	rm acinclude/ltsugar.m4
	rm acinclude/ltversion.m4
}

addtask unpackpost after do_unpack before do_patch
