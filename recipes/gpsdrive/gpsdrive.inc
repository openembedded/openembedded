DESCRIPTION = "GPS navigation/map display software"
HOMEPAGE = "http://www.gpsdrive.de/"
AUTHOR = ""Fritz Ganter gpsdrive@warbase.selwerd.nl"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libc gtk+ libpcre gpsd"
RDEPENDS_${PN} = "gdk-pixbuf-loader-gif gpsd" 

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-garmin"

CFLAGS += "-D_GNU_SOURCE"

do_install_append() {
        mkdir -p  ${D}${datadir}/applications
        install -m 0644 ${WORKDIR}/*.desktop ${D}${datadir}/applications/gpsdrive.desktop

        # gpsd is provided by RDEPENDS
        if test -e ${D}${bindir}/gpsd
        then
                rm ${D}${bindir}/gpsd
        fi
}
