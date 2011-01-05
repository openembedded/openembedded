# tegra2 platform has no neon unit

TARGET_CC_ARCH = "-march=armv7-a -mtune=cortex-a9 -mfpu=vfpv3-d16 -mfloat-abi=soft"

BASE_PACKAGE_ARCH = "armv7a-vfp"
FEED_ARCH = "armv7a-vfp"

PACKAGE_EXTRA_ARCHS += "armv4 armv4t armv5te armv6 armv7 armv7a-vfp"
