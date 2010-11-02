DESCRIPTION = "UDEV Rules for BUG"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
RDEPENDS_${PN} = "udev"
PR = "r25"

SRC_URI = "file://00-bug20.rules \
	   file://bmi_eventpipe.sh \
	   file://bt_init.sh \
	   file://working.psr \
           file://mbkb-stop.sh \
           file://mbkb-start.sh \
           "

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}/etc/udev/rules.d
    install -d ${D}/etc/udev/scripts
    install -m 0644 *.rules ${D}/etc/udev/rules.d
    install -m 0775 *.sh ${D}/etc/udev/scripts
    install -m 0644 working.psr ${D}/etc/udev/scripts/
}    
