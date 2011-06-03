require busybox_1.1x.inc
PR = "${INC_PR}.0"

FILESPATHPKG =. "busybox-git:"

SRCREV = "10c0131a8a1b3db7fd6b23b72ebd7b33afc7b018"

PV = "1.18.4+gitr${SRCREV}"

S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  git://git.busybox.net/busybox;protocol=git \
  file://udhcpscript.patch \
  file://udhcpc-fix-nfsroot.patch \
  file://find-touchscreen.sh \
  file://busybox-cron \
  file://busybox-httpd \
  file://busybox-udhcpd \
  file://default.script file://simple.script \
  file://group \
  file://hwclock.sh \
  file://hwclock-default \
  file://inetd \
  file://inetd.conf \
  file://mount.busybox \
  file://mountall \
  file://passwd \
  file://shadow \
  file://syslog \
  file://syslog.conf \
  file://umount.busybox \
  file://defconfig \
  file://mdev \
  file://mdev.conf \
  file://usb.sh \
"
