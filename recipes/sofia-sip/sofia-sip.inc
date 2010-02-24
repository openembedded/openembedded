DESCRIPTION = "Sofia-SIP is an open-source SIP User-Agent library, compliant with the IETF RFC3261 specification."
HOMEPAGE = "http://sofia-sip.sourceforge.net/"
LICENSE = "LGPL"
DEPENDS = "glib-2.0 openssl"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz;name=archive"

inherit autotools pkgconfig

PACKAGES += " ${PN}-bin ${PN}-glib"

FILES_${PN}-bin = "${bindir}"
FILES_${PN} = "${libdir}/libsofia-sip-ua.so.*"
FILES_${PN}-dev += "${datadir}/sofia-sip/*.awk"
FILES_${PN}-glib = "${libdir}/libsofia-sip-ua-glib.so.*" 

LEAD_SONAME = "libsofia-sip-ua.so"

do_stage () {
	autotools_stage_all
}
