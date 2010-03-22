require gst-plugins.inc

SRC_URI += "file://flvdemux-ecma.diff;patch=1 \
"

PR = "r3"

inherit gconf 

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound libv4l"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

EXTRA_OECONF += " --with-libv4l2 "
