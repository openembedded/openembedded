DESCRIPTION = "Simple DirectMedia Layer - X11 Edition"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "alsa-lib virtual/libgl virtual/libx11 libxext"
DEPENDS_avr32 = "alsa-lib virtual/libx11 libxext"
PROVIDES = "virtual/libsdl"
LICENSE = "LGPL"

INC_PR = "r10"

SRC_URI = "\
  http://www.libsdl.org/release/SDL-${PV}.tar.gz \
  file://extra-keys.patch;patch=1 \
  file://pagesize.patch;patch=1 \
  file://remove_path.patch;patch=1 \
  file://acinclude.m4"
S = "${WORKDIR}/SDL-${PV}"

inherit autotools binconfig pkgconfig

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
	autotools_stage_all		
	rm ${STAGING_LIBDIR}/libSDL.la
}
