require libpng.inc

PR = "${INC_PR}.0"

SRC_URI += "file://makefile_fix.patch;patch=1"

SRC_URI[tarball.md5sum] = "2faa7f8d81e6a35beb991cb75edbf056"
SRC_URI[tarball.sha256sum] = "a172c5afe4668a31eb090d14be7fc2811a9fec8568a785badd30280f47a27e00"
