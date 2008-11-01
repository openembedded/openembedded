DESCRIPTION = "Bootlogo support"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1.0"
PR = "r1"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/bootlogo_${MACHINE}.elf \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_${MACHINE}.mvi \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_wait_${MACHINE}.mvi \
	http://sources.dreamboxupdate.com/download/7020/backdrop_${MACHINE}.mvi"

SRC_URI_append_dm8000 = " http://sources.dreamboxupdate.com/download/7020/bootlogo_${MACHINE}.jpg"

SRC_URI_append_dm800 = " http://sources.dreamboxupdate.com/download/7020/bootlogo_${MACHINE}.jpg \
	http://sources.dreamboxupdate.com/download/7020/switchoff_${MACHINE}.mvi"

S = "${WORKDIR}/"

do_install() {
	install -d ${D}/boot
	install -m 0755 ${S}/bootlogo_${MACHINE}.elf ${D}/boot/bootlogo.elf
	install -m 0755 ${S}/bootlogo_${MACHINE}.mvi ${D}/boot/bootlogo.mvi
	install -m 0755 ${S}/bootlogo_wait_${MACHINE}.mvi ${D}/boot/bootlogo_wait.mvi
	install -m 0755 ${S}/backdrop_${MACHINE}.mvi ${D}/boot/backdrop.mvi
}

do_install_append_dm800() {
	install -m 0755 ${S}/bootlogo_${MACHINE}.jpg ${D}/boot/bootlogo.jpg
	install -d ${D}/usr/share/
	install -m 0755 ${S}/switchoff_${MACHINE}.mvi ${D}/usr/share/switchoff.mvi
}

do_install_append_dm8000() {
	install -m 0755 ${S}/bootlogo_${MACHINE}.jpg ${D}/boot/bootlogo.jpg
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot /usr/share"
