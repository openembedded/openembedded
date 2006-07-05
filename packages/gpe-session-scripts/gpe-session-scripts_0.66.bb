LICENSE = "GPL"
PR = "r8"

inherit gpe

DESCRIPTION = "GPE session startup scripts"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
RDEPENDS_${PN} = "matchbox gpe-session-starter gpe-bluetooth xstroke xtscal gpe-question gpe-clock matchbox-applet-inputmanager xrandr xmodmap xdpyinfo xserver-common"
# more rdepends: keylaunch ipaq-sleep apmd blueprobe
DEPENDS = "matchbox-wm matchbox-panel gpe-bluetooth xstroke xtscal gpe-question matchbox-applet-inputmanager gpe-clock xrandr xmodmap xdpyinfo xserver-common"

SRC_URI += "file://matchbox-session \
	file://0.66-reinstate-volume-applet-and-fix-order.patch;patch=1 \
	file://disable-composite.xsettings"

do_install_append() {
	install -d ${D}${sysconfdir}/gpe/xsettings-default.d
	if [ "${GUI_MACHINE_CLASS}" != "bigscreen" ]; then
		echo "Gtk/ToolbarStyle:S:icons" > ${D}${sysconfdir}/gpe/xsettings-default.d/toolbar
	fi
	install -d ${D}${sysconfdir}/matchbox
	install ${WORKDIR}/matchbox-session ${D}${sysconfdir}/matchbox/session

	install -d ${D}${sysconfdir}/gpe/xsettings-default.d
	install -m 0644 ${WORKDIR}/disable-composite.xsettings ${D}${sysconfdir}/gpe/xsettings-default.d/disable-composite
	
	mv ${D}/usr/bin/gpe-logout ${D}/usr/bin/gpe-logout.matchbox
}

pkg_postinst_${PN}() { 
	update-alternatives --install /usr/bin/gpe-logout gpe-logout /usr/bin/gpe-logout.matchbox 10
}

pkg_postrm_${PN}() {   
       update-alternatives --remove gpe-logout /usr/bin/gpe-logout.matchbox 
}

# This makes use of GUI_MACHINE_CLASS, so set PACKAGE_ARCH appropriately
PACKAGE_ARCH = "${MACHINE_ARCH}"
