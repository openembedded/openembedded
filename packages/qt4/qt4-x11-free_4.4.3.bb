require qt4-x11-free.inc
PR = "r1"

SRC_URI += " \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0007-openssl-host-includes.patch;patch=1 "
