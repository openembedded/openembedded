require gst-plugins.inc

PR = "${INC_PR}.1"

inherit gconf 

EXTRA_OECONF += " --enable-experimental  --enable-gst_v4l2 --enable-gconftool  --enable-external --with-check=no"
DEPENDS += "jpeg libtheora gst-plugins-base esound"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

SRC_URI[archive.md5sum] = "a861ccbb90a176d1242608502f45f0ac"
SRC_URI[archive.sha256sum] = "12205d01cb99900ed6f936a09ac31b5849f8a7ff3c9a93e5857a76dc3e30788a"
