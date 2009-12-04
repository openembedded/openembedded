#
# Note this class is deprecated 
#


# For Canadian SDKs we need to know what these values start out as, and use
# them as well as the updated ones.
OLD_PACKAGE_ARCH := "${PACKAGE_ARCH}"
OLD_MULTIMACH_ARCH := "${MULTIMACH_ARCH}"
OLD_TARGET_VENDOR := "${TARGET_VENDOR}"
OLD_TARGET_OS := "${TARGET_OS}"
OLD_BASE_PACKAGE_ARCH := "${BASE_PACKAGE_ARCH}"

OLD_MULTIMACH_TARGET_SYS = "${OLD_MULTIMACH_ARCH}${OLD_TARGET_VENDOR}-${OLD_TARGET_OS}"
OLD_BASEPKG_TARGET_SYS = "${OLD_BASE_PACKAGE_ARCH}${OLD_TARGET_VENDOR}-${OLD_TARGET_OS}"

# We want to allow for both machine-target_os-sdk_arch-sdk_os and for
# sdk_arch-sdk_os
MULTIMACH_SDK_SYS = "${OLD_MULTIMACH_TARGET_SYS}-${SDK_SYS}"
BASEPKG_SDK_SYS   = "${OLD_BASEPKG_TARGET_SYS}-${SDK_SYS}"
STAGING_DIR_SDK   = "${STAGING_DIR}/${MULTIMACH_SDK_SYS}"

# Our host dir isn't the build system here, but the SDK system
STAGING_DIR_HOST = "${STAGING_DIR}/${SDK_SYS}"

# Overrides for paths
STAGING_BINDIR_CROSS = "${STAGING_BINDIR}"

PACKAGE_ARCH = "${SDK_ARCH}"
