require blueprobe.inc
PR = "r6"

SRC_URI += "\
  file://fix-makefile.patch;patch=1 \
  file://h4000.patch;patch=1 \
  file://uclibc-fix.patch;patch=1 \
  file://rx3000.patch;patch=1 \
"
