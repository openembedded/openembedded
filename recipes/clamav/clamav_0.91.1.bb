require clamav.inc

SRC_URI += "file://cross-compile-fix.patch;patch=1"

PR = "${INC_PR}.0"

SRC_URI[clamav-0.91.1.md5sum] = "60152bf1e24b3fbdf0473794199e5215"
SRC_URI[clamav-0.91.1.sha256sum] = "f98edecae40473c142fe49a0e02f5ff7fb28d778c4bd510dad747d208d20cb00"
