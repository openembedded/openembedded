DESCRIPTION = "The mini fanout overlay file system"
HOMEPAGE = "http://www.denx.de/twiki/bin/view/Know/MiniFOHome"
LICENSE = "GPL"
SECTION = "kernel/modules"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"

SRC_URI = "http://www.denx.de/twiki/pub/Know/MiniFOHome/mini_fo-0-6-1-pre1.tar.bz2"
S = "${WORKDIR}/mini_fo"

inherit module

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/fs/
	install -m 0644 mini_fo${KERNEL_OBJECT_SUFFIX} ${D}/lib/modules/${KERNEL_VERSION}/kernel/fs/
}

FILES_${PN} = "/lib"

