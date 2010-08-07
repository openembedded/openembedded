require gst-plugins.inc

PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "9cddbb0e7e90677f0cc05c23feffef5c"
SRC_URI[archive.sha256sum] = "2e7771a611cedb1e8208601cb26744fbf33109598e222afee1be8811ba4babcf"

inherit gconf 

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound libv4l"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

EXTRA_OECONF += " --with-libv4l2 "
