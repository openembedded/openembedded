SECTION = "apps"
LICENSE = "GPL"
DESCRIPTION = "wview is a weather site generator and more for a variety of weather stations"
MAINTAINER = "Mark Teel (mark@teel.ws)"
HOMEPAGE = "http://www.wviewweather.com/"
DEPENDS += " bash util-linux gd openssl curl update-rc.d"

SRC_URI = "${SOURCEFORGE_MIRROR}/wview/wview-${PV}.tar.gz"

S = "${WORKDIR}/wview-${PV}"

inherit autotools

EXTRA_OECONF += " --enable-wunderground" 

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -d ${D}/${sysconfdir}/wview
	install -d ${D}/${sysconfdir}/wview/html
	install -d ${D}/${sysconfdir}/wview/alarms
	install -m 755 ${S}/examples/NSLU2/wview ${D}/${sysconfdir}/init.d
	install -m 644 ${S}/examples/conf/*.* ${D}/${sysconfdir}/wview
	install -m 755 ${S}/examples/alarms/*.sh ${D}/${sysconfdir}/wview/alarms
	install -m 644 ${S}/examples/html/*.* ${D}/${sysconfdir}/wview/html

	install -d ${D}/var/wview
	install -d ${D}/var/wview/archive
	install -d ${D}/var/wview/alarms
	install -d ${D}/var/wview/img
	install -d ${D}/var/wview/noaa
	install -m 644 ${S}/bin/img/*.* ${D}/var/wview/img

	if test "x${D}" != "x"; then
		D="-r ${D}"
	else
		D=""
	fi
	update-rc.d $D wview defaults 95 15
}
