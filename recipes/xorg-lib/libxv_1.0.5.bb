require xorg-lib-common.inc

DESCRIPTION = "X11 Video extension library"
LICENSE = "GPL"
DEPENDS += "libxext videoproto"
PR = "r1"

XORG_PN = "libXv"

SRC_URI[archive.md5sum] = "1d97798b1d8bbf8d9085e1b223a0738f"
SRC_URI[archive.sha256sum] = "d549afdf22feefb97cca85dee12242af9f08c4d2435255dc7c30bd17d1d96010"
