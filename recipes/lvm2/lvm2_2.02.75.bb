require lvm2.inc

PR = "${INC_PR}.0"
SRC_URI = "ftp://sources.redhat.com/pub/lvm2/old/LVM2.${PV}.tgz \
           file://lvm.conf"

SRC_URI[md5sum] = "30ef29785b0e8cfbc106b5203c08d0e7"
SRC_URI[sha256sum] = "f63ad083f9e371b4b490e8eaa9645447d456a76ae6a099e0b910e2e1ada75ba4"
