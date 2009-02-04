DESCRIPTION = "GRand Unified Bootloader"
HOMEPAGE = "http://www.gnu.org/software/grub"
SECTION = "bootloaders"
PRIORITY = "optional"
RDEPENDS = "diffutils"
PR = "r4"

SRC_URI = "ftp://alpha.gnu.org/gnu/grub/grub-${PV}.tar.gz \
           file://automake-1.10.patch;patch=1 \
           file://menu.lst"

inherit autotools

python __anonymous () {
    import re
    host = bb.data.getVar('HOST_SYS', d, 1)
    if not re.match('i.86.*-linux', host):
        raise bb.parse.SkipPackage("incompatible with host %s" % host)
}

do_install_append() {
        install -d ${D}/boot/
	ln -sf ../usr/lib/grub/i386${TARGET_VENDOR}/ ${D}/boot/grub

	# TODO: better use grub-set-default script here?
	install -m 0644  ${WORKDIR}/menu.lst ${D}/boot/grub
}

FILES_${PN}-doc = "${datadir}"
FILES_${PN} = "/boot /usr"
