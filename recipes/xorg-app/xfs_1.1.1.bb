require xorg-app-common.inc
DESCRIPTION = "X fontserver"
DEPENDS += " libfs libxfont xtrans"
PE = "1"
PR = "${INC_PR}.0"

EXTRA_OECONF += "--with-default-font-path=${STAGING_ETCDIR}/X11/fontpath.d"
SRC_URI += "file://0001-config-look-for-fontpath.d-only-if-with-default-font.patch"
SRC_URI[archive.md5sum] = "e02c6cae689c082b8c98a421df8f8670"
SRC_URI[archive.sha256sum] = "0c83763a3c9843fdb1d420f18bea3632c5d7aaf91f94a6d9b3f0f5f1d541b5fb"
