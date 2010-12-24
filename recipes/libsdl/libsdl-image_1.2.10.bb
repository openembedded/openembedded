require libsdl-image.inc

PR = "${INC_PR}.2"

DEPENDS += "tiff"

# Disable the run-time loading of the libs and bring back the soname dependencies.
EXTRA_OECONF += "--disable-jpg-shared --disable-png-shared -disable-tif-shared"

do_configure_prepend() {
	# Removing this file fixes a libtool version mismatch.
	rm -f acinclude/libtool.m4
	rm -f acinclude/sdl.m4
	rm -f acinclude/pkg.m4
	rm -f acinclude/lt~obsolete.m4
	rm -f acinclude/ltoptions.m4
	rm -f acinclude/ltsugar.m4
	rm -f acinclude/ltversion.m4
}

SRC_URI[md5sum] = "6c06584b31559e2b59f2b982d0d1f628"
SRC_URI[sha256sum] = "75e05d1e95f6277b44797157d9e25a908ba8d08a393216ffb019b0d74de11876"
