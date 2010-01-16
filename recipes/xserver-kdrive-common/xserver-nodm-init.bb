DESCRIPTION = "Simple Xserver Init Script (no dm)"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
PR = "r11"
RDEPENDS_${PN} = "procps"

SRC_URI = "file://xserver-nodm"
S = ${WORKDIR}

PACKAGE_ARCH = "all"

do_install() {
    install -d ${D}/etc
    install -d ${D}/etc/init.d
    install xserver-nodm ${D}/etc/init.d
}    

inherit update-rc.d

INITSCRIPT_NAME = "xserver-nodm"
# start earlier under the assumption that xserver takes seconds to start
INITSCRIPT_PARAMS = "start 5 5 2 . stop 20 0 1 6 ."

pkg_postinst_${PN} () {
if test "x$D" = "x"; then
	for f in `ls /etc/rc?.d/S99${INITSCRIPT_NAME} 2>/dev/null`; do
		mv $f `dirname $f`/S05${INITSCRIPT_NAME}
	done
fi
}
