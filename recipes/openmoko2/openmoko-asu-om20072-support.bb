DESCRIPTION = "Theme support and defaults to integrate OM2007.2 in the April Software Update"
LICENSE = "GPL"
SECTION = "x11"
RDEPENDS_${PN} = "openmoko-common2"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "all"

pkg_postinst_${PN} () {
#!/bin/sh -e
if [ "x$D" != "x" ]; then
    exit 1
fi

gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/poky/interface/theme Moko
gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/poky/interface/icon_theme openmoko-standard
gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/poky/interface/font_name "Sans 5"
gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type string --set /desktop/poky/interface/wallpaper ${datadir}/pixmaps/wallpaper.png
gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type bool --set /desktop/poky/interface/digital_clock 1
gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type int --set /desktop/poky/peripherals/mouse/drag_threshold 8
gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct --type int --set /desktop/openmoko/neod/power_management 2
# gstreamer audio settings
#gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct -t string --set /system/gstreamer/0.10/default/audiosink pulsesink
#gconftool-2 --config-source=xml::$D${sysconfdir}/gconf/gconf.xml.defaults --direct -t string --set /system/gstreamer/0.10/default/audiosrc pulsesrc

}

