DESCRIPTION = "U-Bahn Navigator helps you navigating through foreign public \
transport networks. It finds the shortest or direct route from a start to a \
destination station of the loaded subway map. U-Bahn Navigator is extensible \
to support each public transport network."
PRIORITY = "optional"
SECTION = "opie/applications"
AUTHOR = "Dimitri Brukakis"
HOMEPAGE = "http://ubahnstation.net"
LICENSE = "GPL"
APPNAME = "ubahnnav"
APPTYPE = "binary"
APPDESKTOP = "${S}/src/ubahnnav"
PR = "r2"

SRC_URI = "http://ubahnstation.net/source/ubahnnav-${PV}.tar.gz \
	   file://qmake.patch;patch=1"
S = "${WORKDIR}/ubahnnav-${PV}"

inherit opie

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST = "LIBS+=-L${S} LIBS-=-lqtopia"

do_configure_prepend() {
	find . -name "Makefile"|xargs rm -f
}

do_install() {
	oe_libinstall -so libsubwaymap ${D}${palmtopdir}/lib
        install -d ${D}${palmtopdir}/pics ${D}${palmtopdir}/ubahn/maps
	touch ${D}${palmtopdir}/ubahn/maps/.empty
        install -m 0644 src/ubahnnav/images/u-logo.png ${D}${palmtopdir}/pics/ubahnnav.png
}
