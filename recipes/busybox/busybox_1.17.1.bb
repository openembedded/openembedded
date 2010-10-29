require busybox.inc
require busybox_1.1x.inc
PR = "${INC_PR}"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "\
  file://busybox-1.17.1-grep.patch \
  file://busybox-1.17.1-make.patch \
  file://busybox-1.17.1-mdev.patch \
  file://busybox-1.17.1-mktemp.patch \
  file://busybox-1.17.1-sed.patch \
  file://busybox-1.17.1-shell.patch \
"

SRC_URI[md5sum] = "c7fe7533b7fc4018b0b49a05ee0ee601"
SRC_URI[sha256sum] = "bf9177810d7e151b0e662477c33b9afd062570e6298ec46f2a8397a6a839d164"
