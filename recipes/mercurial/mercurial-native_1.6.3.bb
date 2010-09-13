DESCRIPTION = "The Mercurial distributed SCM"
HOMEPAGE = "http://mercurial.selenic.com/"
SECTION = "console/utils"
LICENSE = "GPLv2"
DEPENDS = "python-native"
PR = "r0"

SRC_URI = "http://mercurial.selenic.com/release/mercurial-${PV}.tar.gz;name=src"
SRC_URI[src.md5sum] = "fcd61edc488d1b9aa831dde6f14d9a13"
SRC_URI[src.sha256sum] = "57e5d26d35fbec71206378e3af111193e6eee7bb1dfb6447bbc4b9e03ce937bd"

S = "${WORKDIR}/mercurial-${PV}"

inherit native

EXTRA_OEMAKE = "STAGING_LIBDIR=${STAGING_LIBDIR} STAGING_INCDIR=${STAGING_INCDIR} \
        BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} PREFIX=${prefix}"

do_install () {
        oe_runmake -e install DESTDIR=${D} PREFIX=${prefix}
}
