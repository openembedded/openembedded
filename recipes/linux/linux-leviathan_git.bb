require linux.inc
DEPENDS += "android-image-utils-native"

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r17"

COMPATIBLE_MACHINE = "htcdream"
CMDLINE = "console=tty1 root=/dev/mmcblk0p1 rootdelay=8 fbcon=rotate:1 panic=30 mem=110M"

SRCREV_LAST_GOOD = "2402bb32e564fb3b802c4a23d4a3f1fd0faa8d17"
SRCREV = "636fa4daf243826ef6cebb64dd0509f3b079fcb5"

SRC_URI = "\
  git://gitorious.org/htc-msm-2-6-32/leviathan-incoming.git;protocol=git;branch=msm-gnuconform \
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
