require mdadm.inc
SRC_URI[mdadm-3.1.2.md5sum] = "c5a39f38c465229767a5af2a4eb81bef"
SRC_URI[mdadm-3.1.2.sha256sum] = "ff831c433c386039163ac09c84b02132a8bb8ad5a0bdb571ff91211980124d68"

PR = "r0"

PACKAGES += "${PN}-udev"
RRECOMMENDS_${PN} = "${PN}-udev"
RRECOMMENDS_${PN}-udev = "udev"

FILES_${PN}-udev = "/lib/udev/rules.d/64-md-raid.rules"