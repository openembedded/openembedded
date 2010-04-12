require gst-plugins.inc
PR = "r2"

SRC_URI += "file://vorbisenc.h file://vorbisdec.h \
            file://gst-plugins-directfb-fix.patch;patch=1;pnum=2 \
            file://ivorbis-thumb.patch;patch=1"

DEPENDS += "gst-plugins-base openssl"
EXTRA_OECONF += " ac_cv_openssldir=no"

do_compile_prepend() {
	# work around missing files in upstream tarball (upstream bug #454078)
	install -m 0644 ${WORKDIR}/vorbis*.h ${S}/ext/ivorbis/
}

SRC_URI[archive.md5sum] = "ff555a86e74a9249e56b43405c8df3e4"
SRC_URI[archive.sha256sum] = "d8215aa4c3069531609091619386abfa2f331ed95607b1525d9464a06d814e4f"
