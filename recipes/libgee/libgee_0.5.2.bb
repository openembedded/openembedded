require libgee.inc

PR = "${INC_PR}.0"
PE = "1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/libgee/0.5/${BPN}-${PV}.tar.bz2"
S = "${WORKDIR}/${BPN}-${PV}"

SRC_URI[md5sum] = "fc5a36eb5f61154a1456cbb8b1798e41"
SRC_URI[sha256sum] = "8625ebfb479600046b9e36e1a8fd1142d624645dce66a6cd8c9067d8f7f5ce51"
