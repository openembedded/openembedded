DESCRIPTION = "Simple DirectMedia Layer - X11 Edition"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "alsa-lib mesa virtual/libx11 libxext"
DEPENDS_avr32 = "alsa-lib virtual/libx11 libxext"
PROVIDES = "virtual/libsdl"
LICENSE = "LGPL"
PR = "r4"

SRC_URI = "\
  http://www.libsdl.org/release/SDL-${PV}.tar.gz \
  file://extra-keys.patch;patch=1 \
  file://pagesize.patch;patch=1 \
  file://remove_path.patch;patch=1 \
  file://acinclude.m4"
S = "${WORKDIR}/SDL-${PV}"

inherit autotools binconfig

EXTRA_OECONF = "<overwrite me>"

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/*config"

do_configure_prepend() {
	rm -f ${S}/acinclude.m4
	cp ${WORKDIR}/acinclude.m4 ${S}/
}

do_configure_append () {
	cd ${S}

	# prevent libtool from linking libs against libstdc++, libgcc, ...
	cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
	mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool
}

do_stage() {
	oe_libinstall -so -C src libSDL ${STAGING_LIBDIR}
	rm ${STAGING_LIBDIR}/libSDL.la
	ln -sf libSDL.so ${STAGING_LIBDIR}/libSDL-1.2.so
	#oe_libinstall -a -C src/main libSDLmain ${STAGING_LIBDIR}
	install -m 0644 src/main/libSDLmain.a ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/SDL
	for f in include/*.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/SDL/
	done

	install -m 0644 *.m4 ${STAGING_DATADIR}/aclocal/
}
