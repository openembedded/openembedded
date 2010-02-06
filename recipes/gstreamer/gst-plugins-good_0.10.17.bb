require gst-plugins.inc

SRC_URI += "file://flvdemux-ecma.diff;patch=1 \
"

PR = "r2"

inherit gconf 

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

