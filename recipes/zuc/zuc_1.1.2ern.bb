DESCRIPTION = "A Unit Conversion Tool"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
APPTYPE = "binary"
APPNAME = "zuc"
APPDESKTOP = "${S}"
PR = "r4"

SRC_URI = "http://www.linux-solutions.at/projects/zaurus/source/zuc_V${PV}.tar.gz;name=archive \
           http://nick.kreucher.net/zuc/zuc_units;name=units \
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

SRC_URI[archive.md5sum] = "c4ed24fa825940f4803bd494fd9c12a6"
SRC_URI[archive.sha256sum] = "8e7d8d05bcc99203f4ca8231647b2a24d51b10abffeb00910cb6eeee85427f86"
SRC_URI[units.md5sum] = "0d4a28c847829208b0177483e174b3f5"
SRC_URI[units.sha256sum] = "3bc5735516b47874208b0efe23d498b8d43e51a140b3ff60683d5f1a951f50ac"
