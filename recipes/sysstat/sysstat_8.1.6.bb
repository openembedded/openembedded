DESCRIPTION = "The sysstat utilities are a collection of performance monitoring tools for Linux."
HOMEPAGE = "http://pagesperso-orange.fr/sebastien.godard/"
LICENSE = "GPL"
SECTION = "console/utils"
PR = "r1"

SRC_URI = "http://pagesperso-orange.fr/sebastien.godard/sysstat-${PV}.tar.gz"

inherit autotools

do_configure_prepend() {
	sed -i s,'-g $(MAN_GROUP)','', Makefile.in
}

FILES_${PN} += "${libdir}/sa"

TARGET_CC_ARCH += "${LDFLAGS}"
