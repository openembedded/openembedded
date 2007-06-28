DESCRIPTION = "Squashfs jffs2 unionfs mount tool"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1.0"
PR = "r0"
DEPENDS = "klibc"

SRC_URI = "file://boottool-${MACHINE}.c"

S = "${WORKDIR}/"

do_install_append() {
	install -d ${D}/boot
	install ${S}/boottool ${D}/boot/boottool
}

do_compile_append() {
	${STAGING_BINDIR}/${TARGET_ARCH}-linux-klcc ${S}/boottool-${MACHINE}.c -o ${S}/boottool
	${STRIP} --remove-section=.comment --remove-section=.note --strip-unneeded ${S}/boottool
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/boot/boottool"
