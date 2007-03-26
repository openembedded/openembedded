#
# binutils and compilers
#
# Can be "glibc" and "uclibc"
FOONAS_MODE ?= "glibc"

#DEPLOY_DIR = "${TMPDIR}/deploy/${FOONAS_MODE}"
require conf/distro/include/foonas-${FOONAS_MODE}.inc

INHERIT += "package_ipk debian sanity devshell"

#Generate locales on the buildsystem instead of on the target. Speeds up first boot, set to "1" to enable
PREFERRED_PROVIDER_qemu-native = "qemu-native"
ENABLE_BINARY_LOCALE_GENERATION ?= "0"

PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/arm-foonas-linux-gnueabi-libc-for-gcc = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/arm-linux-libc-for-gcc = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/powerpc-foonas-linux-libc-for-gcc = "glibc-intermediate"

# not used yet
#PREFERRED_PROVIDER_virtual/armeb-linux-libc-for-gcc = "glibc-intermediate"
#PREFERRED_PROVIDER_virtual/armeb-foonas-linux-gnueabi-libc-for-gcc = "glibc-intermediate"
#PREFERRED_PROVIDER_virtual/mipsel-foonas-linux-libc-for-gcc = "glibc-intermediate"

PREFERRED_PROVIDERS += "virtual/${TARGET_PREFIX}gcc-initial:gcc-cross-initial"
PREFERRED_PROVIDERS += "virtual/${TARGET_PREFIX}gcc:gcc-cross"
PREFERRED_PROVIDERS += "virtual/${TARGET_PREFIX}g++:gcc-cross"
#conflict between this and the last below.
#PREFERRED_PROVIDERS += "virtual/${TARGET_PREFIX}libc-for-gcc:glibc"
# Select 2.6 versions of the depmod support
PREFERRED_PROVIDERS += "virtual/${TARGET_PREFIX}depmod:module-init-tools-cross"
PREFERRED_PROVIDERS += "virtual/${TARGET_PREFIX}libc-for-gcc:glibc-intermediate"

PREFERRED_PROVIDER_virtual/libx11 = "libx11"

PREFERRED_PROVIDER_virtual/db = "db"
PREFERRED_PROVIDER_virtual/db-native = "db-native"

PREFERRED_VERSION_binutils = "2.17.50.0.12"
PREFERRED_VERSION_binutils-cross = "2.17.50.0.12"

PREFERRED_VERSION_gcc = "4.1.1"
PREFERRED_VERSION_gcc-cross = "4.1.1"
PREFERRED_VERSION_gcc-cross-sdk ?= "4.1.1"
PREFERRED_VERSION_gcc-cross-initial = "4.1.1"

PREFERRED_VERSION_glibc = "2.5"
PREFERRED_VERSION_glibc-intermediate = "2.5"
PREFERRED_VERSION_glibc-initial = "2.5"

PREFERRED_VERSION_openlink = "svn"
