DESCRIPTION = "teTeX is a complete TeX distribution for UNIX compatible systems"
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "tetex-native flex gd ncurses libpng t1lib x11 xau xext xt zlib"
TETEX_BUILDSYSTEM_TAMER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r2"

SRC_URI = "ftp://dante.ctan.org/tex-archive/systems/unix/teTeX/current/distrib/tetex-src-${PV}.tar.gz \
           file://configure.patch;patch=1"
S = ${WORKDIR}/tetex-src-${PV}

inherit autotools

PARALLEL_MAKE = ""

export BUILDCC = "${BUILD_CC}"
export BUILDCFLAGS = "${BUILD_CFLAGS}"
export BUILDLDFLAGS = "${BUILD_LDFLAGS}"
export BUILDCCLD = "${BUILD_CC}"

EXTRA_OECONF = "--with-system-libgd \
		--with-system-ncurses \
		--with-ncurses-include=${STAGING_INCDIR} \
		--with-system-pnglib \
		--with-system-t1lib \
		--with-system-zlib \
		--without-dialog \
		--without-xdvik"

# NOTE:  In theory, teTeX has a good buildsystem, which automatically detects
#        whether we are cross-compiling and compiles the necessary host tools.
#        Unfortunately it doesn't work in our case and it looks easier to add
#        tetex-native for the time being. Cheers, Mickey.
do_configure () {
	oe_runconf
	ln -sf ${STAGING_BINDIR} ${S}/utils/texinfo/tools/info
	ln -sf ${STAGING_BINDIR} ${S}/utils/texinfo/tools/makeinfo
	cat >${S}/utils/texinfo/tools/Makefile <<EOF
install:
	echo "done"
all:
	echo "done"
EOF
}

# NOTE: This is really ugly. Unfortunately the teTeX people seem not to know about PREFIX...
do_install() {
	install -d ${D}${bindir}
	install -d ${D}${libdir}
	install -d ${D}${datadir}/texmf
	install -d ${D}${localstatedir}/lib/textmf

	export bindir="${D}${bindir}" \
	sbindir="${D}${sbindir}" \
	libexecdir="${D}${libexecdir}" \
	datadir="${D}${datadir}" \
	sysconfdir="${D}${sysconfdir}" \
	sharedstatedir="${D}${sharedstatedir}" \
	localstatedir="${D}${localstatedir}" \
	libdir="${D}${libdir}" \
	includedir="${D}${includedir}" \
	oldincludedir="${D}${oldincludedir}" \
	infodir="${D}${infodir}" \
	mandir="${D}${mandir}" \
	texmf="${D}${datadir}/texmf" \
	scriptdir="${D}${bindir}" \
	web2cdir="${D}${datadir}" \
	kpathsea="${D}${libdir}/libkpathsea.la" \
	DESTDIR=""
	MAKE="make -e" oe_runmake -e install
}

RRECOMMENDS_${PN} = "tetex-texmf-dvips tetex-texmf-texconfig tetex-texmf-fonts"
PACKAGES =+ "tetex-texmf-dvips tetex-texmf-texconfig tetex-texi2html"
FILES_${PN} += "${localstatedir} ${datadir}"
FILES_${PN}-doc += "${datadir}/texinfo ${datadir}/man ${datadir}/info"
FILES_tetex-texmf-dvips = "${datadir}/texmf/dvips"
FILES_tetex-texmf-texconfig = "${datadir}/texmf/texconfig"
FILES_tetex-texi2html = "${datadir}/texi2html"
