SECTION = "base"
LICENSE = "GPL"
SRC_URI = "cvs://anonymous@cvs.berlios.de/cvsroot/at76c503a;module=at76c503a"
S = "${WORKDIR}/at76c503a"
PR = "r1"
PV = "0.0cvs${CVSDATE}"

inherit module

MODULES = at76c503.o at76_usbdfu.o at76c503-i3861.o at76c503-rfmd.o at76c503-rfmd-acc.o \
          at76c505-rfmd.o at76c503-i3863.o at76c505-rfmd2958.o

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

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/
	for i in ${MODULES}; do install -m 0644 $i ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/$i; done

	if [ "${MACHINE}" = "h3900" ]; then
		install -d ${D}${sysconfdir}/modutils
		echo "at76c503-rfmd" > ${D}${sysconfdir}/modutils/at76c503-rfmd
	fi
}
