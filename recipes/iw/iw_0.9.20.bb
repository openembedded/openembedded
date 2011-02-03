DESCRIPTION = "nl80211 based CLI configuration utility for wireless devices"
HOMEPAGE = "http://linuxwireless.org/en/users/Documentation/iw"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r1"

DEPENDS = "libnl2 pkgconfig"

SRC_URI = " \
	http://wireless.kernel.org/download/iw/${P}.tar.bz2 \
	file://kill-git-version-check.patch \
	"
# We stage libnl2 header files not directly as they clash with libnl files. Once
# we only use libnl2 and stage the headers at the normal place we can remove
# this.
CFLAGS += "-I${STAGING_INCDIR}/libnl2/ -DCONFIG_LIBNL20"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
}

SRC_URI[md5sum] = "1055799b544b3e08169d155bb6c21bb0"
SRC_URI[sha256sum] = "2d665fbfbe4fd6a40159fb821518fc5337da37448416405b936a393a14cbc7d3"
