require linux.inc
DEPENDS = "android-image-utils-native"

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r5"

COMPATIBLE_MACHINE = "htcdream"
CMDLINE = "console=tty1 root=/dev/mmcblk0p1 rootdelay=8 fbcon=rotate:1 panic=30 mem=110M"

SRCREV_LAST_GOOD = "48afbaf19428893b7aec0a385970f300c38300c3"
SRCREV = "4ca666904c624a54cf29a1b5b64b74c705b0eece"

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
