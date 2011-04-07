require gst-plugins.inc

PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "e1ed191adbf81edff04f348f8ce8e198"
SRC_URI[archive.sha256sum] = "ceb3bbea5ce18463b8fe470d34786bc846469e800305c436d799af9fe22bdcc4"

inherit gconf

DEPENDS += "hal pulseaudio speex libsoup-2.4 flac gst-plugins-base openssl popt esound libv4l"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

EXTRA_OECONF += " --with-libv4l2 "
