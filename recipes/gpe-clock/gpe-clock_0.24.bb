require gpe-clock.inc

PR = "${INC_PR}.0"

SRC_URI += "file://fix-install.patch;patch=1"

SRC_URI[md5sum] = "4e51de389b881d730f56d439e8573271"
SRC_URI[sha256sum] = "2d40ea6851c2b90261b88941dc7a8ee83c4a333e7a2acdd4eb0afbc87b5e5da1"
