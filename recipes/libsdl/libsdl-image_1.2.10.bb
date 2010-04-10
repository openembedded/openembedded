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

SRC_URI[md5sum] = "6c06584b31559e2b59f2b982d0d1f628"
SRC_URI[sha256sum] = "75e05d1e95f6277b44797157d9e25a908ba8d08a393216ffb019b0d74de11876"
