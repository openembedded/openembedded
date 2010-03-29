require linux.inc
DEPENDS = "android-image-utils-native"

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r3"

COMPATIBLE_MACHINE = "htcdream"
CMDLINE = "console=tty0 no_console_suspend=1 root=/dev/mmcblk0p1 rootdelay=8 fbcon=rotate:1 panic=30 mem=110M"

SRCREV_LAST_GOOD = "0c68b1e8e4507090b8affbcedaac8efde6d0e9b7"
SRCREV = "48afbaf19428893b7aec0a385970f300c38300c3"

SRC_URI = "\
  git://gitorious.org/htc-msm-2-6-32/leviathan-incoming.git;protocol=git \
  file://defconfig \
"
S = "${WORKDIR}/git"

do_deploy_append() {
    touch -f empty
    mkbootimg --kernel ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.bin \
              --ramdisk empty \
              --cmdline "${CMDLINE}" \
              --output ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.fastboot
}
