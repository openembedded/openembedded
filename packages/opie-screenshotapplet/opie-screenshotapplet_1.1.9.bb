DESCRIPTION = "Screenshot Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "screenshotapplet"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/screenshotapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

#XXX	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"

S = "${WORKDIR}/${APPNAME}"

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

# FILES plugins/applets/libscreenshotapplet.so*
do_install() {
#XXX	install -d ${D}${palmtopdir}/pics/${APPNAME}/
#XXX	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	:
}

