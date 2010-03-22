DESCRIPTION = "A general purpose cryptographic library based on the code from GnuPG"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL FDL"
DEPENDS = "libgpg-error"

SRC_URI = "ftp://ftp.gnupg.org/gcrypt/libgcrypt/libgcrypt-${PV}.tar.gz \
           file://add-pkgconfig-support.patch;patch=1 \
           file://mips-h-constraint.patch;patch=1"

inherit autotools binconfig pkgconfig lib_package

EXTRA_OECONF = "--without-pth --disable-asm --with-capabilities"

ARM_INSTRUCTION_SET = "arm"

do_install_append() {
	install -d ${D}/${libdir}/pkgconfig/
	cp ${S}/src/*.pc ${D}/${libdir}/pkgconfig/
}

BBCLASSEXTEND = "native"
