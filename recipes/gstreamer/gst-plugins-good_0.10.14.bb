require gst-plugins.inc

PR = "${INC_PR}.1"

inherit gconf 

EXTRA_OECONF += " --enable-experimental  --enable-gst_v4l2 --enable-gconftool  --enable-external --with-check=no"
DEPENDS += "jpeg libtheora gst-plugins-base esound"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"
