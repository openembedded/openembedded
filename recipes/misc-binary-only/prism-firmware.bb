DESCRIPTION = "Firmware for the Prism 2.x/3 cards"
SECTION = "base"
LICENSE = "closed"
RDEPENDS = "hostap-utils"
RREPLACES = "prism3-firmware prism3-support"
RCONFLICTS = "prism3-firmware prism3-support"
PACKAGE_ARCH = "all"
PR = "r3"

SRC_URI = "http://www.red-bean.com/~proski/firmware/primary.tar.bz2;name=primary \
           http://www.red-bean.com/~proski/firmware/1.7.4.tar.bz2;name=174 \
           file://prism-fw.sh \
	   file://hostap.rules"

do_install() {
	install -d ${D}${base_libdir}/firmware/
	install -d ${D}${base_libdir}/udev/
	install -d ${D}${sysconfdir}/pcmcia/
	install -d ${D}${sysconfdir}/udev/rules.d/

	install -m 0644 ${WORKDIR}/primary/af010104.hex ${D}${base_libdir}/firmware/
	install -m 0644 ${WORKDIR}/primary/ak010104.hex ${D}${base_libdir}/firmware/
	install -m 0644 ${WORKDIR}/primary/pm010102.hex ${D}${base_libdir}/firmware/

	install -m 0644 ${WORKDIR}/1.7.4/rf010704.hex ${D}${base_libdir}/firmware/

	install -m 0755 ${WORKDIR}/prism-fw.sh ${D}${base_libdir}/udev/
	install -m 0644 ${WORKDIR}/hostap.rules ${D}${sysconfdir}/udev/rules.d/
}

FILES_${PN} += "${base_libdir}"

SRC_URI[primary.md5sum] = "0c7c82264602ee2b7ad832d5cd1e1940"
SRC_URI[primary.sha256sum] = "3b5bd68653ff5054586f9fad7ad729bd2d551e76949aec2d14b8a89308393a36"
SRC_URI[174.md5sum] = "ff4a902f62b8a8c4ccf1474ce27bee41"
SRC_URI[174.sha256sum] = "2660ad1f217e2cff5465cfb90b0cc2d5a6c57653fe769591af31da2e4f860c14"
