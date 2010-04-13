
SECTION = "console/network"
DEPENDS = "liblockfile"
DESCRIPTION = "mailx is the traditional command-line-mode \
mail user agent."
LICENSE = "GPL"
SRC_URI = "${DEBIAN_MIRROR}/main/m/mailx/mailx_${PV}.orig.tar.gz;name=archive \
	   ${DEBIAN_MIRROR}/main/m/mailx/mailx_${PV}-4.diff.gz;patch=1;name=patch \
	   file://install.patch;patch=1"
S = "${WORKDIR}/mailx-${PV}.orig"

CFLAGS_append = " -D_BSD_SOURCE -DDEBIAN -I${S}/EXT"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[archive.md5sum] = "b7d8c2b5f64ac0b0ce51fdda482ec399"
SRC_URI[archive.sha256sum] = "b8a15528701669c728bbdc74060512eb41ce6284601c87f4ba6820b92380bec0"
SRC_URI[patch.md5sum] = "e51180fe1b43fcdf3125fd9be4734b0c"
SRC_URI[patch.sha256sum] = "131fe674be66bd3f464ee40aa457a9613f3d2a17ea83c724c4145a5d072a252e"
