DESCRIPTION = "A hack to force VCC to 5v for hostap_cs cards. This will fry your \
card one sweet day."
PR = "r1"

SRC_URI = " file://50-hostap_cs.rules "

do_install() {
	install -d ${D}${sysconfdir}/udev/rules.d/
	install -m 0644 ${WORKDIR}/50-hostap_cs.rules         ${D}${sysconfdir}/udev/rules.d/50-hostap_cs.rules
}

PACKAGE_ARCH = "all"
