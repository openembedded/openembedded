inherit gpe

DESCRIPTION = "GPE session startup scripts"
LICENSE = "GPL"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
RDEPENDS_${PN} = "matchbox matchbox-panel (>= 0.9.2-r12) matchbox-desktop (>= 0.9.1-r1) matchbox-common (>= 0.9.1-r2) gpe-session-starter gpe-bluetooth xstroke xtscal gpe-question gpe-clock matchbox-applet-inputmanager xrandr xmodmap xdpyinfo xserver-common"
# more rdepends: keylaunch ipaq-sleep apmd blueprobe
DEPENDS = "matchbox-wm matchbox-panel gpe-bluetooth xstroke xtscal gpe-question matchbox-applet-inputmanager gpe-clock xrandr xmodmap xdpyinfo xserver-common"

SRC_URI += "file://matchbox-session \
	file://disable-composite.xsettings"

#apply a patch to set the fontsize for bigdpi (200+) devices to 5
SRC_URI_append_ipaq-pxa270 = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_spitz = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_akita = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_c7x0 = " file://highdpifontfix.patch;patch=1"
SRC_URI_append_nokia770 = " file://highdpifontfix.patch;patch=1"

do_install_append() {
	install -d ${D}${sysconfdir}/gpe/xsettings-default.d
	if [ "${GUI_MACHINE_CLASS}" != "bigscreen" ]; then
		echo "Gtk/ToolbarStyle:S:icons" > ${D}${sysconfdir}/gpe/xsettings-default.d/toolbar
	fi
	install -d ${D}${sysconfdir}/matchbox
	install ${WORKDIR}/matchbox-session ${D}${sysconfdir}/matchbox/session

	install -d ${D}${sysconfdir}/gpe/xsettings-default.d
	install -m 0644 ${WORKDIR}/disable-composite.xsettings ${D}${sysconfdir}/gpe/xsettings-default.d/disable-composite
}

# This makes use of GUI_MACHINE_CLASS, so set PACKAGE_ARCH appropriately
PACKAGE_ARCH = "${MACHINE_ARCH}"
