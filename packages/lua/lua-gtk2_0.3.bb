DESCRIPTION = "GTK bindings for LUA"
LICENSE = "GPL2"
PRIORITY = "optional"
DEPENDS = "gtk+ lua-native perl-native readline libffi"
RDEPENDS = "lua"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
SECTION = "libs"

inherit gpe

SRC_URI = "http://luaforge.net/frs/download.php/989/${P}.tar.gz \
	file://lua-gtk2-0.3_fixbuild.patch;patch=1"

FILES_${PN} =  "${datadir}/lua   ${libdir}/lua50"

CFLAGS_append = " -I '${S}/build-linux' -I src -DLINUX -I${STAGING_INCDIR} -L${STAGING_LIBDIR} -L${STAGING_LIBDIR}/../../${BUILD_SYS}/lib"

do_compile () {
	oe_runmake PREFIX='${prefix}' HGCC='${BUILD_CC}' LIBDIR='${STAGING_LIBDIR}' ODIR='build-linux/' CFLAGS='${CFLAGS}'
}

do_configure_append () {
	cd ${S} && mkdir build-linux
}
