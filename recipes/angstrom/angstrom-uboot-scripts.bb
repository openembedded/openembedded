DESCRIPTION = "Various uboot scripts"

DEPENDS = "u-boot-mkimage-native"

SRC_URI = "file://*.cmd"

do_configure() {
	cp ${WORKDIR}/*.cmd ${S}
}

do_compile() {
	for i in *.cmd ; do
		uboot-mkimage -A ${TARGET_ARCH} -O linux -T script -C none -a 0 -e 0 -n "Angstrom $i" -d $i $i.scr
	done
}

do_install() {
	install -d ${D}${datadir}/u-boot-scripts
	for i in *.scr ; do
		install -m 0644 $i ${D}${datadir}/u-boot-scripts
	done
}

FILES_${PN} += "${datadir}"

addtask deploy before do_package after do_install

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	for i in *.scr ; do
		cp $i ${DEPLOY_DIR_IMAGE}
		package_stagefile_shell ${DEPLOY_DIR_IMAGE}/$i
	done
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
