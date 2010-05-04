DESCRIPTION = "Latest wireless drivers"
HOMEPAGE = "http://wireless.kernel.org/en/users/Download"
SECTION = "kernel/modules"
LICENSE = "GPL"
RDEPENDS = "wireless-tools"
PR = "r0"

COMPAT_WIRELESS_VERSION = "2010-12-22"

SRC_URI = "http://wireless.kernel.org/download/compat-wireless-2.6/compat-wireless-${COMPAT_WIRELESS_VERSION}.tar.bz2 \
	"

TAG = "${@'${COMPAT_WIRELESS_VERSION}'.replace('-', '')}"
PV = "0.${TAG}"

S = "${WORKDIR}/compat-wireless-${COMPAT_WIRELESS_VERSION}"

inherit module

EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB=${D}"

do_configure_append() {
	sed -i "s#@./scripts/update-initramfs## " Makefile
}

do_install() {
	oe_runmake DEPMOD=echo DESTDIR="${D}" INSTALL_MOD_PATH="${D}" LDFLAGS="" install-modules
}

SRC_URI[md5sum] = "9b22d0baf4ec7fbf127740b618b5d63a"
SRC_URI[sha256sum] = "c8143f06795f6df976967212b07b7b3f2786a9b17cac1dce03390daa7e6c904a"
