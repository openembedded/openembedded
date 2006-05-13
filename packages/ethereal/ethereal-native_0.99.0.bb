require ethereal_${PV}.bb
DEPENDS = "perl-native libpcap-native"
inherit native

EXTRA_OECONF = "\
		--enable-ethereal=no \
		--enable-tethereal=yes \
		--enable-editcap=no \
		--enable-dumpcap=no \
		--enable-capinfos=no \
		--enable-mergecap=no \
		--enable-text2pcap=no \
		--enable-idl2eth=no"

do_stage() {
	install -m 0755 rdps ${STAGING_BINDIR}/ethereal-rdps
	install -m 0755 tools/lemon/lemon ${STAGING_BINDIR}/ethereal-lemon
}

do_install() {
	:
}

