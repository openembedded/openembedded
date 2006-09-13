DESCRIPTION = "Amiga Emulator based on SDL"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl zlib"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://rcdrummond.net/uae/e-uae-${PV}/e-uae-${PV}.tar.bz2 \
           file://configure.patch;patch=1"

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
