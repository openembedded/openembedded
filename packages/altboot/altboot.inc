DESCRIPTION = "The altboot bootmanager"
HOMEPAGE = "http://www.hentges.net/misc/openzaurus/index.shtml"
LICENSE = "GPL" 
RDEPENDS_${PN} = "${PN}-conf"
RDEPENDS_${PN}-conf = "${PN}"
RRECOMMENDS_${PN} = "e2fsprogs-e2fsck dosfstools"
RRECOMMENDS_${PN}_append_akita = " kexec-tools"
RRECOMMENDS_${PN}_append_spitz = " kexec-tools kernel-module-jffs2"
RRECOMMENDS_${PN}_append_c7x0 = " kexec-tools"

S = "${WORKDIR}/trunk/"

PACKAGE_ARCH_${PN} = "${MACHINE}"
PACKAGE_ARCH_${PN}-doc = "all"
PACKAGE_ARCH_${PN}-conf = "${MACHINE}"
PACKAGES = "${PN}-conf ${PN}-doc ${PN}"

FILES_${PN}-conf = "/etc/altboot*cfg"

MACHINE_DIR = "${MACHINE}"
MACHINE_DIR_nslu2be = "nslu2le"
