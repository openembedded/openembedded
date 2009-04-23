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
