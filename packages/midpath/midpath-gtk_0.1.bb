
require midpath.inc

DEPENDS += "gtk+"

do_configure() {
	
	cd ${S}/resources-embedded/com/sun/midp/configuration
	sed -i -e "s|ui.backend:AWT|ui.backend:GTK|" configuration.cfg

	cd ${S}/native/gtk
        sed -i -e "s|\-I/usr/include/classpath|\-I${STAGING_INCDIR}/classpath-minimal|" Makefile

}

do_compile() {

# Build the GTK native part
cd ${S}/native/gtk
make || exit 1

}

do_install() {
	install -d ${D}${libdir}
	install -m 0644 ${S}/native/gtk/libmidpathgtk.so ${D}${libdir}
	install -d ${D}${datadir}/java/resources-embedded/com/sun/midp/configuration
	install -m 0644 resources-embedded/com/sun/midp/configuration/configuration.cfg ${D}${datadir}/java/resources-embedded/com/sun/midp/configuration/
}

do_stage() {
	:
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${libdir}/libmidpathgtk.so \
		${datadir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg \
	       "
CONFFILES_${PN} = "${datadir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg"
