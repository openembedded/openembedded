DESCRIPTION = "Wireless Central Regulatory Domain Agent"
HOMEPAGE = "http://wireless.kernel.org/en/developers/Regulatory/CRDA"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "ISC"
PR = "r1"

DEPENDS = "libgcrypt libnl python-native python-m2crypto-native"
RDEPENDS_${PN} = "udev"

SRC_URI = "http://wireless.kernel.org/download/crda/${P}.tar.bz2;name=crda \
	http://wireless.kernel.org/download/wireless-regdb/regulatory.bins/2009.11.25-regulatory.bin;name=reg \
	"

do_compile() {
	oe_runmake all_noverify
}

do_install() {
	oe_runmake DESTDIR=${D} install
	install -d ${D}/usr/lib/crda/
	install -m 0644 ${WORKDIR}/2009.11.25-regulatory.bin ${D}/usr/lib/crda/regulatory.bin
}

SRC_URI[crda.md5sum] = "5fc77af68b3e21736b8ef2f8b061c810"
SRC_URI[crda.sha256sum] = "59b4760da44a8f803caeaaa7fb97e0c6bd3f35f40445b28258e7f14c2fbe13b5"
SRC_URI[reg.md5sum] = "873b5c55a26c8ba7674e083f51cb10aa"
SRC_URI[reg.sha256sum] = "3ac77fa4d8034e4f5bc484adc4b073c3636dea26803e5e695cc54c15b629154a"

FILES_${PN} += "\
	/lib/udev/rules.d/85-regulatory.rules \
	/usr/lib/crda/regulatory.bin \
	"
