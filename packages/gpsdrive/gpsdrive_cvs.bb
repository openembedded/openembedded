inherit autotools pkgconfig

PR = "r1"
PV = "2.10pre3+cvs-${CVSDATE}"
DEFAULT_PREFERENCE="-1"

PACKAGES += "gpsdrive-add"
DESCRIPTION = "GPS navigation/map display software"
DEPENDS = "virtual/libc libart-lgpl gtk+ pcre gpsd"
RDEPENDS_${PN} = "gdk-pixbuf-loader-gif gpsd"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "cvs://anonymous@cvs.gpsdrive.cc/cvsroot;module=gpsdrive \
           file://gpsdrive.desktop"

S = "${WORKDIR}/gpsdrive"
CFLAGS += "-D_GNU_SOURCE"

FILES_${PN} = "${bindir}/gpsdrive ${bindir}/wpcvt ${bindir}/wpget ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += "${datadir}/${PN}"

FILES_gpsdrive-add = "${libdir}"
 
EXTRA_OECONF = "--disable-garmin"

do_install_append () {
        mkdir -p  ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/gpsdrive.desktop ${D}${datadir}/applications/gpsdrive.desktop
}
