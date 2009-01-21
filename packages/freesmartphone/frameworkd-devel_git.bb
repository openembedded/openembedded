require frameworkd_git.bb
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/frameworkd', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PROVIDES = "frameworkd"
RPROVIDES = "frameworkd"
PV = "0.8.5.x+gitr${SRCREV}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"
# skip this package
COMPATIBLE_MACHINE = ""

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
  file://frameworkd \
  file://frameworkd.conf \
"

CONFFILES_${PN}-config += "\
  ${sysconfdir}/freesmartphone/ogsmd/networks.tab \
"
