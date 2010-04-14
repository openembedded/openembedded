DESCRIPTION = "OLSR mesh routing daemon"
HOMEPAGE = "http://www.olsr.org"
DESCRIPTION_olsrd-libs = "OLSR mesh routing daemon -  optional libraries"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "BSD"

MAJ_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI="http://www.olsr.org/releases/${MAJ_VER}/olsrd-${PV}.tar.bz2 \
	file://init \
	file://olsrd.conf"

PACKAGES =+ "olsrd-libs"
FILES_olsrd-libs = "${libdir}"

S = "${WORKDIR}/olsrd-${PV}"

inherit update-rc.d

INITSCRIPT_NAME = "olsrd"
INITSCRIPT_PARAMS = "defaults"

do_compile() {
	touch .depend
	touch src/cfgparser/.depend
	oe_runmake OS=linux all libs
}

do_install () {
	oe_runmake INSTALL_PREFIX=${D} install install_libs
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/olsrd
	install -m 644 ${WORKDIR}/olsrd.conf ${D}${sysconfdir}
}

CONFFILES_${PN} = "${sysconfdir}/olsrd.conf"

SRC_URI[md5sum] = "4d8636af067f90822a47a062497680de"
SRC_URI[sha256sum] = "b935aaf1e389f767ba8238c7a5c0b4387a345168acddf4f38bb6914149953a28"
