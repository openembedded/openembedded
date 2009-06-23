require clutter-gst.inc

DEPENDS += "clutter-0.9"

SRCREV = "487552b95f7ccce00118619d5b4256936621eb5e"
PV = "0.9.0"
PR = "r3"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter-gst.git;protocol=git \
           file://0001-clutter-gst-videosink-guard-GL-calls-with-ifdef-CL.patch;patch=1 \
           file://gtk-doc.make"

S = "${WORKDIR}/git"
