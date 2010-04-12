DESCRIPTION = "matchbox-keyboard layouts control application"
AUTHOR = "Sergey Lapin"
SECTION = "x11"
LICENSE = "GPL"
DEPENDS = "gtk+"
PR = "r5"

PV = "0.0+git5b42aeff36d930dc3a9b75eedc74dacfec45f43f"

SRC_URI = "http://linux-h4000.sourceforge.net/mirror/mk-layouts-gui.git_5b42aeff36d930dc3a9b75eedc74dacfec45f43f.tar.gz \
#git://ossfans.org/home/slapin/git/mk-layouts-gui.git;protocol=git;tag=5b42aeff36d930dc3a9b75eedc74dacfec45f43f \
           file://auto-mkdir.patch;patch=1 \
	   file://sanitize-desktop-file.patch;patch=1 \
	   file://mboxkbd-layouts-gui.png"

S = "${WORKDIR}/git"

inherit autotools

do_install_append() {
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/mboxkbd-layouts-gui.png ${D}${datadir}/pixmaps/
}

SRC_URI[md5sum] = "bae81f5b80e7e923ee32e1b10c87de7f"
SRC_URI[sha256sum] = "593d74ba14e8f1c6263f612f0f5ee53eb4a41d05d873d0019aa1542e6971a952"
