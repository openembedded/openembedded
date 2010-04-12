require libpng.inc

PR = "${INC_PR}.0"

SRC_URI += "file://makefile_fix.patch;patch=1"

SRC_URI[tarball.md5sum] = "9a5cbe9798927fdf528f3186a8840ebe"
SRC_URI[tarball.sha256sum] = "a044c4632a236bbf99527da81977577929a173c1f7f68a70a81ea2ea7cffa6a7"
