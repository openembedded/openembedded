require xorg-app-common.inc
DESCRIPTION = "tiny window manager"
DEPENDS += " libxext libxt libxmu"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://0001-config-replace-AC_CHECK_FILE-with-test-f.patch"
SRC_URI[archive.md5sum] = "e265b44d02872eb2c7b1338ccc82a157"
SRC_URI[archive.sha256sum] = "717bab9122d91f307ff6f4a43c5368f88e7f85d5525b99607b1508c62fbc327c"

FILES_${PN} += "${datadir}/X11/twm/system.twmrc"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_PATH = "${bindir}/twm"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "1"
