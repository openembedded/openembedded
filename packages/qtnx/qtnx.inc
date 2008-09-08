DESCRIPTION = "This a the freesource nx client, build with qt"
HOMEPAGE = "http://freenx.berlios.de/"
SECTION = "libs"
LICENSE = "GPL"
PR = "r1"

DEPENDS = "libnxcl"

SRC_URI = "http://download.berlios.de/freenx/freenx-client-${PV}.tar.bz2 \
	   file://pro.patch;patch=1 \
	   file://id-path.patch;patch=1 \
	   file://scroll.patch;patch=1 \
	  "

S = "${WORKDIR}/freenx-client-${PV}/qtnx"

FILES_${PN} += ${datadir}/id.key

do_configure_prepend () {

	rm ${S}/qtnxwin32.pro

}

do_install () {
       install -d ${D}${bindir}/
       install -s -m 0755 qtnx ${D}${bindir}/
       install -d ${D}${datadir}/
       install -m 0644 id.key ${D}${datadir}/ 
}

