DESCRIPTION = "OLSR mesh routing daemon"
HOMEPAGE = "http://www.olsr.org"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "BSD"

MAJ_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"
SRC_URI = "http://www.olsr.org/releases/${MAJ_VER}/olsrd-${PV}.tar.bz2 \
	file://init \
	file://olsrd.conf"

S = "${WORKDIR}/olsrd-${PV}"

inherit update-rc.d

INITSCRIPT_NAME = "olsrd"
INITSCRIPT_PARAMS = "defaults"
EXTRA_OEMAKE = "MAKEFLAGS=-I${WORKDIR}/olsrd-${PV}"

do_configure() {
	oe_runmake OS=linux clean
}

do_compile() {
  oe_runmake OS=linux clean
  touch .depend
  touch src/cfgparser/.depend
  oe_runmake OS=linux all libs
}

do_install () {
	oe_runmake OS=linux INSTALL_PREFIX=${D} STRIP=echo install install_libs

	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/olsrd
	install -m 644 ${WORKDIR}/olsrd.conf ${D}/${sysconfdir}
}

PACKAGES =+ "\
  olsrd-plugin-dyngw \
  olsrd-plugin-dyngw-plain \
  olsrd-plugin-httpinfo \
  olsrd-plugin-nameservice \
  olsrd-plugin-quagga \
  olsrd-plugin-tas \
  olsrd-plugin-pgraph \
  olsrd-plugin-bmf \
  olsrd-plugin-txtinfo \
  olsrd-plugin-arprefresh \
  olsrd-plugin-secure \
  olsrd-plugin-dotdraw \
  olsrd-plugin-mini \
  "

FILES_olsrd-plugin-dyngw = "${libdir}/${PN}_dyn_gw.so.*"
FILES_olsrd-plugin-dyngw-plain = "${libdir}/${PN}_dyn_gw_plain.so.*"
FILES_olsrd-plugin-httpinfo = "${libdir}/${PN}_httpinfo.so.*"
FILES_olsrd-plugin-nameservice = "${libdir}/${PN}_nameservice.so.*"
FILES_olsrd-plugin-quagga = "${libdir}/${PN}_quagga.so.*"
FILES_olsrd-plugin-tas = "${libdir}/${PN}_tas.so.*"
FILES_olsrd-plugin-pgraph = "${libdir}/${PN}_pgraph.so.*"
FILES_olsrd-plugin-bmf = "${libdir}/${PN}_bmf.so.*"
FILES_olsrd-plugin-txtinfo = "${libdir}/${PN}_txtinfo.so.*"
FILES_olsrd-plugin-arprefresh = "${libdir}/${PN}_arprefresh.so.*"
FILES_olsrd-plugin-dotdraw = "${libdir}/${PN}_dot_draw.so.*"
FILES_olsrd-plugin-secure = "${libdir}/${PN}_secure.so.*"
FILES_olsrd-plugin-mini = "${libdir}/${PN}_mini.so.*"

CONFFILES_${PN} = "${sysconfdir}/olsrd.conf"

