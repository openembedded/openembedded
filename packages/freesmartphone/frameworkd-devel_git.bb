require frameworkd_git.bb
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/frameworkd', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PROVIDES = "frameworkd"
PV = "0.8.4.9+gitr${SRCREV}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
  file://frameworkd \
  file://frameworkd.conf \
"

CONFFILES_${PN}-config += "\
  ${sysconfdir}/freesmartphone/ogsmd/networks.tab \
"
