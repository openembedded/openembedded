DESCRIPTION = "greq lets you build GTK dialogs from within a bash script."
LICENSE = "GPL"
DEPENDS = "gtk+-1.2"

PR = "r0"

SRC_URI = "http://download.berlios.de/greq/greq-${PV}.tar.gz \
	   file://tab-delimiter.patch \
	   file://wmclass-option.patch"

inherit autotools

EXTRA_OECONF = "--with-gtk=1.2"

SRC_URI[md5sum] = "457e709817e5d24742909e6c0b37284b"
SRC_URI[sha256sum] = "1e67c1206b32716093ea4147d54741a49f48b0ac8890b785c4d54a60c4e7be0b"
