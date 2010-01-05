require qi.inc
PR = "r0"
PR_append = "+gitr${SRCREV}"

SRC_URI = "\
  git://git.openmoko.org/git/qi.git;protocol=git;branch=master \
  file://sanitize-makefile.patch;patch=1 \
"
S = "${WORKDIR}/git"

