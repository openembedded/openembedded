require clutter-gst.inc

SRCREV = "460826267cbb50c257cf7d957f8f9483a678da4e"
PV = "0.9.0"
PR = "r1"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter-gst.git;protocol=git;branch=1.0-integration \
           file://autofoo.patch;patch=1 \
           file://0001-clutter-gst-videosink-guard-GL-calls-with-ifdef-CL.patch;patch=1"

S = "${WORKDIR}/git"
