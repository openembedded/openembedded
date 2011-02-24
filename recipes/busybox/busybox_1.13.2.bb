require busybox_1.1x.inc
PR = "${INC_PR}.4"

SRC_URI += "\
  file://busybox-1.13.2-awk.patch \
  file://busybox-1.13.2-depmod.patch \
  file://busybox-1.13.2-init.patch \
  file://busybox-1.13.2-killall.patch \
  file://busybox-1.13.2-mdev.patch \
  file://busybox-1.13.2-modprobe.patch \
  file://busybox-1.13.2-printf.patch \
  file://busybox-1.13.2-syslogd.patch \
  file://busybox-1.13.2-tar.patch \
  file://busybox-1.13.2-top24.patch \
  file://busybox-1.13.2-unzip.patch \
  file://busybox-1.13.2-wget.patch \
  file://busybox-1.13.2-make382.patch \
  file://udhcpc-background.patch \
"

SRC_URI[md5sum] = "9e2a604d18bef219a5a6bf3acf78b9e1"
SRC_URI[sha256sum] = "927774408bd982dd246fb716bb2e646ab0708ce321b42c5e271dc98c1f5d1dc8"
