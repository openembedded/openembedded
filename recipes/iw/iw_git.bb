DESCRIPTION = "nl80211 based CLI configuration utility for wireless devices"
HOMEPAGE = "http://linuxwireless.org/en/users/Documentation/iw"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "BSD"

SRCREV = "0a236ef5f8e4ba7218aac7d0cdacf45673d5b35c"
PR = "r0"
PV = "0.9.22"
PR_append = "+gitr${SRCPV}"

DEPENDS = "libnl pkgconfig"

SRC_URI = " \
	git://git.sipsolutions.net/iw.git;protocol=git \
	"
CFLAGS += "-DCONFIG_LIBNL20"

S = "${WORKDIR}/git/"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
}
