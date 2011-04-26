DESCRIPTION = "Universal Hardware Driver Firmware"
HOMEPAGE = "http://www.ettus.com"
LICENSE = "GPLv3"

INC_PR = "r1"

PACKAGE_ARCH = "all"

#PV_U = `echo ${PV} | sed 's/\./_/g'`

SRC_URI = "http://www.ettus.com/downloads/uhd_releases/${@'${PV}'.replace('.', '_')}/images-only/UHD-images-${PV}.tar.gz"

S = ${WORKDIR}/UHD-images-${PV}

do_install() {
	install -d ${D}${datadir}/uhd/images
	install -m 0644 ${S}/share/uhd/images/* ${D}${datadir}/uhd/images
}

PACKAGES = "${PN}"
FILES_${PN} = ${datadir}/uhd/images

