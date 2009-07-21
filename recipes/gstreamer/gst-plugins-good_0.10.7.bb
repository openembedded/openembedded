require gst-plugins.inc
PR = "r6"

inherit gconf 

EXTRA_OECONF += " --enable-experimental  --enable-gst_v4l2 --enable-gconftool  --enable-external --with-check=no"
DEPENDS += "gst-plugins-base esound"
DEPENDS_append_shr = " flac"
        
PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"
