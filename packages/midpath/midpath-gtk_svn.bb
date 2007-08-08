
require midpath_${PV}.bb

DEPENDS += "gtk+"
RDEPENDS = "gtk+"

do_configure() {
	
	cd ${S}/resources-embedded/com/sun/midp/configuration
	sed -i -e "s|ui.backend:AWT|ui.backend:GTK|" configuration.cfg

	cd ${S}/native/gtk
        sed -i -e "s|\-I/usr/include/classpath|\-I${STAGING_INCDIR}/classpath-minimal|" Makefile

}

do_compile() {

mkdir -p ${S}/dist

# Build the GTK native part
cd ${S}/native/gtk
make || exit 1
cp *.so ${S}/dist

}

do_install() {
	install -d ${D}${libdir}
	install -m 0644 dist/libmidpathgtk.so ${D}${libdir}
	install -d ${D}${libdir}/java/resources-embedded/com/sun/midp/configuration
	install -m 0644 resources-embedded/com/sun/midp/configuration/configuration.cfg ${D}${libdir}/java/resources-embedded/com/sun/midp/configuration/
}

do_stage() {
	:
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${libdir}/libmidpathgtk.so \
		${libdir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg \
	       "
