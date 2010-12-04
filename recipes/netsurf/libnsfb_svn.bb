DESCRIPTION = "LibNSFB is a framebuffer abstraction library, written in C"
HOMEPAGE = "http://www.netsurf-browser.org/projects/libnsfb/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS = "xcb-util"

SRCREV = "10944"
PV = "0.0.1+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.netsurf-browser.org/trunk;module=libnsfb \
	   file://no-werror.patch"

S = ${WORKDIR}/libnsfb

inherit pkgconfig

EXTRA_OEMAKE = "CURDIR=${S} DESTDIR=${D} PREFIX=${prefix} BUILDDIR=build-OE"

# NOTE: we're using default buildmode here, which results in building only
# static libraries (.a) Not a problem as libnsbmp is only used by Netsurf
# at the moment

do_stage() {
	oe_libinstall -a -C build-OE/ libnsfb ${STAGING_LIBDIR}
	install -m 0644 build-OE/libnsfb.pc ${STAGING_LIBDIR}/pkgconfig
	install -m 0644 include/*.h ${STAGING_INCDIR}/
}

do_install() {
	oe_runmake install
}
