require gst-plugins.inc

PR = "r6"

SRC_URI += "file://fix-unit-scale-asseration.patch;patch=1"

inherit gconf 

DEPENDS += "libsoup-2.4 flac gst-plugins-base openssl popt esound"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

