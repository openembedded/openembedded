DESCRIPTION = "GmailFS provides a mountable Linux filesystem which uses your Gmail account as its storage medium."
HOMEPAGE = "http://richard.jones.name/google-hacks/gmail-filesystem/gmail-filesystem.html"
LICENSE = "GPLv2"

DEPENDS = "fuse python-libgmail python-fuse"
RDEPENDS = "fuse python-libgmail python-fuse python-unixadmin  python-lang python-textutils python-core"

SRC_URI = "http://richard.jones.name/google-hacks/gmail-filesystem/${PN}-${PV}.tar.gz"


do_install() {

install -d ${D}${datadir}/gmailfs
install -d ${D}${bindir}
install -d ${D}${sysconfdir}

install -m 755 ${S}/gmailfs.py ${D}${datadir}/gmailfs/
install -m 755 ${S}/mount.gmailfs ${D}${bindir}
install -m 644 ${S}/*.conf ${D}${sysconfdir}

}

