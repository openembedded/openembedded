require xorg-app-common.inc
DEPENDS += " libxcursor libpng"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "39e1e62f5bd92603b0230b8b948c2fc4"
SRC_URI[archive.sha256sum] = "18d3e0d64853089c2154f1f867df087fc15f87e03e09fabc98ee5e265d8a53ef"

BBCLASSEXTEND = "native"
