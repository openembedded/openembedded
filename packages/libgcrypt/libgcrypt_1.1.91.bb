PR = "r3"
DESCRIPTION = "A general purpose cryptographic library based on the code from GnuPG"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL FDL"
DEPENDS = "libgpg-error"

PACKAGES =+ "libgcrypt-pthread libgcrypt-pthread-dev"

# move libgcrypt-config into -dev package
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}"
FILES_libgcrypt-pthread = "${libdir}/libgcrypt-pthread.so.*"
FILES_libgcrypt-pthread-dev = "${libdir}/libgcrypt-pthread.*"

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/alpha/libgcrypt/libgcrypt-${PV}.tar.gz"

inherit autotools binconfig

EXTRA_OECONF = "--without-pth"

do_stage() {
	oe_libinstall -so -C src libgcrypt ${STAGING_LIBDIR}
	oe_libinstall -so -C src libgcrypt-pthread ${STAGING_LIBDIR}
	install -m 0755 src/libgcrypt-config ${STAGING_BINDIR}/

	install -d ${STAGING_INCDIR}/
	for X in gcrypt.h gcrypt-module.h
	do
		install -m 0644 src/${X} ${STAGING_INCDIR}/${X}
	done

}
