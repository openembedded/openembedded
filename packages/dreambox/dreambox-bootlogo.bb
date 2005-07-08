DESCRIPTION = "Bootlogo support"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1.0"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/bootlogo.elf \
	http://sources.dreamboxupdate.com/download/7020/bootlogo.mvi \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_wait.mvi \
	http://sources.dreamboxupdate.com/download/7020/backdrop.mvi"

S = "${WORKDIR}/"

do_install() {
	install -d ${D}/boot
	install -m 0755 ${S}/bootlogo.elf ${D}/boot
	install -m 0755 ${S}/bootlogo.mvi ${D}/boot
	install -m 0755 ${S}/bootlogo_wait.mvi ${D}/boot
	install -m 0755 ${S}/backdrop.mvi ${D}/boot
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot"
