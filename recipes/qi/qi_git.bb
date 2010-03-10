require qi.inc
PR = "r1"
PR_append = "+gitr${SRCREV}"

SRCREV = "c38b062a609f1442e6a9e13005cfbdfd59a5ac0d"
SRC_URI = "\
  git://git.openmoko.org/git/qi.git;protocol=git;branch=master \
  file://sanitize-makefile.patch;patch=1 \
"
S = "${WORKDIR}/git"

