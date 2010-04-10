require gst-plugins.inc

PR = "${INC_PR}.1"

SRC_URI += "file://vorbisenc.h file://vorbisdec.h \
            file://ivorbis-thumb.patch;patch=1"
DEPENDS += "gst-plugins-base directfb"

do_compile_prepend() {
	# work around missing files in upstream tarball (upstream bug #454078)
	install -m 0644 ${WORKDIR}/vorbis*.h ${S}/ext/ivorbis/
}

SRC_URI[archive.md5sum] = "75a3359ece6a1c11a9e5463d79e274e8"
SRC_URI[archive.sha256sum] = "b50072ff6f36087b8ecebf509e6d44ab2e91292b1a3a5806a7f1437a382723e9"
