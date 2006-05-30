DESCRIPTION = "Command line tool for GPE backlight control"
MAINTAINER = "Simon Pickering <S.G.Pickering@bath.ac.uk>"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "glib-2.0"

SRC_URI = "http://people.bath.ac.uk/enpsgp/Zaurus/bl/${PN}-${PV}.tar.gz"

inherit pkgconfig

FILES_${PN} = "${bindir}"

do_configure (){
}

do_compile (){
	oe_runmake bl CC="${CROSS_DIR}/bin/${TARGET_SYS}-gcc -I{STAGING_INCDIR} -L${STAGING_LIBDIR} -lglib-2.0" AS=${CROSS_DIR}/bin/${TARGET_SYS}-as LD=${CROSS_DIR}/bin/${TARGET_SYS}-ld
}

do_install () {
        install -d ${D}${bindir}
        install -m 4755 ${S}/bl ${D}${bindir}/bl
}
