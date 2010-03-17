require gst-plugins.inc

SRC_URI += "file://flvdemux-ecma.diff;patch=1 \
"

SRC_URI[archive.md5sum] = "9bc5c9b390edbb96bda42fc553eae5ae"
SRC_URI[archive.sha256sum] = "24445a1cf56302ab4ad5f56055d5c3d81c704b8f9f6875fe78a25d4f72716d22"

inherit gconf 

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound libv4l"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

EXTRA_OECONF += " --with-libv4l2 "
