DESCRIPTION = "Binary Chumby firmware for kexec"
PACKAGES = "${PN}-k2 ${PN}-rfs2 ${PN}-bl ${PN}-psp ${PN}-k1 ${PN}-rfs1"
PR = "r1"

SRC_URI = "http://files.chumby.com/resources/chumby_fw_1_2.zip"
S = ${WORKDIR}

PACKAGE_ARCH = "chumby"
COMPATIBLE_MACHINES = "chumby"

do_install () {
        cd ${S}/update1 && unzip k2.bin.zip
        cd ${S}/update1 && unzip rfs2.bin.zip
        cd ${S}/update2 && unzip bl.bin.zip
        cd ${S}/update2 && unzip psp.bin.zip
        cd ${S}/update2 && unzip k1.bin.zip
        cd ${S}/update2 && unzip rfs1.bin.zip

        install -d ${D}/boot/chumby-firmware/
        install -m 0644 ${S}/update1/k2.bin ${D}/boot/chumby-firmware/
        install -m 0644 ${S}/update1/rfs2.bin ${D}/boot/chumby-firmware/
        install -m 0644 ${S}/update2/bl.bin ${D}/boot/chumby-firmware/
        install -m 0644 ${S}/update2/psp.bin ${D}/boot/chumby-firmware/
        install -m 0644 ${S}/update2/k1.bin ${D}/boot/chumby-firmware/
        install -m 0644 ${S}/update2/rfs1.bin ${D}/boot/chumby-firmware/
}

FILES_${PN}-k2 = "/boot/chumby-firmware/k2.bin"
FILES_${PN}-rfs2 = "/boot/chumby-firmware/rfs2.bin"
FILES_${PN}-bl = "/boot/chumby-firmware/bl.bin"
FILES_${PN}-psp = "/boot/chumby-firmware/psp.bin"
FILES_${PN}-k1 = "/boot/chumby-firmware/k1.bin"
FILES_${PN}-rfs1 = "/boot/chumby-firmware/rfs1.bin"

