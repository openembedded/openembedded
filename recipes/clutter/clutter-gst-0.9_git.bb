require clutter-gst.inc

SRCREV = "a9a259bfcd8488a101df5c687366ca763c69b7ef"
PV = "0.9.0"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter-gst.git;protocol=git \
           file://autofoo.patch;patch=1"

S = "${WORKDIR}/git"
