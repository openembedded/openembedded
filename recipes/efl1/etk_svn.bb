DESCRIPTION = "Etk is an advanced widget toolkit based on the Enlightenment Foundation Libraries."
DEPENDS = "evas ecore edje"
LICENSE = "MIT"
PV = "0.1.0.042+svnr${SRCPV}"
PR = "r5"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/OLD;module=${SRCNAME};proto=http \
file://mkinstalldirs"

RRECOMMENDS_${PN} = "\
  etk-engines-software-x11 \
  etk-engines-evas \
  etk-engines-fb \
  etk-engines-x11 \
  etk-engines-software-x11-16 \
"

do_compile_prepend() {
	touch ${S}/po/etk.pot
	cp ${WORKDIR}/mkinstalldirs ${S}
	sed -i -e 's:@MKINSTALLDIRS@:${S}/mkinstalldirs:g' ${S}/po/Makefile
}

PACKAGES += "etk-engines-software-x11"
FILES_${PN}-engines-software-x11 = "${libdir}/etk/engines/ecore_evas_software_x11.so"

PACKAGES =+ "etk-engines-gl-x11"
FILES_${PN}-engines-gl-x11 = "${libdir}/etk/engines/ecore_evas_gl_x11.so"

PACKAGES =+ "etk-engines-evas"
FILES_${PN}-engines-evas = "${libdir}/etk/engines/ecore_evas.so"

PACKAGES =+ "etk-engines-fb"
FILES_${PN}-engines-fb = "${libdir}/etk/engines/ecore_fb.so"

PACKAGES =+ "etk-engines-x11"
FILES_${PN}-engines-x11 = "${libdir}/etk/engines/ecore_evas_x11.so"

PACKAGES =+ "etk-engines-software-x11-16"
FILES_${PN}-engines-software-x11-16 = "${libdir}/etk/engines/ecore_evas_software_x11_16.so"
