DESCRIPTION = "GNU Portable Threads"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL FDL"
PR = "r1"

SRC_URI = "ftp://ftp.ossp.org/pkg/lib/pth/pth-${PV}.tar.gz"

inherit autotools

do_configure() {
	gnu-configize
	oe_runconf
}

do_stage() {
	oe_libinstall -so libpth ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/
	for X in pth.h
	do
		install -m 0644 ${S}/$X ${STAGING_INCDIR}/$X
	done

	install -d ${STAGING_DATADIR}/aclocal
	install pth.m4 ${STAGING_DATADIR}/aclocal/
}

SRC_URI[md5sum] = "f84a87295fef3b41499f3b728b1f0050"
SRC_URI[sha256sum] = "1935a06368c1555d5f80329ba1e53f5b1a7dd9efb7fc9354427f2d1a583c81a3"
