require gst-plugins.inc

PR = "r5"

SRC_URI += "file://fix-unit-scale-asseration.patch;patch=1"

OE_ALLOW_INSECURE_DOWNLOADS = "1"
inherit gconf 

DEPENDS += "flac gst-plugins-base openssl popt esound"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

