require frameworkd_git.bb
FILESPATHPKG =. "frameworkd:"
PROVIDES = "frameworkd"
RPROVIDES = "frameworkd"
PV = "0.8.5.x+gitr${SRCREV}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=mickey/ogsmd-new-timeout \
  file://frameworkd \
  file://frameworkd.conf \
"
