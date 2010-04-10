SECTION = "console/network"
DEPENDS = "liblockfile"
RRECOMMENDS = "ssmtp"
DESCRIPTION = "mailx is the traditional command-line-mode \
mail user agent."
PR = "r0"
LICENSE = "GPL"
SRC_URI = "${DEBIAN_MIRROR}/main/m/mailx/mailx_${PV}.orig.tar.gz \
	   ${DEBIAN_MIRROR}/main/m/mailx/mailx_${PV}-1.diff.gz;patch=1 \
	   file://install.patch;patch=1"
S = "${WORKDIR}/mailx-${PV}.orig"

CFLAGS_append = " -D_BSD_SOURCE -DDEBIAN -I${S}/EXT"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[md5sum] = "3ba08abd8bbd0a87ea5bad05cded3bc3"
SRC_URI[sha256sum] = "5c578a8c573b4430358d4f6523f8acd8b2c5039579d907c88ec09dab13b226d3"
SRC_URI[md5sum] = "38de40f8b082f4d592262c04275e2f30"
SRC_URI[sha256sum] = "2fb891f912624766d0bef765d69cec75ad3334dda1aa58659f3c3c1d0579c2c3"
