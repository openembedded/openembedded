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
PR = "r0"

SRC_URI = "http://ubahnstation.net/source/ubahnnav-${PV}.tar.gz \
	   file://qmake.patch;patch=1"
S = "${WORKDIR}/ubahnnav-${PV}"

inherit opie

export OE_QMAKE_LINK="${CXX}"
EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${S}/src/libsubwaymap LIBS+=-L${S} LIBS-=-lqtopia"

do_configure_prepend() {
	find . -name "Makefile"|xargs rm -f
}

do_install() {
	oe_libinstall -so libsubwaymap ${D}${palmtopdir}/lib
	install -d ${D}${palmtopdir}/pics
	install -d ${D}${palmtopdir}/ubahn/maps
	touch ${D}${palmtopdir}/ubahn/maps/.empty
	install -m 0644 src/ubahnnav/images/u-logo.png ${D}${palmtopdir}/pics/ubahnnav.png
}

SRC_URI[md5sum] = "039d1215960b879d5b292e5b713ced8b"
SRC_URI[sha256sum] = "7007261ad816938ee4824720eb08e9bff4ad6f796965ec928f56acfa3c24a1b9"
