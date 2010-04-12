DESCRIPTION = "Alarm Clock Applet"
SECTION = "opie/applets"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Anton Maslovsky"
HOMEPAGE = "http://my-zaurus.narod.ru/"
RDEPENDS = "qpealarmclock"
RCONFLICTS = "opie-clockapplet"
RREPLACES = "opie-clockapplet"

PR = "r1"

APPNAME = "qpealarmclockapplet"
APPTYPE = "binary"

SRC_URI = "http://my-zaurus.narod.ru/downloads/clockapplet.tar.gz \
	   file://missing-files.tar.gz \
	   file://fix-compile.patch;patch=1 "

S = "${WORKDIR}/clockapplet"

inherit palmtop

pkg_postinst() {
#!/bin/sh
if [ -n "$D" ]; then exit 1; fi
if pidof -s qpe >/dev/null; then
  /usr/bin/qcop QPE/TaskBar "reloadApplets()"
fi
}

pkg_postrm() {
#!/bin/sh
/usr/bin/qcop QPE/TaskBar "reloadApplets()"
 if [ -n "$D" ]; then false; fi
}

do_install () {
# create dirs
  install -d ${D}${palmtopdir}/plugins/applets
# libs
 oe_libinstall -so libclockapplet ${D}${palmtopdir}/plugins/applets
}

SRC_URI[md5sum] = "7265673901eacb0b72a11cd6732cc698"
SRC_URI[sha256sum] = "80fd209d065887729fdeb81f5a91638626e7ed31dabab40c446bd12042df9057"
