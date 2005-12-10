DESCRIPTION = "Bootshim for Greatwall bootloaders"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

DEPENDS = "sed-native LAB-kernel"
#requires perl on the host system, will fix that later

SRC_URI = "http://handhelds.org/~mreimer/${P}.tgz"

do_configure() {
cp ${DEPLOY_DIR}/images/LAB-image-${MACHINE} ${S}/zImage
sed -i /^CROSS/d Makefile
}

do_compile() {
oe_runmake CROSS=${CROSS_DIR}/bin/${TARGET_ARCH}-${TARGET_OS}-
}


do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 htc_bootshim.bin ${DEPLOY_DIR}/images/LAB-image-${MACHINE}.shimmed.dd
	install -m 0644 htc_bootshim.htc ${DEPLOY_DIR}/images/LAB-image-${MACHINE}.shimmed.rescue
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile


