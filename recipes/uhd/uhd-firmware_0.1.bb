DESCRIPTION = "Universal Hardware Driver Firmware"
HOMEPAGE = "http://www.ettus.com"
LICENSE = "GPLv3"

SRC_URI = "http://www.ettus.com/downloads/uhd_images/UHD-images-20100901.003255.b5461fc%20--%20most%20recent/UHD-images-20100901.003255.b5461fc-Linux.tar.gz"

# Yes, matching the directory name to package version is annoying
S = ${WORKDIR}/UHD-images-20100901.003255.b5461fc-Linux

do_install() {
	install -d ${D}${datadir}/uhd/images
	install -m 0644 ${S}/share/uhd/images/* ${D}${datadir}/uhd/images
}

PACKAGES = "${PN}"
FILES_${PN} = ${datadir}/uhd/images

