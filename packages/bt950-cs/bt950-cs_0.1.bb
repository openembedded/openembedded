DESCRIPTION = "Linux driver for OX16C950 UART Bluetooth cards"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.holtmann.org/linux/bluetooth/bt950.html"
DEPENDS = "pcmcia-cs"
RDEPENDS = "pcmcia-cs"

SRC_URI = "http://www.holtmann.org/linux/bluetooth/bt950-${PV}.tar.gz \
file://makefile.patch;patch=1"

S = "${WORKDIR}/bt950-${PV}"

PACKAGES = "kernel-module-bt950-cs"
FILES_kernel-module-bt950-cs = "/etc/pcmcia/bt950.conf /lib/modules/${KERNEL_VERSION}/kernel/drivers/bluetooth/bt950_cs.o"

inherit module

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/bluetooth/ \
				${D}${sysconfdir}/pcmcia/
	install -m 0644 bt950_cs.o ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/bluetooth/
	install -m 0644 bt950.conf ${D}${sysconfdir}/pcmcia/
}

pkg_postinst() {
#!/bin/sh
if [ "x$D" != "x" ]; then
  exit 1
fi
update-modules || true
}

pkg_postrm() {
#!/bin/sh
update-modules || true
}

