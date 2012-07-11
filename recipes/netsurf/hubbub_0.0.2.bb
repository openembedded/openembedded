DESCRIPTION = "Hubbub is an HTML5 compliant parsing library"
HOMEPAGE = "http://www.netsurf-browser.org/projects/hubbub/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS = "libparserutils"

PR = "r1"

SRC_URI = "http://download.netsurf-browser.org/libs/releases/hubbub-${PV}-src.tar.gz"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as hubbub is only used by Netsurf
# at the moment

do_stage() {
        oe_libinstall -a -C build-OE/ libhubbub ${STAGING_LIBDIR}
        install -m 0644 build-OE/libhubbub.pc ${STAGING_LIBDIR}/pkgconfig
        install -d ${STAGING_INCDIR}/hubbub
        install -m 0644 include/hubbub/*.h ${STAGING_INCDIR}/hubbub
}


do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "dbdc6bb13a71ce72384d7ee5891a0382"
SRC_URI[sha256sum] = "fd195b91e80ef2ea1f558f94bd5bb5df89228b1af3e9b7c5c1039f65d506aa1d"
