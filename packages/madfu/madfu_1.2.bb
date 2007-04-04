DESCRIPTION = "Firmware loader for m-audio devices"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://heanet.dl.sourceforge.net/sourceforge/usb-midi-fw/madfuload-1.2.tar.gz \
           file://autofoo.patch;patch=1"

S = "${WORKDIR}/madfuload-1.2"

inherit autotools

do_configure() {
        oe_runconf
}
do_compile() {
        oe_runmake
}
do_install() {
        install -d ${D}/${sbindir}
        install -m 755 ${S}/madfuload ${D}/${sbindir}
        install -d ${D}/${libdir}/firmware
        install -m 644 ${S}/*.bin ${D}/${libdir}/firmware
        install -d ${D}/${sysconfdir}/udev/rules
        install -m 644 ${S}/42-madfuload.rules ${D}/${sysconfdir}/udev/rules
}

FILES_${PN} += "${libdir}/firmware/"
