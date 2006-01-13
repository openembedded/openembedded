SECTION = "base"
PRIORITY = "optional"
DESCRIPTION = "Kernel module for the GameCube Hub input device"
DEPENDS = "virtual/kernel"
MAINTAINER = "Micah Dowty <micah@navi.cx>"
LICENSE = "GPL"
PV = "1:0.0+svn${SRCDATE}"

SRC_URI = "svn://svn.navi.cx/misc/trunk/wasabi/devices;module=gchub;proto=http"

S = "${WORKDIR}/gchub/kernel"

inherit module

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb
	install gchub.ko -m 0644 ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/usb/gchub.ko
}
