require clutter-gst.inc

DEPENDS = "clutter-0.9 gstreamer gst-plugins-base"

SRCREV = "379b63b013af463210e54470693aedfa9009f4dc"
PV = "0.9.0"
PR = "r4"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter-gst.git;protocol=git \
           file://gtk-doc.make"

S = "${WORKDIR}/git"
