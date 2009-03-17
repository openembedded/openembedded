DESCRIPTION = "cx3110x wifi support to Nokia IT"
SECTION = "kernel/modules"
LICENSE = "GPL"

INITSCRIPT_NAME = "cx3110x"
INITSCRIPT_PARAMS = "defaults 10"
SRC_URI += "file://cx3110x"
inherit update-rc.d

PACKAGES = "${PN}"

FILES_${PN} += "/lib/modules"

LDFLAGS=""
BUILD_LDFLAGS=""
CFLAGS=""
BUILD_CFLAGS=""
TARGET_LDFLAGS=""

do_configure() {
}

do_install() {
    UNAME_R=`grep "Linux kernel version:" ${SKERNEL}/.config | sed 's/.*: //'`
    install -d ${D}/lib/modules/${UNAME_R}
    install -m 0644 ${S}/src/cx3110x.ko ${D}/lib/modules/${UNAME_R}
    install -d ${D}/${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}/${sysconfdir}/init.d
}
