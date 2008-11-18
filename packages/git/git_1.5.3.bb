require git.inc

SRC_URI += "file://git-gui-install-mode-arg-spaces.patch;patch=1"

DEPENDS = "openssl curl zlib expat"
RDEPENDS = "perl perl-module-file-path cpio findutils sed"
PR = "r2"
