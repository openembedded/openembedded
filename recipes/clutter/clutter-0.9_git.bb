require clutter.inc

SRCREV = "35191f09ef0fa8fad6f386513dcd691ab6b6746f"
PV = "0.9.2"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter.git;protocol=git;branch=master \
           file://enable_tests.patch;patch=1 "
S = "${WORKDIR}/git"

BASE_CONF += "--disable-introspection"

