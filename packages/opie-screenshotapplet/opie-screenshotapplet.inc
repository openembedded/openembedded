DESCRIPTION = "Screenshot Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "screenshotapplet"



S = "${WORKDIR}/${APPNAME}"

inherit opie

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  /opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
fi
}

pkg_postrm() {
#!/bin/sh
if [ -n "$D" ]; then false; fi
/opt/QtPalmtop/bin/qcop QPE/TaskBar "reloadApplets()"
}

# FILES plugins/applets/libscreenshotapplet.so*
do_install() {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}

