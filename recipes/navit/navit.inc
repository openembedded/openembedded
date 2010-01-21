DESCRIPTION = "Navit is a car navigation system with routing engine."
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS = "glib-2.0 gtk+"
RRECOMMENDS = "gpsd speechd flite"

PE = "1"
INC_PR = "r5"

inherit autotools

EXTRA_OECONF = " \
  --disable-binding-python \
  --disable-gui-sdl \
  --disable-samplemap \
  --enable-avoid-unaligned \
  --disable-graphics-qt-qpainter \
"

#  --enable-avoid-float \
#check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require navit-fpu.inc
EXTRA_OECONF += "${@get_navit_fpu_setting(bb, d)}"

PACKAGES = "${PN}-dbg ${PN}-dev ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN} += "${libdir}/${PN}/*/*.so"
FILES_${PN}-dbg += "${libdir}/${PN}/*/.debug"

SRC_URI_append = " \
                  file://navit.desktop \
                  file://navit.png \
	  	 "

do_install_append() {
        install -d ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/navit.desktop ${D}${datadir}/applications/
        install -d ${D}${datadir}/pixmaps/
        install -m 0644 ${WORKDIR}/navit.png ${D}${datadir}/pixmaps/

	rm ${D}${libdir}/${PN}/*/*.la
}
