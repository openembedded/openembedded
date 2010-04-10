DESCRIPTION = "Eject allows removable media (typically a CD-ROM, floppy disk, tape, or JAZ or ZIP disk) to be ejected under software control."
HOMEPAGE = "http://eject.sourceforge.net/"
LICENSE = "GPLv2"

inherit autotools gettext

SRC_URI = "http://sources.openembedded.org/eject-2.1.5.tar.gz"

S = "${WORKDIR}/${PN}"


SRC_URI[md5sum] = "b96a6d4263122f1711db12701d79f738"
SRC_URI[sha256sum] = "ef9f7906484cfde4ba223b2682a37058f9a3c7d3bb1adda7a34a67402e2ffe55"
