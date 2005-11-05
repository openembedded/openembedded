inherit autotools pkgconfig

PR = "r1"
DEFAULT_PREFERENCE="-1"

PACKAGES += "gpsdrive-add"
DESCRIPTION = "GPS navigation/map display software"
DEPENDS = "virtual/libc gtk+ pcre gpsd"
RDEPENDS_${PN} = "gdk-pixbuf-loader-gif gpsd"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.ostertag.name/tweety/Projekte/gpsdrive/gpsdrive-2.10pre3.tar.gz \
           file://gpsdrive.desktop"

CFLAGS += "-D_GNU_SOURCE"

FILES_${PN} = "${bindir}/gpsdrive ${bindir}/wpcvt ${bindir}/wpget ${datadir}/pixmaps ${datadir}/applications"
FILES_${PN} += "${datadir}/${PN}"

FILES_gpsdrive-add = "${libdir}"
 
EXTRA_OECONF = "--disable-garmin"

do_install_append () {
        mkdir -p  ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/gpsdrive.desktop ${D}${datadir}/applications/gpsdrive.desktop
}
