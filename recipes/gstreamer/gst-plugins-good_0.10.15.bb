require gst-plugins.inc

PR = "r6"

SRC_URI += "file://fix-unit-scale-asseration.patch;patch=1"

inherit gconf 

DEPENDS += "libsoup-2.4 flac gst-plugins-base openssl popt esound"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"


SRC_URI[archive.md5sum] = "19bc6cc07951b3382d1ac8525b20e83f"
SRC_URI[archive.sha256sum] = "831f450a0fa18c881b00ec50e8916ed66ca0fecb53cd1939f0abcc02930f9847"
