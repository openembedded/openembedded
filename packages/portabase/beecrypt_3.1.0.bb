SECTION = "console/utils"
DESCRIPTION = "BeeCrypt is an ongoing project to provide a strong and fast cryptography \
toolkit. Includes entropy sources, random generators, block ciphers, hash functions, \
message authentication codes, multiprecision integer routines, and public key primitives."

HOMEPAGE = "http://sourceforge.net/projects/beecrypt/"
LICENSE = "LGPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/beecrypt/beecrypt-${PV}.tar.gz \
file://config.m4 \
file://gas.patch;patch=1 \
file://m4.diff;patch=1"
PR = "r1"

inherit autotools

do_configure_prepend() {

cp ${WORKDIR}/config.m4 ${S}/gas/

}


do_stage() {
	
#	oe_libinstall  -a  -C .libs libbeecrypt  ${STAGING_LIBDIR}
	cp .libs/libbeecrypt.a ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/
	install -d ${STAGING_INCDIR}/beecrypt
	for X in beecrypt.h beecrypt.api.h memchunk.h mpnumber.h beecrypt.gnu.h mp.h mpopt.h blockmode.h endianness.h
	do
		install -m 0644 ${X} ${STAGING_INCDIR}/beecrypt/${X}
	done

}
