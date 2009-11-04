DESCRIPTION = "Eject allows removable media (typically a CD-ROM, floppy disk, tape, or JAZ or ZIP disk) to be ejected under software control."
HOMEPAGE = "http://eject.sourceforge.net/"
LICENSE = "GPLv2"

inherit autotools gettext

SRC_URI = "http://sources.openembedded.org/eject-2.1.5.tar.gz"

S = "${WORKDIR}/${PN}"

