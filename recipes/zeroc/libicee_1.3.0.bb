require icee.inc

SRC_URI="http://www.zeroc.com/download/IceE/1.3/IceE-${PV}-linux.tar.gz \
file://include-time.patch \
file://makefiles.patch \
"
SRC_URI[md5sum] = "61768fcaf4664a758e129de8689add8e"
SRC_URI[sha256sum] = "5dd6d608782fe5afce18a571f275535b3e1d70663a6d358f908ca178bf7cd356"

DEPENDS = "slice2cppe-native"

inherit lib_package

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure () {
	oe_runmake configure
}

do_install_append() {
	install -d ${D}/${datadir}/slice/IceE
	install -m 0644 slice/IceE/*.ice ${D}/${datadir}/slice/IceE
}

PACKAGES =+ "icee-slice"
FILES_icee-slice = "${datadir}/slice"
