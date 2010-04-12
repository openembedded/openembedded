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

SRC_URI[md5sum] = "e898200ac89815365e89b7c6cc2f78fd"
SRC_URI[sha256sum] = "f23ac7320379d8e950340fe37633c21a56a5f4320d29c34a65819558fe6cdaa1"
