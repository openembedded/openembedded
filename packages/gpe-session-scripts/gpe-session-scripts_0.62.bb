LICENSE = "GPL"
PR = "r14"

inherit gpe

DESCRIPTION = "GPE session startup scripts"
SECTION = "gpe"
PRIORITY = "optional"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
RDEPENDS_${PN} = "matchbox gpe-session-starter gpe-bluetooth xstroke xtscal gpe-question gpe-clock matchbox-applet-inputmanager xrandr xmodmap xdpyinfo"
# more rdepends: keylaunch ipaq-sleep apmd blueprobe
DEPENDS = "matchbox-wm matchbox-panel gpe-bluetooth xstroke xtscal gpe-question matchbox-applet-inputmanager gpe-clock xrandr xmodmap xdpyinfo"

SRC_URI += "file://zaurus.sh \
	file://keymap.sh \
	file://change-default-applets.patch;patch=1 \
	file://xdefaults.patch;patch=1 \
	file://matchbox-session \
	file://shepherd.xmodmap file://simpad.xmodmap \
	file://collie.xmodmap \
	file://disable-composite.xsettings \
	file://change-default-xsettings.patch;patch=1"

do_install_append() {
	install ${WORKDIR}/zaurus.sh ${D}${sysconfdir}/X11/Xinit.d/11zaurus
	install ${WORKDIR}/keymap.sh ${D}${sysconfdir}/X11/Xinit.d/12keymap
	for m in simpad shepherd collie; do
		install -m 0644 ${WORKDIR}/$m.xmodmap ${D}${sysconfdir}/X11/
	done
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
