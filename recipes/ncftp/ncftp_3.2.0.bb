DESCRIPTION = "A sophisticated console ftp client"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "ClarifiedArtistic"

SRC_URI = "ftp://ftp.ncftp.com/ncftp/older_versions/ncftp-${PV}-src.tar.bz2 \
	   file://acinclude.m4 \
	   file://make.patch;patch=1 \
	   file://fixes.patch;patch=1"

inherit autotools

do_configure_prepend () {
	install -m 0644 ${WORKDIR}/acinclude.m4 acinclude.m4
}

INHIBIT_AUTO_STAGE = "1"

do_install () {
	install -d ${D}${bindir} ${D}${sysconfdir} ${D}${mandir}
	oe_runmake 'prefix=${D}${prefix}' 'BINDIR=${D}${bindir}' \
		   'SYSCONFDIR=${D}${sysconfdir}' 'mandir=${D}${mandir}' \
		   install
}

SRC_URI[md5sum] = "384b7f01d725c89ccd30692628b3ac1b"
SRC_URI[sha256sum] = "2ebc7b51af96cb0fa8b703c7cb995bfb46ccf5312e335270d0420e260544c376"
