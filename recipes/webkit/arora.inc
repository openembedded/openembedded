DESCRIPTION = "Arora is a lightweight cross-platform web browser"
LICENE = "GPLv2"
HOMEPAGE = "http://code.google.com/p/arora/"

PR = "r2"

SRC_URI = "http://arora.googlecode.com/files/arora-${PV}.tar.gz"

S = "${WORKDIR}/arora-${PV}"

do_configure_prepend() {
	sed -i -e s:lrelease-qt4:${OE_QMAKE_LRELEASE}:g ${S}/src/locale/locale.pri
}

# Huge hack ahead:
# Something is putting '.libs' in the Makefiles, which we do now want. The problem is that qmake generates makefiles during 'make all' *sigh*
do_compile_prepend() {
	( oe_runmake src/Makefile tools/Makefile
	  cd ${S}/tools ; oe_runmake cacheinfo/Makefile htmlToXBel/Makefile placesimport/Makefile
	)

	for i in $(find ${S} -name 'Makefile') ; do
		sed -i -e 's:/.libs::g' $i
		make || true
	done

}

do_install() {
	sed -i -e s:/usr/local:${D}${prefix}:g install.pri	
	sed -i -e s:$(INSTALL_ROOT)/OE/angstrom-dev/work/armv7a-angstrom-linux-gnueabi/arora-0.10.1-r0/image/:$(INSTALL_ROOT)/:g src/Makefile

	for i in $(find ${S} -name 'Makefile') ; do
		sed -i -e s:/usr/local:${prefix}:g $i
	done

	oe_runmake -e INSTALL_ROOT=${D} install
	cp -r ${D}/${D}/* ${D}/ || true
	cp -r ${D}/usr/local/* ${D}${prefix} || true
	rm -rf ${D}/usr/local ${D}/${D}
}

FILES_${PN} += "${datadir}/arora ${datadir}/gnome-control-center ${datadir}/icons"


