DESCRIPTION = "Opie Network Settings"
SECTION = "opie/settings"
PRIORITY = "optional"
LICENSE = "GPL"
PROVIDES = "opie-networksettings-pppplugin opie-networksettings-wlanplugin"
APPNAME = "networksettings"

SRC_URI_append = " file://wireless.patch;patch=1"

S = "${WORKDIR}/${APPNAME}"

inherit opie

PARALLEL_MAKE = ""

EXTRA_QMAKEVARS_POST += "LIBS+=-L${S}"

do_stage() {
	oe_libinstall -so libinterfaces ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/interfaces/
	install -m 0644 interfaces/*.h ${STAGING_INCDIR}/interfaces/
}

do_install() {
	# Create dir for changedns and the opie-kppp peer
	install -d ${D}${bindir}/
	install -d ${D}${sysconfdir}/
	install -d ${D}${sysconfdir}/ppp/
	install -d ${D}${sysconfdir}/ppp/peers/
	
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -d ${D}${palmtopdir}/pics/Network/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.* ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/Network/*.* ${D}${palmtopdir}/pics/Network/
	install -d ${D}${palmtopdir}/lib/
	oe_libinstall -so libinterfaces ${D}${libdir}
	install -d ${D}${palmtopdir}/plugins/networksettings/
	for plugin in kppp wlan
	do
		install lib$plugin.so ${D}${palmtopdir}/plugins/networksettings/
	done

	# install changedns script
	install -m 0755 ${WORKDIR}/root/usr/bin/changedns ${D}${bindir}/
	install -m 0644 ${WORKDIR}/root/etc/ppp/peers/opie-kppp ${D}${sysconfdir}/ppp/peers
}

PACKAGES =+ "opie-networksettings-pppplugin opie-networksettings-wlanplugin"
FILES_${PN} += " ${bindir}/changedns "
FILES_opie-networksettings-pppplugin = "${palmtopdir}/plugins/networksettings/libkppp.so ${sysconfdir}/ppp/peers/opie-kppp"
FILES_opie-networksettings-wlanplugin = "${palmtopdir}/plugins/networksettings/libwlan.so"

