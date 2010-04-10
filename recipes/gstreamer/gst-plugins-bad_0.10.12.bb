require gst-plugins.inc

SRC_URI += "file://vorbisenc.h file://vorbisdec.h \
            file://ivorbis-thumb.patch;patch=1"

DEPENDS += "gst-plugins-base openssl directfb"

do_compile_prepend() {
	# work around missing files in upstream tarball (upstream bug #454078)
	install -m 0644 ${WORKDIR}/vorbis*.h ${S}/ext/ivorbis/
}

SRC_URI[archive.md5sum] = "63309cf0bb21f3efd4e43868c314f919"
SRC_URI[archive.sha256sum] = "18387f78b721ce6b56c02f886ec89774a4e58b7883c70ab2ae6c1af58f1661c9"
