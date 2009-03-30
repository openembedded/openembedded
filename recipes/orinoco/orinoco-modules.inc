DESCRIPTION = "A driver for wireless LAN cards based on Hermes(Orinoco) cards. \
Also contains support for cards using downloadable firmware, i.e. the Symbol/Socket family."
SECTION = "kernel/modules"
PRIORITY = "optional"
RDEPENDS_orinoco-modules-pci = "orinoco-modules"
RDEPENDS_orinoco-modules-usb = "orinoco-modules"
RDEPENDS_orinoco-modules-nortel = "orinoco-modules"
RRECOMMENDS_orinoco-modules-cs = "apm-wifi-suspendfix"
PROVIDES = "spectrum-modules"
LICENSE = "GPL"

SRC_URI = "http://ozlabs.org/people/dgibson/dldwd/orinoco-${PV}.tar.gz"
S = "${WORKDIR}/orinoco-${PV}"

inherit module

PACKAGES = "${PN}-dbg orinoco-modules-cs orinoco-modules-pci orinoco-modules-usb orinoco-modules-nortel orinoco-modules"
FILES_orinoco-modules-pci = "/lib/modules/${KERNEL_VERSION}/net/orinoco_p*${KERNEL_OBJECT_SUFFIX}"
FILES_orinoco-modules-usb = "/lib/modules/${KERNEL_VERSION}/net/*_usb${KERNEL_OBJECT_SUFFIX}"
FILES_orinoco-modules-nortel = "/lib/modules/${KERNEL_VERSION}/net/orinoco_tmd${KERNEL_OBJECT_SUFFIX} \
                                /lib/modules/${KERNEL_VERSION}/net/orinoco_nortel${KERNEL_OBJECT_SUFFIX}"
FILES_orinoco-modules = "/lib/modules/"
