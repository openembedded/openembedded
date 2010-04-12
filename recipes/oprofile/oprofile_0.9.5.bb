require oprofile.inc

PR = "${INC_PR}.1"

SRC_URI += "file://fix-timer-mode.patch;patch=1"


SRC_URI[tarball.md5sum] = "4b2ceca3fa013c95cc8d47c790807dc2"
SRC_URI[tarball.sha256sum] = "1cb7c3968e3e01e7597f54b87ebc87a48c6c8e569db7e353adb91841db5b4190"
