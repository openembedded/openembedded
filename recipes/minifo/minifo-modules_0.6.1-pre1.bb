DESCRIPTION = "The mini fanout overlay file system"
HOMEPAGE = "http://www.denx.de/twiki/bin/view/Know/MiniFOHome"
LICENSE = "GPL"
SECTION = "kernel/modules"
PR = "r0"

SRC_URI = "http://www.denx.de/twiki/pub/Know/MiniFOHome/mini_fo-0-6-1-pre1.tar.bz2"
S = "${WORKDIR}/mini_fo"

inherit module

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/fs/
	install -m 0644 mini_fo${KERNEL_OBJECT_SUFFIX} ${D}/lib/modules/${KERNEL_VERSION}/kernel/fs/
}

FILES_${PN} = "/lib"


SRC_URI[md5sum] = "7e192e01b08023c7f3e63bf1c796bc14"
SRC_URI[sha256sum] = "68c64a38f0b29347f86871248f0399e7e1b12645dc6263af7b2e4940f1392eaa"
