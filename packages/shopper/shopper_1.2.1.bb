DESCRIPTION = "Shopping list manager"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "David Greaves <arbor@users.sourceforge.net>"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/zaurus-shopper/Shopper-${PV}.tar.gz \
           file://gcc3.patch;patch=1"
S = "${WORKDIR}/Shopper"

inherit palmtop

QMAKE_PROFILES = "Shopper.pro"

pkg_preinst() {
	cp /root/Applications/ShoppingListQt/shoppinglist.xml /root/Applications/ShoppingListQt/shoppinglist.xml.safe 2>/dev/null
	true
}

pkg_postinst() {
	/opt/QtPalmtop/bin/qcop QPE/System "linkChanged(QString)" 2>/dev/null
	if [ -n "$D" ]; then false; fi
}

do_install() {
        install -d ${D}${palmtopdir}/bin \
        	   ${D}${palmtopdir}/apps/Applications \
        	   ${D}${palmtopdir}/pics \
        	   ${D}${palmtopdir}/help/html
        install -m 0755 ${S}/Shopper ${D}${palmtopdir}/bin/
        install -m 0644 ${S}/Shopper.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${S}/Shopper.png ${D}${palmtopdir}/pics/
        install -m 0644 ${S}/Shopper.html ${D}${palmtopdir}/help/html/
# BAD BAD BAD: packages never install into home directories. ever. --CL
#        install -m 0644 ${S}/shoppinglist.xml ${D}root/Applications/ShoppingListQt/shoppinglist.xml.new
}
