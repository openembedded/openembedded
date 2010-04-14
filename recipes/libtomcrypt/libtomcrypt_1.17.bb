DESCRIPTION = "LibTomCrypt is a fairly comprehensive, modular \
and portable cryptographic toolkit that provides developers \
with a vast array of well known published block ciphers, \
one-way hash functions, chaining modes, pseudo-random number \
generators, public key cryptography and a plethora of other \
routines."
SECTION = "libs/network"
PRIORITY = "optional"
LICENSE = "PD"
PR = "r0"

SRC_URI = "http://libtom.org/files/crypt-${PV}.tar.bz2"

inherit autotools

EXTRA_OEMAKE = "library"

#FIXME add patch to make it shared

do_stage() {
	oe_libinstall -a libtomcrypt ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/headers/*.h ${STAGING_INCDIR}/
}

do_install() {
	:
}

SRC_URI[md5sum] = "cea7e5347979909f458fe7ebb5a44f85"
SRC_URI[sha256sum] = "e33b47d77a495091c8703175a25c8228aff043140b2554c08a3c3cd71f79d116"
