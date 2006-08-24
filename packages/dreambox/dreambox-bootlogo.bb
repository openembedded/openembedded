DESCRIPTION = "Bootlogo support"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1.0"
PR = "r1"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/bootlogo_dm600pvr.elf \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_dm7020.elf \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_dm7025.elf \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_dm7020.mvi \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_wait_dm7020.mvi \
	http://sources.dreamboxupdate.com/download/7020/backdrop_dm7020.mvi \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_dm7025.mvi \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_wait_dm7025.mvi \
	http://sources.dreamboxupdate.com/download/7020/backdrop_dm7025.mvi \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_dm600pvr.mvi \
	http://sources.dreamboxupdate.com/download/7020/bootlogo_wait_dm600pvr.mvi \
	http://sources.dreamboxupdate.com/download/7020/backdrop_dm600pvr.mvi"

S = "${WORKDIR}/"

do_install() {
	install -d ${D}/boot
	install -m 0755 ${S}/bootlogo_${MACHINE}.elf ${D}/boot/bootlogo.elf
	install -m 0755 ${S}/bootlogo_${MACHINE}.mvi ${D}/boot/bootlogo.mvi
	install -m 0755 ${S}/bootlogo_wait_${MACHINE}.mvi ${D}/boot/bootlogo_wait.mvi
	install -m 0755 ${S}/backdrop_${MACHINE}.mvi ${D}/boot/backdrop.mvi
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot"
