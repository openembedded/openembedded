require xorg-app-common.inc
DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."
DEPENDS += " libxkbfile"
PR = "${INC_PR}.0"

SRC_URI += "file://fix.configure.988eb0e121c0f2c992031002acb7274c2026764b.patch"

SRC_URI[archive.md5sum] = "0f55995cd8da9b2d88553e1a2e17cd0a"
SRC_URI[archive.sha256sum] = "2c64aa414755e764ca548ae5c93e95f7b5bbd5e01bca16bf226fd32bfae77ea4"

BBCLASSEXTEND = "native"
