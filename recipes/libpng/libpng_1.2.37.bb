require libpng.inc

PR = "${INC_PR}.0"

SRC_URI += "file://makefile_fix.patch;patch=1"

SRC_URI[tarball.md5sum] = "6d1ee0888dbb711214943cb19c294b49"
SRC_URI[tarball.sha256sum] = "682960b55527b54bada90e959c2d42679444a1db43677c77eb645a29645f86d1"
