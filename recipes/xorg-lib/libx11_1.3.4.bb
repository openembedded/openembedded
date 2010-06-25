require libx11.inc
PR = "${INC_PR}.0"

SRC_URI += " file://dolt-fix.patch"
SRC_URI[archive.md5sum] = "f65c9c7ecbfb64c19dbd7927160d63fd"
SRC_URI[archive.sha256sum] = "88d7238ce5f7cd123450567de7a3b56a43556e4ccc45df38b8324147c889a844"
