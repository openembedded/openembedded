require linux.inc
DEPENDS += "android-image-utils-native"

PV = "2.6.32+${PR}+gitr${SRCREV}"
PR = "r0"

COMPATIBLE_MACHINE = "iphone3g"

SRCREV = "f8ba07d9ba4b72bb6b29bc0ba42ceb9b1f771e04"

SRC_URI = "\
  git://github.com/iDroid-Project/kernel_common.git;protocol=git;branch=android-2.6.32-iphone \
  file://defconfig \
"
S = "${WORKDIR}/git"
