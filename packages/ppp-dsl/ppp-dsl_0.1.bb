SECTION = "console/network"
DESCRIPTION = "Enables PPP dial-in through a DSL connection"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "PD"
DEPENDS = "ppp rp-pppoe"
RDEPENDS = "ppp rp-pppoe"
RRECOMMENDS = "kernel-module-ppp-async kernel-module-ppp-generic kernel-module-slhc"
PR = "r2"

SRC_URI = "file://dsl-provider \
	file://ppp_on_boot.dsl"

do_install() {
	install -d ${D}${sysconfdir}/ppp/peers
	install -m 0644 ${WORKDIR}/dsl-provider ${D}${sysconfdir}/ppp/peers/
	install -m 0755 ${WORKDIR}/ppp_on_boot.dsl ${D}${sysconfdir}/ppp/
}

pkg_postinst() {
if test "x$D" != "x"; then
	exit 1
else
	if ! test -e ${sysconfdir}/ppp/ppp_on_boot; then
		ln -s ppp_on_boot.dsl ${sysconfdir}/ppp/ppp_on_boot
	fi
fi
}

CONFFILES_${PN}_nylon = "${sysconfdir}/ppp/peers/dsl-provider"
