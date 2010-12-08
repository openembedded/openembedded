# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules"
ROOTFS_POSTPROCESS_COMMAND += "opkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"
inherit image

PR = "r2"

IMAGE_LINGUAS = ""

IMAGE_FSTYPES = "cpio.gz"

ANGSTROM_EXTRA_INSTALL ?= "busybox"
DISTRO_SSH_DAEMON ?= "dropbear"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "task-boot \
            util-linux-mount util-linux-umount \
            ${DISTRO_SSH_DAEMON} \
            ${ANGSTROM_EXTRA_INSTALL} \
            angstrom-version \
            bash \
            marvell-sdio-fw memtester \
	   "

ROOTFS_POSTPROCESS_COMMAND += "rootfs_update_buildinfo"

rootfs_update_buildinfo () {
        echo "#!/bin/sh" >>${IMAGE_ROOTFS}/init
        echo "exec /sbin/init" >>${IMAGE_ROOTFS}/init
        chmod +x ${IMAGE_ROOTFS}/init
}

IMAGE_POSTPROCESS_COMMAND += "build_uimage"

build_uimage () {

        ${STAGING_BINDIR_NATIVE}/mkimage -A arm -O linux -T ramdisk -C gzip \
        -a 0x0 -e 0x0 -n uInitramfs -d ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.cpio.gz ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.uimage
}

# tmp/deploy/glibc/images/bug20/Angstrom-bug-ramdisk-glibc-ipk-2009.X-stable-bug20.rootfs.cpio.gz
