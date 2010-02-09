# This .inc file allows you to build and deploy multiple sets of kernel + modules with different defconfigs
#
# Note that this include will NOT stage anything nor create packages, since that is virtuall impossible
# Userspace should be built against the 'regular' kernel
#
# The intended usecase is for machines that has mutually exclusive drivers due to e.g. pinmuxing issues.
# For example the LogicPD omap-l138 experimenter board can have multiple mutually exclusive expansion boards
# like lcd, ethernet, sound, 20x2 character LCD, etc. To be able to easily test all of those you can use this .inc
#
# To make it easier finding the original defconfig from a running kernel, this also forcefully turns on 
# CONFIG_IKCONFIG_PROC so people can do 'zcat /proc/config.gz' on the target.

require linux.inc

SRC_URI = " \
           file://configs/"


do_compile() {
	for config in ${WORKDIR}/configs/* ; do
		cp $config ${WORKDIR}/defconfig
		echo "CONFIG_IKCONFIG=y" >> ${WORKDIR}/defconfig
		echo "CONFIG_IKCONFIG_PROC=y" >> ${WORKDIR}/defconfig
		
		do_configure
		kernel_do_compile
		kernel_do_install

		cp arch/${ARCH}/boot/uImage ${DEPLOY_DIR_IMAGE}/uImage.multi-config-$(basename $config)

		if [ -d "${D}/lib" ]; then
			fakeroot tar -cvzf ${DEPLOY_DIR_IMAGE}/${MODULES_IMAGE_BASE_NAME}.multi-config-$(basename $config).tgz -C ${D} lib
		fi
	done
}

do_install() {
	:
}



