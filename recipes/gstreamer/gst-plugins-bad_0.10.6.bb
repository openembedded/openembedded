require gst-plugins.inc

PR = "${INC_PR}.1"

SRC_URI += "file://vorbisenc.h file://vorbisdec.h \
            file://gst-plugins-directfb-fix.patch;patch=1;pnum=2 \
            file://ivorbis-thumb.patch;patch=1"
DEPENDS += "gst-plugins-base directfb"

do_compile_prepend() {
	# work around missing files in upstream tarball (upstream bug #454078)
	install -m 0644 ${WORKDIR}/vorbis*.h ${S}/ext/ivorbis/
}

SRC_URI[archive.md5sum] = "fb47838aa0ccef52683cea5d89364053"
SRC_URI[archive.sha256sum] = "c702dab34d3b330ec06d915a91a937dadb0a93ace25bbe8e337223ddb834efe6"
