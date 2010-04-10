require blueprobe.inc
PR = "r6"

SRC_URI += "\
  file://fix-makefile.patch;patch=1 \
  file://h4000.patch;patch=1 \
  file://uclibc-fix.patch;patch=1 \
  file://rx3000.patch;patch=1 \
"

SRC_URI[md5sum] = "174a1f2c9ffea150c7abe4becd99f2cd"
SRC_URI[sha256sum] = "5980de18e195be06f99afbc76f3c72e7ef7dbba03f16814351d20b8a2531c474"
