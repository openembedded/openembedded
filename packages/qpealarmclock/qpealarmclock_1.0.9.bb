DESCRIPTION = "Alarm Clock"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Patrik Gfeller (gfellerpatrik@gmx.net)"
LICENSE = "GPL"
AUTHOR = "Dafydd Walters & Anton Maslovsky"
HOMEPAGE = "http://my-zaurus.narod.ru/"

APPNAME = "qpealarmclock"
APPTYPE = "binary"
APPDESKTOP = "${S}/dist/opt/QtPalmtop/apps/Applications"

SRC_URI = "http://my-zaurus.narod.ru/downloads/qpealarmclock-1.0.9.tar.gz \
           file://fix-compile.patch;patch=1 "

S = "${WORKDIR}/qpealarmclock"

inherit palmtop

do_install () {
# create dirs
  install -d ${D}${palmtopdir}/bin
  install -d ${D}${palmtopdir}/apps/Applications
  install -d ${D}${palmtopdir}/pics/qpealarmclock
# move files
  install -m 644 ${S}/dist/opt/QtPalmtop/apps/Applications/qpealarmclock.desktop ${D}${palmtopdir}/apps/Applications/qpealarmclock.desktop
  install -m 755 ${S}/dist/opt/QtPalmtop/bin/qpealarmclock ${D}${palmtopdir}/bin/qpealarmclock
  install -m 644 ${S}/dist/opt/QtPalmtop/pics/qpealarmclock/frequency.png ${D}${palmtopdir}/pics/qpealarmclock/frequency.png
  install -m 644 ${S}/dist/opt/QtPalmtop/pics/qpealarmclock/led.png ${D}${palmtopdir}/pics/qpealarmclock/led.png
  install -m 644 ${S}/dist/opt/QtPalmtop/pics/qpealarmclock/QpeAlarmClock.png ${D}${palmtopdir}/pics/qpealarmclock/QpeAlarmClock.png
  install -m 644 ${S}/dist/opt/QtPalmtop/pics/qpealarmclock/smallalarm.png ${D}${palmtopdir}/pics/qpealarmclock/smallalarm.png
  install -m 644 ${S}/dist/opt/QtPalmtop/pics/qpealarmclock/sound.png ${D}${palmtopdir}/pics/qpealarmclock/sound.png
}
