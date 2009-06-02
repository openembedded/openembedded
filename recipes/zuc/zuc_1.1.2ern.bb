DESCRIPTION = "A Unit Conversion Tool"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
APPTYPE = "binary"
APPNAME = "zuc"
APPDESKTOP = "${S}"
PR = "r4"

SRC_URI = "http://www.linux-solutions.at/projects/zaurus/source/zuc_V${PV}.tar.gz \
           http://nick.kreucher.net/zuc/zuc_units \
           file://fixed-include.patch;patch=1"

S = "${WORKDIR}/zuc_V${PV}"

inherit opie

export OE_QMAKE_LINK="${CXX}"

do_configure_append() {
	echo "#define VERSION \""${PV}"\"" > version.h
	echo "#define BUILDTIME \""`date +%Y%m%d%H%M`"\"" >> version.h
}

do_install() {
	install -d ${D}${palmtopdir}/pics/
        install -m 0644 *.png ${D}${palmtopdir}/pics/
	install -d ${D}${palmtopdir}/etc/
	install -m 0644 ${WORKDIR}/zuc_units ${D}${palmtopdir}/etc/
}
