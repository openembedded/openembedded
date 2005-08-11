DEFAULT_PREFERENCE_unslung = "-1"

SECTION = "kernel"
DESCRIPTION = "Unslung kernel for the Linksys NSLU2 device"
LICENSE = "GPL"
MAINTAINER = "NSLU2 Linux <www.nlsu2-linux.org>"
PR = "r0"

S = "${WORKDIR}/linux-2.4.22"

KERNEL_IMAGETYPE = "zImage"
KERNEL_SUFFIX = "unslung"

DEPENDS += "nslu2-linksys-firmware"

python () {
	# Don't build unslung kernel unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	dist = bb.data.getVar("DISTRO", d, 1)
	if mach != 'nslu2' or dist != 'unslung':
		raise bb.parse.SkipPackage("Unslung only builds for the Linksys NSLU2")
}


do_deploy() {
	cp ${STAGING_LIBDIR}/nslu2-binaries/vmlinuz vmlinuz
	dd if=vmlinuz bs=1 count=11732 > vmlinuh
	dd if=vmlinuz bs=1 skip=11732 count=975109 | gzip -dc > vmlinux
	dd if=vmlinuz bs=1 skip=986841 > vmlinut
	cat vmlinux | sed \
		-e 's/ram0/slug/' \
		-e 's/\x01\x31\x2c\xff/\x00\x1e\x84\x7f/' \
		-e 's/flash_sda\x00/hdd_sda\x00\x00\x00/' \
 		-e 's/flash_\x00/hdd_\x00\x00\x00/' \
		-e 's/flash_sd%c\x00/hdd_sd%c\x00\x00\x00/' \
			| gzip -9 -c > vmlinux.gz
#	cat vmlinuh vmlinux.gz vmlinut > vmlinuz
	dd if=/dev/zero of=padding bs=1 count=9
	cat vmlinuh vmlinux.gz padding vmlinut > vmlinuz
        install -d ${DEPLOY_DIR}/images
        install -m 0644 vmlinuz ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${KERNEL_SUFFIX}
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
