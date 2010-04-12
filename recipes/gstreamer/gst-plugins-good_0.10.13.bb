require gst-plugins.inc

PR = "${INC_PR}.1"

inherit gconf 

EXTRA_OECONF += " --enable-experimental  --enable-gst_v4l2 --enable-gconftool  --enable-external --with-check=no"
DEPENDS += "jpeg libtheora gst-plugins-base esound"

PACKAGES =+ "gst-plugin-gconfelements"
FILES_gst-plugin-gconfelements += "${sysconfdir}/gconf"

SRC_URI[archive.md5sum] = "27f27151ccefad1157c9eaa322e14ac4"
SRC_URI[archive.sha256sum] = "dfffb80ef01b8fee9af3576311e65b60c378d9985099dea532be090ede54ebaa"
