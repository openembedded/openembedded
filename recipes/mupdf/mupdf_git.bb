DESCRIPTION = "A lightweight PDF viewer and toolkit written in portable C."
HOMEPAGE = "http://www.mupdf.com"
SECTION = "x11/applications"
LICENSE = "GPLv3"

SRCREV = "8147dd7fe7107de60f2c7de3bcd78e0048c26241"
PV = "0.7+gitr${SRCPV}"
PR = "r0"

DEPENDS = "openjpeg-native jbig2dec-native jpeg-native freetype-native libpng-native openjpeg jbig2dec jpeg zlib virtual/libx11 libxext freetype"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://mupdf.com/repos/mupdf.git;protocol=http \
		file://wintitle.patch"

S = "${WORKDIR}/git"

PACKAGES =+ "${PN}-tools ${PN}-tools-doc "
FILES_${PN}-tools = "${bindir}/pdfclean ${bindir}/pdfdraw ${bindir}/pdfshow \
                     ${bindir}/pdfextract ${bindir}/pdfinfo"
FILES_${PN}-tools-doc = "${mandir}/man1/pdfclean.1 ${mandir}/man1/pdfdraw.1 \
                         ${mandir}/man1/pdfshow.1"

# mupdf crashes when built with -ggdb3
# http://bugs.ghostscript.com/show_bug.cgi?id=691578
FULL_OPTIMIZATION := "${@oe_filter_out('-ggdb3', '${FULL_OPTIMIZATION}', d)}"

do_configure() {
    # we don't include CJK fonts to make binary more slim
    # comment out following two lines if you need support for CJK
    sed -i 's:^\t\$.GENDIR./font_cjk.c::g' ${S}/Makefile
    echo "CFLAGS += -DNOCJK" >> ${S}/Makerules
}

do_compile() {
    # mupdf uses couple of tools for code generation during build process
    # so we need to compile them first with host compiler
    unset CFLAGS LDFLAGS
    export PKG_CONFIG_PATH=${STAGING_LIBDIR_NATIVE}/pkgconfig
    oe_runmake build=release build/release
    oe_runmake build=release build/release/cmapdump LD="${BUILD_CC} -L${STAGING_LIBDIR_NATIVE} -Wl,-rpath,${STAGING_LIBDIR_NATIVE}" CC=${BUILD_CC}
    oe_runmake build=release build/release/fontdump LD="${BUILD_CC} -L${STAGING_LIBDIR_NATIVE} -Wl,-rpath,${STAGING_LIBDIR_NATIVE}" CC=${BUILD_CC}

    export PKG_CONFIG_PATH=${STAGING_LIBDIR}/pkgconfig
    # ...and then we fire 'make', feeding proper
    # cross-compilation flags through Makerules file
    echo "CFLAGS += ${CFLAGS}" >> ${S}/Makerules
    echo "LDFLAGS += ${LDFLAGS}" >> ${S}/Makerules
    oe_runmake build=release LD="${CC}"
}

do_install() {
    oe_runmake install build=release prefix="${D}/usr"
    install -d ${D}/${datadir}/applications
    install -d ${D}/${datadir}/pixmaps
    install -d ${D}/${mandir}/man1
    install -m 0644 ${S}/debian/mupdf.xpm ${D}/${datadir}/pixmaps/
    install -m 0644 ${S}/debian/mupdf.desktop ${D}/${datadir}/applications/
    install -m 0644 ${S}/debian/*.1 ${D}/${mandir}/man1/
}

