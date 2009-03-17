require frameworkd_git.bb
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/frameworkd', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
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
