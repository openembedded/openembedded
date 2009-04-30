DESCRIPTION = "Duke Nukem 3D game engine"
LICENSE = "GPLv2"
DEPENDS = "virtual/libsdl libsdl-mixer"

SRCREV = "185"
PV = "0.0+svnr${SRCPV}"

SRC_URI = "svn://svn.icculus.org/duke3d/;module=trunk \
           file://duke3d.desktop"

S = "${WORKDIR}/trunk/source"

PARALLEL_MAKE = ""

do_compile() {
	for i in $(find ${S} -name 'Makefile') ; do
		sed -i s:\ gcc:\ '${CC}': $i
	done
	make
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/duke3d ${D}${bindir}/
	install -d ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/duke3d.desktop ${D}${datadir}/applications/
}
