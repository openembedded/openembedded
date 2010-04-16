DESCRIPTION = "Tools needed to be injected into a cross-compilation NSPR build"
HOMEPAGE = "https://www.mozilla.org/projects/nspr"
LICENSE = "MPL1.1 GPL LGPL" 

S = "${WORKDIR}/nspr-${PV}/mozilla/nsprpub"

inherit native autotools

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/nspr-${PV}"

do_compile() {
	# Build 'now' and 'nsinstall' only.
	oe_runmake -C config now nsinstall
}

NATIVE_INSTALL_WORKS = "1"

do_install() {
	install -d ${D}${bindir}/nspr-${PV}
	install -m 0755 config/now ${D}${bindir}/nspr-${PV}
	install -m 0755 config/nsinstall ${D}${bindir}/nspr-${PV}
}
