DESCRIPTION = "line breaking library"
HOMEPAGE = "https://sourceforge.net/projects/vimgadgets"
SECTION = "devel"
LICENSE = "Unicode"
PR = "r0"

SRC_URI = "${DEBIAN_MIRROR}/main/libl/liblinebreak/liblinebreak_${PV}.orig.tar.gz \
	file://liblinebreak-build-fix.patch;patch=1"

do_compile() {
	oe_runmake release
}

do_install() {
	install -d ${D}/usr/include
	install -d ${D}/usr/lib

        install -m 644 ${S}/linebreak.h ${D}/usr/include
        install -m 644 ${S}/ReleaseDir/liblinebreak.a ${D}/usr/lib
}

do_stage() {
        install -m 644 linebreak.h ${STAGING_INCDIR}
        install -m 644 ReleaseDir/liblinebreak.a ${STAGING_LIBDIR}
}

S = "${WORKDIR}/liblinebreak"
