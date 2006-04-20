DESCRIPTION = "Amiga Emulator based on SDL"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://rcdrummond.net/uae/old/e-uae-${PV}/e-uae-${PV}.tar.bz2 \
           file://configure.patch;patch=1"
#           file://m4.patch;patch=1"

inherit autotools 

EXTRA_OECONF = "--with-hostcc=gcc --disable-ui --without-x \
		--without-gtk --enable-jit --disable-natmem \
		--with-zlib=${STAGING_LIBDIR}/.. \
		--with-sdl-exec-prefix=${STAGING_BINDIR}/.. \
		--with-sdl-prefix=${STAGING_LIBDIR}/.."

CFLAGS_append = " -DSTAT_STATFS2_BSIZE=1 "
CXXFLAGS_append = " -DSTAT_STATFS2_BSIZE=1 "
PARALLEL_MAKE = ""

do_configure_prepend () {
	touch NEWS AUTHORS ChangeLog
}

do_install_append() {
# Packages NEVER, ever, ever, ever touch home directories directly.
# ever.
# Either update a global config in /etc, install it into /etc/skel/ for
# new users homedirs, rely on the user installing it to put it in place,
# or dont install it at all.  --CL
#	install -d ${D}/home/root
#	install ${FILESDIR}/uaerc ${D}/home/root/.uaerc
}
