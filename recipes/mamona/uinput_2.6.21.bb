<<<<<<< HEAD
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
=======
DESCRIPTION = "uinput support to Nokia 770/8*0 using Nokia kernel"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r0"

PACKAGES = "${PN}"

FILES_${PN} += "/lib/modules/uinput.ko /etc/init.d/uinput"

COMPATIBLE_MACHINE = "(nokia770|nokia800)"

SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm-none-eabi/arm-2005q3-2-arm-none-eabi-i686-pc-linux-gnu.tar.bz2;name=arm \
 http://dev.openbossa.org/mamona/sources/kernel-source-rx-34_2.6.21.0.tar.gz;name=kernel \
 file://defconfig \
 file://uinput \
"

SRC_URI[arm.md5sum] = "1709df05ed8572c6d2457af0076b867c"
SRC_URI[arm.sha256sum] = "dd754383ae40bbdc9917f26deae6d6aaff4060d7be79b5d6c3f7f5c6f98cfadc"
SRC_URI[kernel.md5sum] = "cadab6847034b8d305c9b876211220c4"
SRC_URI[kernel.sha256sum] = "66640580fbb4bc34ecec45a00fe08ff330aa501407556921a345bec5e1921e36"


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
>>>>>>> b6d0763... recipes: add missing checksums
