DESCRIPTION = "Keyed-Hashing for Message Authentication"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += "libdigest-sha1-perl perl-module-extutils-makemaker perl-module-digest-md5"

BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/Digest-HMAC-${PV}.tar.gz;name=digest-hmac-perl-${PV}"
SRC_URI[digest-hmac-perl-1.02.md5sum] = "64c4b247d83cd64ec32aa22bf58a709b"
SRC_URI[digest-hmac-perl-1.02.sha256sum] = "d0043b2fb5d38b571c11afbb424a1e6952b0f230da68525b14e8435830fd02f1"

S = "${WORKDIR}/Digest-HMAC-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
