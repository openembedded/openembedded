DESCRIPTION = "PC/SC Lite smart card framework and applications"
HOMEPAGE = "http://pcsclite.alioth.debian.org/"
LICENSE = "BSD"

DEPENDS = "hal"
RDEPENDS_${PN} = "hal"

SRC_URI = "https://alioth.debian.org/frs/download.php/2795/pcsc-lite-${PV}.tar.bz2 \
           file://pcscd.init "

inherit autotools_stage update-rc.d

INITSCRIPT_NAME = "pcscd"
INITSCRIPT_PARAMS = "defaults"

EXTRA_OECONF = " \
	--enable-libhal \
	--disable-libusb \
	--enable-usbdropdir=${libdir}/pcsc/drivers \
	"

do_install() {
	oe_runmake DESTDIR="${D}" install
	install -d "${D}/etc/init.d"
	install -m 755 "${WORKDIR}/pcscd.init" "${D}/etc/init.d/pcscd"
}

PACKAGES =+ "libpcsclite"

FILES_libpcsclite = "${libdir}/libpcsclite.so.*"

SRC_URI[md5sum] = "d7d466621bec39354351f09349f6374c"
SRC_URI[sha256sum] = "a0c11b0b5cc46d4c4ec499b875cfdc4e766fdf12fe2f6ea635e1b11ab7b8821e"
