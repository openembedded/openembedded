DESCRIPTION="Ncurses library"
SECTION="libs"
DEPENDS=
SRC_URI = ${GNU_MIRROR}/ncurses/${P}.tar.gz \
	  file://${FILESDIR}/mk_shared_lib.patch;patch=1 \
	  file://${FILESDIR}/run_tic.patch;patch=1

inherit autotools

EXTRA_OECONF=--with-shared \
	     --without-profile \
	     --without-debug \
	     --disable-rpath \
	     --enable-echo \
	     --enable-const \
	     --without-ada \
	     --enable-termcap \
	     --without-cxx-binding \
	     --with-terminfo-dirs=/etc/terminfo:/usr/share/terminfo \
	     --enable-overwrite
export HOSTCCFLAGS=-I${S}/ncurses -I${S}/include ${BUILD_CFLAGS}
export HOSTLDFLAGS=
export LD := ${CC}

do_compile () {
	oe_runmake -C progs 'HOSTCC=${BUILD_CC}' 'HOSTLDFLAGS=' \
		   'HOSTCCFLAGS=${HOSTCCFLAGS}' 'CC=${BUILD_CC}' \
		   'LINK=${BUILD_CXX}' 'CFLAGS=${HOSTCCFLAGS}' \
		   'LDFLAGS=-lncurses' tic
	oe_runmake 'HOSTCC=${HOSTCC}' 'HOSTLDFLAGS=' 'HOSTCCFLAGS=${HOSTCCFLAGS}'
}

do_stage () {
	install -m 0755 lib/lib*.so.* ${STAGING_LIBDIR}/
	cp -R include/* ${STAGING_DIR}/target/include/
	ln -sf libpanel.so.${PV} ${STAGING_LIBDIR}/libpanel.so
	ln -sf libform.so.${PV} ${STAGING_LIBDIR}/libform.so
	ln -sf libmenu.so.${PV} ${STAGING_LIBDIR}/libmenu.so
	ln -sf libncurses.so.${PV} ${STAGING_LIBDIR}/libncurses.so
}
