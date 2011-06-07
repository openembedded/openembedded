require linux.inc
DEPENDS += "android-image-utils-native"

PV = "2.6.37+${PR}+gitr${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "nexusone"
CMDLINE = "root=/dev/mmcblk0p1 rw rootwait noinitrd fbcon=rotate:1"

SRCREV = "87fe2be204fdb40883c508a9d4d9567b40c52300"

SRC_URI = "\
  git://gitorious.org/htc-msm-2-6-32/leviathan-incoming.git;protocol=git;branch=nexusone \
  file://defconfig \
"
S = "${WORKDIR}/git"

do_deploy_append() {
    if [ ! -e empty.gz ];then
        if [ ! -e empty ];then
            touch empty
        fi
        gzip empty
    fi
    mkbootimg --kernel ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.bin \
              --ramdisk empty.gz \
              --cmdline "${CMDLINE}" \
              --base 0x20000000 \
              --output ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.fastboot
}
