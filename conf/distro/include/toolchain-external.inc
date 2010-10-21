# Toolchain specific virtuals
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}binutils = "external-toolchain-${TOOLCHAIN_BRAND}"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-initial = "external-toolchain-${TOOLCHAIN_BRAND}"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-intermediate = "external-toolchain-${TOOLCHAIN_BRAND}"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc = "external-toolchain-${TOOLCHAIN_BRAND}"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}g++ = "external-toolchain-${TOOLCHAIN_BRAND}"
#PREFERRED_PROVIDER_linux-libc-headers = "external-toolchain-${TOOLCHAIN_BRAND}"

TOOLCHAIN_VENDOR ?= "${TARGET_VENDOR}"
TARGET_VENDOR := "${TOOLCHAIN_VENDOR}"
