SECTION = "console/network"
DEPENDS = "liblockfile"
DESCRIPTION = "mailx is the traditional command-line-mode \
mail user agent."
LICENSE = "GPL"
SRC_URI = "${DEBIAN_MIRROR}/main/m/mailx/mailx_${PV}.orig.tar.gz \
	   ${DEBIAN_MIRROR}/main/m/mailx/mailx_${PV}-1.diff.gz;patch=1 \
	   file://install.patch;patch=1"
S = "${WORKDIR}/mailx-${PV}.orig"

CFLAGS_append = " -D_BSD_SOURCE -DDEBIAN -I${S}/EXT"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}
