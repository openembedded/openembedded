DESCRIPTION = "The OpenMoko Media Player"
SECTION = "openmoko/applications"
DEPENDS += "alsa-lib dbus-glib id3lib libvorbis"
PV = "0.0.1+svnr${SRCREV}"
PR = "r1"

inherit openmoko

PARALLEL_MAKE =""

do_install_prepend() {
	touch mkinstalldirs
}


FILES_${PN} += " \
                ${datadir}/images \
		${libdir}/bmp/*/*.so \
	       "
