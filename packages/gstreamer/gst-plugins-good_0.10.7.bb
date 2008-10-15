require gst-plugins.inc
FILE_PR = "r2"

inherit gconf 

EXTRA_OECONF += "--with-check=no"
DEPENDS += "gst-plugins-base esound"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"
