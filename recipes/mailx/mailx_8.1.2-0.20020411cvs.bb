SECTION = "console/network"
DEPENDS = "liblockfile"
DESCRIPTION = "mailx is the traditional command-line-mode \
mail user agent."
LICENSE = "GPL"
SRC_URI = "${DEBIAN_MIRROR}/main/m/mailx/mailx_${PV}.orig.tar.gz;name=archive \
	   ${DEBIAN_MIRROR}/main/m/mailx/mailx_${PV}-1.diff.gz;patch=1;name=patch \
	   file://install.patch;patch=1"
S = "${WORKDIR}/mailx-${PV}.orig"

CFLAGS_append = " -D_BSD_SOURCE -DDEBIAN"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[archive.md5sum] = "61bb0ce78f7828b4fb9f6fe13eb4e425"
SRC_URI[archive.sha256sum] = "38fedc49b0b38018b3b5249499d28c6581b43a45a412f0c144341bee52575498"
SRC_URI[patch.md5sum] = "816b337e1fb83a2ebac164412f8ea1fe"
SRC_URI[patch.sha256sum] = "f37d1c04b88f430a77aea1bea7048e114dc37990e64a6b7d49974511c6d4b7e0"
