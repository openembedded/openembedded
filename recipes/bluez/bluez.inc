DESCRIPTION = "Linux Bluetooth Stack Userland Utilities and libraries."
SECTION = "console"
PRIORITY = "optional"
HOMEPAGE = "http://www.bluez.org"
LICENSE = "GPL"
PR = "r1"

DEPENDS = "gstreamer gst-plugins-base dbus glib-2.0"
PROVIDES = "bluez-utils-dbus"
RPROVIDES_${PN} = "bluez-pan bluez-sdp bluez-utils-dbus"
RREPLACES_${PN} = "bluez-utils-dbus"
RCONFLICTS_${PN} = "bluez-utils-nodbus"

FILESPATHPKG =. "bluez-utils-${PV}:bluez-utils:"

S = "${WORKDIR}/bluez-${PV}"

inherit autotools update-rc.d pkgconfig

OE_LT_RPATH_ALLOW = "any"
OE_LT_RPATH_ALLOW[export]="1"

do_install_append() {
	install -d ${D}${base_sbindir} ${D}${base_bindir}/  ${D}${sysconfdir}/apm/event.d/
	if [ "${sbindir}" != "${base_sbindir}" ]; then
		mv ${D}${sbindir}/* ${D}${base_sbindir}/
		rmdir ${D}${sbindir}
	fi
	if [ "${bindir}" != "${base_bindir}" ]; then
		mv ${D}${bindir}/* ${D}${base_bindir}/
		rmdir ${D}${bindir}
	fi
	chmod u+s ${D}${base_sbindir}/hciattach ${D}${base_sbindir}/hciconfig
	install -m 0644 ${WORKDIR}/hcid.conf ${D}${sysconfdir}/bluetooth/
        install -m 0644 ${S}/rfcomm/rfcomm.conf ${D}${sysconfdir}/bluetooth/
        install -m 0755 ${S}/daemon/.libs/passkey-agent ${D}${base_bindir}/ ||true 
		install -m 0755 ${S}/test/.libs/passkey-agent ${D}${base_bindir}/ ||true
}


INITSCRIPT_NAME = "bluetooth"
INITSCRIPT_PARAMS = "defaults 23 19"


PACKAGES =+ "${PN}-compat"


FILES_${PN} = " \
               ${base_sbindir}/hcid \
               ${libdir}/bluetooth \
               ${sysconfdir}/init.d/bluetooth \
               ${sysconfdir}/bluetooth/*.service \
               ${sysconfdir}/bluetooth/hcid.conf \
               ${sysconfdir}/default \
               ${sysconfdir}/dbus-1 \
	       ${base_sbindir}/hciattach \
              "

FILES_${PN}-dbg += " \
                   ${libdir}/bluetooth/.debug \
		   ${libdir}/cups/backend/.debug \
		   ${libdir}/alsa-lib/.debug \
		  " 

FILES_${PN}-compat = " \
                    ${base_bindir}/sdptool \
                    ${base_bindir}/dund \
		    ${base_bindir}/rctest \
		    ${base_bindir}/ciptool \
		    ${base_bindir}/l2test \
		    ${base_bindir}/rfcomm \
		    ${base_bindir}/hcitool \
		    ${base_bindir}/pand \
		    ${base_bindir}/hidd \
		    ${base_bindir}/l2ping \
		    ${base_sbindir}/hciconfig \
                    ${base_sbindir}/bccmd \
		    ${base_sbindir}/hciemu \
		    ${base_sbindir}/hid2hci \
		    ${base_bindir}/passkey-agent \
		    ${sysconfdir}/bluetooth/rfcomm.conf \
		   " 

HEADERS = "bluetooth.h bnep.h cmtp.h hci.h hci_lib.h hidp.h l2cap.h rfcomm.h sco.h sdp.h sdp_lib.h"

do_stage_prepend() {
        oe_libinstall -so -C lib libbluetooth ${STAGING_LIBDIR}

        install -d ${STAGING_INCDIR}/bluetooth/
        for f in ${HEADERS}
        do
                install -m 0644 include/$f ${STAGING_INCDIR}/bluetooth/$f
        done
}

