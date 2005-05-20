DESCRIPTION = "Lock Opie now Button to lock Opie (as configured in the Security settings) on demand."
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Team Opie <opie@handhelds.org>"
APPNAME = "lockapplet"
DEPENDS = "opie-security"
RDEPENDS = "opie-security"


S = "${WORKDIR}/lockapplet"

inherit opie

pkg_postinst() {
#!/bin/sh
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
fi
 if [ -n "$D" ]; then false; fi
}

pkg_postrm() {
#!/bin/sh
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then false; fi
}

do_install() {
    install -d ${D}${palmtopdir}/plugins/applets ${D}${palmtopdir}/pics/security/
    oe_libinstall -so liblockapplet ${D}${palmtopdir}/plugins/applets/
}

