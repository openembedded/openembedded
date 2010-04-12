require gst-plugins.inc

SRC_URI += "file://flvdemux-ecma.diff;patch=1 \
"

PR = "r3"

inherit gconf 

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound libv4l"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

EXTRA_OECONF += " --with-libv4l2 "

SRC_URI[archive.md5sum] = "833546cd2b8bbf86b8ed083b00897918"
SRC_URI[archive.sha256sum] = "4f41fbd325270416c9f55d900e470482a7d1e7efbdbb725ed03a085dec307ad6"
