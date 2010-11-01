DESCRIPTION = "Append Autologin to GDM config (custom.conf)"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "all"
ALLOW_EMPTY_${PN} = "1"

pkg_postinst_${PN}() {
#!/bin/sh
grep "TimedLogin" $D/etc/gdm/custom.conf
if [ $? -eq 0 ]; then
    echo "NOTE:: custom.conf already has 'TimedLogin' configured - not patching"
else
    cat >> $D/etc/gdm/custom.conf <<EOF

[daemon]
TimedLoginEnable=true
TimedLogin=root
TimedLoginDelay=10

EOF
fi
}

RDEPENDS_${PN} = "gdm"
