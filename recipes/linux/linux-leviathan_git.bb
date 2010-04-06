require linux.inc
DEPENDS = "android-image-utils-native"

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r11"

COMPATIBLE_MACHINE = "htcdream"
CMDLINE = "console=tty1 no_console_suspend=1 root=/dev/mmcblk0p1 rootdelay=8 fbcon=rotate:1 panic=30 mem=110M"

#CMDLINE = "console=tty1 root=/dev/mmcblk0p1 rootdelay=8 fbcon=rotate:1 panic=30 mem=110M earlysuspend.debug_mask=3"

SRCREV_LAST_GOOD = "00243f441ef12bd6823007759c7c1fc91ecda55d"
SRCREV = "e94465547ea4b765024ff08c36afffb5664f3121"

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
