require clutter-box2d.inc

SRCREV = "4e72b9c135a9439b82d801c62422531db611f98b"

PV = 0.10.0
PR = "${INC_PR}.0"
PR_append = "+git${SRCREV}"

SRC_URI = "git://git.clutter-project.org/clutter-box2d.git;protocol=git \
           file://example-data-location.patch \
          "

S = "${WORKDIR}/git"
