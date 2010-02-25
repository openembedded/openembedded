DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"

inherit kernel

RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"

# Enable OABI compat for people stuck with obsolete userspace
ARM_KEEP_OABI ?= "1"

# Quirk for udev greater or equal 141
UDEV_GE_141 ?= "0"

# Specify the commandline for your device

# Boot from mmc
CMDLINE_at91sam9263ek = "mem=64M console=ttyS0,115200 root=/dev/mmcblk0p1 rootfstype=ext2 rootdelay=5"
# Boot from nfs
#CMDLINE_at91sam9263ek = "mem=64M console=ttyS0,115200 root=301 root=/dev/nfs nfsroot=172.20.3.1:/data/at91 ip=172.20.0.5:::255.255.0.0"

# Set the verbosity of kernel messages during runtime
# You can define CMDLINE_DEBUG in your local.conf or distro.conf to override this behaviour  
CMDLINE_DEBUG ?= '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug", d)}'
CMDLINE_append = " ${CMDLINE_DEBUG} "

# Support for binary device tree generation

FILES_kernel-devicetree = "/boot/devicetree*"

KERNEL_DEVICETREE_boc01 = "${WORKDIR}/boc01.dts"
KERNEL_DEVICETREE_calamari = "arch/${ARCH}/boot/dts/mpc8536ds.dts"
KERNEL_DEVICETREE_canyonlands = "arch/${ARCH}/boot/dts/canyonlands.dts"
KERNEL_DEVICETREE_kilauea = "arch/${ARCH}/boot/dts/kilauea.dts"
KERNEL_DEVICETREE_lsppchd = "arch/${ARCH}/boot/dts/kuroboxHD.dts"
KERNEL_DEVICETREE_lsppchg = "arch/${ARCH}/boot/dts/kuroboxHG.dts"
KERNEL_DEVICETREE_mpc8313e-rdb = "arch/${ARCH}/boot/dts/mpc8313erdb.dts"
KERNEL_DEVICETREE_mpc8315e-rdb = "arch/${ARCH}/boot/dts/mpc8315erdb.dts"
KERNEL_DEVICETREE_mpc8323e-rdb = "arch/${ARCH}/boot/dts/mpc832x_rdb.dts"
KERNEL_DEVICETREE_sequoia = "arch/${ARCH}/boot/dts/sequoia.dts"

KERNEL_DEVICETREE_FLAGS = "-R 8 -S 0x3000"

python __anonymous () {

    import bb
    
    devicetree = bb.data.getVar('KERNEL_DEVICETREE', d, 1) or ''
    if devicetree:
    	depends = bb.data.getVar("DEPENDS", d, 1)
    	bb.data.setVar("DEPENDS", "%s dtc-native" % depends, d)
    	packages = bb.data.getVar("PACKAGES", d, 1)
    	bb.data.setVar("PACKAGES", "%s kernel-devicetree" % packages, d)
}

do_configure_prepend() {
        echo "" > ${S}/.config

        #
        # logo support, if you supply logo_linux_clut224.ppm in SRC_URI, then it's going to be used
        #
        if [ -e ${WORKDIR}/logo_linux_clut224.ppm ]; then
                install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm drivers/video/logo/logo_linux_clut224.ppm
                echo "CONFIG_LOGO=y"                    >> ${S}/.config
                echo "CONFIG_LOGO_LINUX_CLUT224=y"      >> ${S}/.config
        fi

        #
        # oabi / eabi support
        #
        if [ "${TARGET_OS}" = "linux-gnueabi" -o  "${TARGET_OS}" = "linux-uclibceabi" ]; then
                echo "CONFIG_AEABI=y"                   >> ${S}/.config
                if [ "${ARM_KEEP_OABI}" = "1" ] ; then
                        echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
                else
                        echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
                fi
        else
                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
        fi

        # When enabling thumb for userspace we also need thumb support in the kernel
        if [ "${ARM_INSTRUCTION_SET}" = "thumb" ] ; then
            sed -i -e /CONFIG_ARM_THUMB/d ${WORKDIR}/defconfig 
            echo "CONFIG_ARM_THUMB=y" >> ${S}/.config
        fi

	#
	# endian support
	#
        if [ "${SITEINFO_ENDIANESS}" = "be" ]; then
                echo "CONFIG_CPU_BIG_ENDIAN=y"          >> ${S}/.config
        fi

        echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

        sed -e '/CONFIG_AEABI/d' \
            -e '/CONFIG_OABI_COMPAT=/d' \
            -e '/CONFIG_CMDLINE=/d' \
            -e '/CONFIG_CPU_BIG_ENDIAN/d' \
            -e '/CONFIG_LOGO=/d' \
            -e '/CONFIG_LOGO_LINUX_CLUT224=/d' \
            -e '/CONFIG_LOCALVERSION/d' \
            -e '/CONFIG_LOCALVERSION_AUTO/d' \
	    < '${WORKDIR}/defconfig' >>'${S}/.config'

        echo 'CONFIG_LOCALVERSION=""' >>${S}/.config
        echo '# CONFIG_LOCALVERSION_AUTO is not set' >>${S}/.config

        #
        # Udev quirks
        #

        # Newer versions of udev mandate that sysfs doesn't have deprecated entries
        if [ "${UDEV_GE_141}" = "1" ] ; then
            sed -e /CONFIG_SYSFS_DEPRECATED/d \
                -e /CONFIG_SYSFS_DEPRECATED_V2/d \
                -e /CONFIG_HOTPLUG/d \
                -e /CONFIG_UEVENT_HELPER_PATH/d \
                -e /CONFIG_UNIX/d \
                -e /CONFIG_SYSFS/d \
                -e /CONFIG_PROC_FS/d \
                -e /CONFIG_TMPFS/d \
                -e /CONFIG_INOTIFY_USER/d \
                -e /CONFIG_SIGNALFD/d \
                -e /CONFIG_TMPFS_POSIX_ACL/d \
                -e /CONFIG_BLK_DEV_BSG/d \
                -i '${S}/.config'

            echo '# CONFIG_SYSFS_DEPRECATED is not set' >> ${S}/.config
            echo '# CONFIG_SYSFS_DEPRECATED_V2 is not set' >> ${S}/.config
            echo 'CONFIG_HOTPLUG=y' >> ${S}/.config
            echo 'CONFIG_UEVENT_HELPER_PATH=""' >> ${S}/.config
            echo 'CONFIG_UNIX=y' >> ${S}/.config
            echo 'CONFIG_SYSFS=y' >> ${S}/.config
            echo 'CONFIG_PROC_FS=y' >> ${S}/.config
            echo 'CONFIG_TMPFS=y' >> ${S}/.config
            echo 'CONFIG_INOTIFY_USER=y' >> ${S}/.config
            echo 'CONFIG_SIGNALFD=y' >> ${S}/.config
            echo 'CONFIG_TMPFS_POSIX_ACL=y' >> ${S}/.config
            echo 'CONFIG_BLK_DEV_BSG=y' >> ${S}/.config
            echo 'CONFIG_DEVTMPFS=y' >> ${S}/.config
            echo 'CONFIG_DEVTMPFS_MOUNT=y' >> ${S}/.config
        fi

        #
        # root-over-nfs-over-usb-eth support. Limited, but should cover some cases.
        # Enable this by setting a proper CMDLINE_NFSROOT_USB.
        #
        if [ ! -z "${CMDLINE_NFSROOT_USB}" ]; then
                oenote "Configuring the kernel for root-over-nfs-over-usb-eth with CMDLINE ${CMDLINE_NFSROOT_USB}"
                sed -e '/CONFIG_INET/d' \
                    -e '/CONFIG_IP_PNP=/d' \
                    -e '/CONFIG_USB_GADGET=/d' \
                    -e '/CONFIG_USB_GADGET_SELECTED=/d' \
                    -e '/CONFIG_USB_ETH=/d' \
                    -e '/CONFIG_NFS_FS=/d' \
                    -e '/CONFIG_ROOT_NFS=/d' \
                    -e '/CONFIG_CMDLINE=/d' \
                    -i ${S}/.config
                echo "CONFIG_INET=y"                     >> ${S}/.config
                echo "CONFIG_IP_PNP=y"                   >> ${S}/.config
                echo "CONFIG_USB_GADGET=y"               >> ${S}/.config
                echo "CONFIG_USB_GADGET_SELECTED=y"      >> ${S}/.config
                echo "CONFIG_USB_ETH=y"                  >> ${S}/.config
                echo "CONFIG_NFS_FS=y"                   >> ${S}/.config
                echo "CONFIG_ROOT_NFS=y"                 >> ${S}/.config
                echo "CONFIG_CMDLINE=\"${CMDLINE_NFSROOT_USB}\"" >> ${S}/.config
        fi
		yes '' | oe_runmake oldconfig
}

do_configure_append_avr32() {
        sed -i -e s:-mno-pic::g arch/avr32/Makefile
}

do_configure_append() {
        if test -e scripts/Makefile.fwinst ; then
		sed -i -e "s:-m0644:-m 0644:g" scripts/Makefile.fwinst
	fi
}

do_devicetree_image() {
    if test -n "${KERNEL_DEVICETREE}" ; then
        dtc -I dts -O dtb ${KERNEL_DEVICETREE_FLAGS} -o devicetree ${KERNEL_DEVICETREE}
        install -m 0644 devicetree ${D}/boot/devicetree-${KERNEL_VERSION}
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 devicetree ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.dtb
        package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.dtb
        cd ${DEPLOY_DIR_IMAGE}
        rm -f ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
        ln -sf ${KERNEL_IMAGE_BASE_NAME}.dtb ${KERNEL_IMAGE_SYMLINK_NAME}.dtb
        package_stagefile_shell ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_SYMLINK_NAME}.dtb
    fi
}

addtask devicetree_image after do_install before do_package do_deploy

pkg_postinst_kernel-devicetree () {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --install /${KERNEL_IMAGEDEST}/devicetree devicetree devicetree-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}

pkg_postrm_kernel-devicetree () {
	cd /${KERNEL_IMAGEDEST}; update-alternatives --remove devicetree devicetree-${KERNEL_VERSION} || true
}

