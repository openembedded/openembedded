DESCRIPTION = "Hierarchical note manager (aka. outliner)"
AUTHOR = "Miroslav Rajcic <miroslav.rajcic@inet.hr>"
HOMEPAGE = "http://notecase.sourceforge.net/"
SECTION = "x11/utils"
LICENSE = "BSD"
DEPENDS = "zlib gtk+ gnome-vfs"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}_src.tar.gz \
           file://no-hardcoded-cxx.patch;patch=1"

do_compile_prepend() {
        cp ${STAGING_LIBDIR}/libz.a ${S}/src/lib/zlib/
}
