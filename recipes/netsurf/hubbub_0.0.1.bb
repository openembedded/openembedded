DESCRIPTION = "Hubbub is an HTML5 compliant parsing library"
HOMEPAGE = "http://www.netsurf-browser.org/projects/hubbub/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS = "libparserutils"

SRC_URI = "http://www.netsurf-browser.org/projects/releases/hubbub-${PV}-src.tar.gz \
           file://hubbub-uninitialised.patch;patch=1"

PR = "r1"

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as hubbub is only used by Netsurf
# at the moment

do_stage() {
        oe_libinstall -a -C build-OE/ libhubbub ${STAGING_LIBDIR}

        install -d ${STAGING_INCDIR}/hubbub
        install -m 0644 include/hubbub/*.h ${STAGING_INCDIR}/hubbub
}


do_install() {
	oe_runmake install
}

SRC_URI[md5sum] = "58c6e2b5a5906f3f0bf136c0c71b5403"
SRC_URI[sha256sum] = "3ba0bdf71376429bb3ce8ae51595fc25e6a5147cdcc26e47b6da17386eb78cdf"
