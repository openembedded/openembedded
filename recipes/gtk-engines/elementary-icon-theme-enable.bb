DESCRIPTION = "Enable elementary-icon-theme in gtkrc"

RDEPENDS_${PN} = "elementary-icon-theme"

ALLOW_EMPTY_${PN} = "1"
PACKAGE_ARCH = "all"

pkg_postinst() {
#!/bin/sh
mkdir -p $D${sysconfdir}/gtk-2.0
touch $D${sysconfdir}/gtk-2.0/gtkrc
sed -i /gtk-icon-theme-name/d $D${sysconfdir}/gtk-2.0/gtkrc
echo 'gtk-icon-theme-name = "elementary"' >> $D${sysconfdir}/gtk-2.0/gtkrc
}
