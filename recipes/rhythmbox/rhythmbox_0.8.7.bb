LICENSE = "GPL"
SECTION = "unknown"
PR = "r0"

inherit gnome

SRC_URI += "file://ogg.m4 file://vorbis.m4"

DEPENDS = "gstreamer gst-plugins libgnomeui"

EXTRA_OECONF = "--disable-schemas-install"

FILES_${PN} += " ${libdir}/bonobo/servers ${libdir}/bonobo/*.so ${datadir}/omf ${datadir}/mime-info \
	${datadir}/application-registry ${datadir}/gnome-2.0 ${datadir}/idl"
FILES_${PN}-doc += " ${datadir}/gnome/help"
FILES_${PN}-dev += " ${libdir}/bonobo/*.la ${libdir}/bonobo/*.a"

RDEPENDS_${PN} = "gst-plugin-gnomevfs gst-plugin-esd gst-plugin-mad gst-plugin-ivorbis"

do_configure_prepend() {
	mkdir -p ${S}/m4
	cp ${WORKDIR}/ogg.m4 ${S}/m4/
	cp ${WORKDIR}/vorbis.m4 ${S}/m4/
}

do_compile() {
	oe_runmake ORBIT_IDL=`which orbit-idl-2`
}
