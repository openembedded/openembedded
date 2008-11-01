require gst-plugins.inc

SRC_URI += "file://input-selector-segment.patch;patch=1;pnum=0 \
	file://disable_doc.patch;patch=1;pnum=1"

DEPENDS += "gst-plugins-base"

EXTRA_OECONF += "--disable-apexsink"

PR = "r0"