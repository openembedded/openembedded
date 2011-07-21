require gst-plugins.inc

PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "6ef1588921f59d85c44ee2e49a3c97a0"
SRC_URI[archive.sha256sum] = "adfbce68b9fbadb7a7aeda2227af6afe1928ef025af4158726617b9d6834b028"

inherit gconf

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound libv4l"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

EXTRA_OECONF += " --with-libv4l2 "
