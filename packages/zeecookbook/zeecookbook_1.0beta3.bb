DESCRIPTION = "Zee Cookbook is a cookbook application for Zaurus. \
It lets you store, view and edit your recipes on your pda.        \
Zee Cookbook can import Meal-Master files and can                 \
export recipes in Meal-Master format or in HTML."
SECTION = "opie/applications"
DEPENDS = "sqlite"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"

SRC_URI = "http://zaurus.spy.org/feeds/docs-zaurus-com/zeecookbook-${PV}.zip"
S = "${WORKDIR}/zeecookbook-${PV}/src/zeecookbook"

inherit palmtop

EXTRA_QMAKEVARS_POST = "DESTDIR=${S}"

do_install () {
	tar xzf ../../ipk/zeecookbook_1.0beta3_arm.ipk
	tar xzf data.tar.gz
	cp -a opt ${D}
	install -m 0755 zeecookbook ${D}${palmtopdir}/bin/
}
