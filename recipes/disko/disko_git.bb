DESCRIPTION = "Disko is an application framework, that can be used to develop GUI applications for embedded devices. It is closely connected to the DirectFB"
LICENSE = "GPL"
PV = "1.1.5+gitr${SRCREV}"
PR = "r0"

DEPENDS = "sqlite3 libpng jpeg curl alsa-lib taglib directfb libxml2 virtual/libx11 libsigc++-2.0 hal \
	   libxv libxxf86vm"

SRC_URI = "git://www.diskohq.org/disko.git;protocol=git \
	   file://linkpath.patch;patch=1 \
	   file://pkgconfig.patch;patch=1 \
	  "

SRCREV = "ed1d2905be5ae4fff37c498847c298fa501bbde1"

S = "${WORKDIR}/git"

inherit scons pkgconfig

do_compile() {
	${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} graphics=all PREFIX=${prefix} prefix=${prefix} || \
        oefatal "scons build execution failed."
}

#workaround for disko which creates .pc inside install
do_install_append () {

for i in `find ${S}/ ${D}/${libdir}/pkgconfig -name "*.pc" -type f` ; do \
            sed -i -e 's:${D}::g' $i
        done
}

scons_do_stage_append () {
        STAGE_PKG_SEARCHPATH="${S}/ ${@['','${WORKDIR}/staging-pkg/'][bb.data.inherits_class('packaged-staging',d)]}"
        for i in `find ${STAGE_PKG_SEARCHPATH} -name "*.pc" -type f` ; do \
            sed -i -e 's:${STAGING_DIR_HOST}::g' $i
        done
}
