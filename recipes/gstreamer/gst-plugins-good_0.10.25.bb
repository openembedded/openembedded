require gst-plugins.inc

PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "d734bc866788d1d6fc74c4ff1318926c"
SRC_URI[archive.sha256sum] = "b5d5750c12412c47d85ba9391c842f6f02cad9511876695e48b15fb37e4699f6"

inherit gconf

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound libv4l"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

EXTRA_OECONF += " --with-libv4l2 "
