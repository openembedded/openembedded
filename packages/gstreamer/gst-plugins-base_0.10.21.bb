include gst-plugins.inc
PROVIDES_${PN} += "gst-plugins"
SRC_URI += " file://disable_doc.patch;patch=1;pnum=1"
PR = "r0"
