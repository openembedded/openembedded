require gst-plugins.inc

SRC_URI += "file://vorbisenc.h file://vorbisdec.h"
DEPENDS += "gst-plugins-base"

do_compile_prepend() {
	# work around missing files in upstream tarball (upstream bug #454078)
	install -m 0644 ${WORKDIR}/vorbis*.h ${S}/ext/ivorbis/
}

PR = "r0"
