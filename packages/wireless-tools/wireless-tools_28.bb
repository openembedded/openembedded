require wireless-tools.inc

PR = "r1"

SRC_URI += "http://www.hpl.hp.com/personal/Jean_Tourrilhes/Linux/wireless_tools.28.pre13.tar.gz \
	   file://zzz-wireless.if-pre-up"
S = "${WORKDIR}/wireless_tools.28"

do_install() {
	oe_runmake PREFIX=${D} install-iwmulticall install-dynamic
	install -d ${D}${sysconfdir}/network/if-pre-up.d
	install ${WORKDIR}/wireless-tools.if-pre-up ${D}${sysconfdir}/network/if-pre-up.d/wireless-tools
	install ${WORKDIR}/zzz-wireless.if-pre-up ${D}${sysconfdir}/network/if-pre-up.d/zzz-wireless
}
