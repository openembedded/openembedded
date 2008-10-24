DESCRIPTION = "uinput support to Nokia 770/8*0 using Nokia kernel"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r0"

PACKAGES = "${PN}"

FILES_${PN} += "/lib/modules/uinput.ko /etc/init.d/uinput"

COMPATIBLE_MACHINE = "(nokia770|nokia800)"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi-i686-pc-linux-gnu.tar.bz2 \
 http://dev.openbossa.org/mamona/sources/kernel-source-rx-34_2.6.21.0.tar.gz \
 file://defconfig \
 file://uinput \
"

LDFLAGS=""
BUILD_LDFLAGS=""
CFLAGS=""
BUILD_CFLAGS=""
TARGET_LDFLAGS=""

S = "${WORKDIR}/kernel-source-rx-34-2.6.21.0"

do_configure() {
}

do_compile() {
    cp ${WORKDIR}/defconfig ${S}/.config
    PATH=${WORKDIR}/bin/:$PATH CROSS_COMPILE=arm-none-eabi- make modules
}

do_install() {
    install -d ${D}/lib/modules/
    install -m 0644 ${S}/drivers/input/misc/uinput.ko ${D}/lib/modules/
    install -d ${D}/etc/init.d/
    install -m 0755 ${WORKDIR}/uinput ${D}/etc/init.d/
}

pkg_postinst () {
    update-rc.d uinput defaults 10
}