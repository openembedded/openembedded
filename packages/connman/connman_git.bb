require connman.inc
PV = "0.8+gitr${SRCREV}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  git://git.moblin.org/repos/projects/connman.git;protocol=http \
  file://connman \
"
S = "${WORKDIR}/git"
