DESCRIPTION = 'The PCI Utilities package contains a library for portable access \
to PCI bus configuration space and several utilities based on this library.'
DESCRIPTION_pciutils-ids = 'The list of PCI IDs for pciutils'
SECTION = "console/utils"
HOMEPAGE = "http://atrey.karlin.mff.cuni.cz/~mj/pciutils.shtml"
LICENSE = "GPLv2"
DEPENDS = "zlib"

SRC_URI = "ftp://ftp.kernel.org/pub/software/utils/pciutils/pciutils-${PV}.tar.bz2 \
	   file://pciutils.patch;patch=1 "
SRC_URI_append_nylon = "file://gcc-3-compatibility.patch;patch=1 "

PARALLEL_MAKE = ""

PR ="r3"

EXTRA_OEMAKE += "'STRIP = '"
export SHARED=yes

do_configure () {
	(cd lib && ./configure ${datadir} ${PV} ${TARGET_OS} 2.4.21 ${TARGET_ARCH})
}

export DESTDIR = "${D}"
export PREFIX = "${prefix}"
export SBINDIR = "${sbindir}"
export SHAREDIR = "${datadir}"
export MANDIR = "${mandir}"
export IDSDIR = "${datadir}"

do_install () {
	oe_runmake install
}

do_install_append () {
	install -d ${D}/${datadir}
	install -m 6440 ${WORKDIR}/${PN}-${PV}/pci.ids.gz ${D}/${datadir}

	# The makefile does not install the development files:
	# libpci.so pci.h header.h config.h types.h
	install -d ${D}/${libdir}
	install -d ${D}/${includedir}/pci

	oe_libinstall -so -C lib libpci ${D}/${libdir}
	install -m 0644 ${S}/lib/pci.h ${D}/${includedir}/pci/
	install -m 0644 ${S}/lib/header.h ${D}/${includedir}/pci/
	install -m 0644 ${S}/lib/config.h ${D}/${includedir}/pci/
	install -m 0644 ${S}/lib/types.h ${D}/${includedir}/pci/
}

do_stage () {
	oe_libinstall -so -C lib libpci ${STAGING_LIBDIR}
	install -m 0755 -d ${STAGING_INCDIR}/pci
	install -m 0644 ${S}/lib/pci.h ${STAGING_INCDIR}/pci/
	install -m 0644 ${S}/lib/header.h ${STAGING_INCDIR}/pci/
	install -m 0644 ${S}/lib/config.h ${STAGING_INCDIR}/pci/
	install -m 0644 ${S}/lib/types.h ${STAGING_INCDIR}/pci/
}


PACKAGES =+ "pciutils-ids"
FILES_pciutils-ids="${datadir}/pci.ids.gz"
