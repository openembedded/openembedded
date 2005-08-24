SRC_URI = "${SOURCEFORGE_MIRROR}/zd1211/sf-zd1211-${PV}-src.tar.gz \
	file://makefile.patch;patch=1 \
	file://syntax.patch;patch=1 \
	file://usb-endian.patch;patch=1 \
	file://usb-ids.patch;patch=1 \
	file://get-stats.patch;patch=1 \
	file://explicit-key-change.patch;patch=1 \
	file://copy-break.patch;patch=1"
S = "${WORKDIR}"
LICENSE = "GPL"

inherit module-base
SECTION = "base"

do_configure() {
	:
}

CFLAGS = "-DLINUX_OS -D__KERNEL__ -DMODULE -I${S}/src/includes -I${S}/src/includes/pcmcia -I${STAGING_KERNEL_DIR}/include"

do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
                   KERNEL_SRC=${STAGING_KERNEL_DIR}    \
                   KERNEL_VERSION=${KERNEL_VERSION}    \
                   CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
                   ${MAKE_TARGETS}
}

do_install() {
	install -d ${D}/opt/lib/modules/${KERNEL_VERSION}/wireless
	install -m 0644 zd1211.o ${D}/opt/lib/modules/${KERNEL_VERSION}/wireless/zd1211.o
}

FILES_${PN} = "/opt/lib/modules"
