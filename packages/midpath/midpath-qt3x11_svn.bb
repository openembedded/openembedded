
require midpath_${PV}.bb

DEPENDS += "qt-mt"
RDEPENDS = "qt-mt"
RCONFILCTS = "midpath-qte"

inherit qt3x11

do_configure() {
	
	cd ${S}/resources-embedded/com/sun/midp/configuration
	sed -i -e "s|ui.backend:AWT|ui.backend:QT|" configuration.cfg

	cd ${S}/native/qt
        sed -i -e "s|\-I/usr/include/classpath|\-I${STAGING_INCDIR}/classpath-minimal|" \
               -e "s|\`pkg\-config \-\-cflags qt\-mt\`|\-I${QTDIR}/include/ -DQT_THREAD_SUPPORT|" \
               -e "s|\`pkg\-config \-\-libs qt\-mt\`|\-L${QTDIR}/lib \-lqt-mt -lsupc++|" \
               Makefile
}

do_compile() {

mkdir -p ${S}/dist

# Build the QT native part
cd ${S}/native/qt
make || exit 1
cp *.so ${S}/dist

}

do_install() {
	install -d ${D}${libdir}
	install -m 0644 dist/libmidpathqt.so ${D}${libdir}
	install -d ${D}${libdir}/java/resources-embedded/com/sun/midp/configuration
	install -m 0644 resources-embedded/com/sun/midp/configuration/configuration.cfg ${D}${libdir}/java/resources-embedded/com/sun/midp/configuration/
}

do_stage() {
	:
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${libdir}/libmidpathqt.so \
		${libdir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg \
	       "
