DESCRIPTION = "Zee Cookbook is a cookbook application for Zaurus. \
It lets you store, view and edit your recipes on your pda.        \
Zee Cookbook can import Meal-Master files and can                 \
export recipes in Meal-Master format or in HTML."
SECTION = "opie/applications"
DEPENDS = "sqlite"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Philip Frampton"
PR = "r0"

SRC_URI = "http://sf.gds.tuwien.ac.at/z/ze/zeecookbook/zeecookbook-1.1.zip \
		file://zeecookbook.patch;patch=1"

S="${WORKDIR}/zeecookbook-1.1/src/zeecookbook"
QPEDIR=${OPIEDIR}

inherit palmtop


do_install () {
	        install -d ${D}${palmtopdir}/bin \
                        ${D}${palmtopdir}/apps/Applications \
                        ${D}${palmtopdir}/pics/zeecookbook  \
                        ${D}${palmtopdir}/help/en

echo ${STAGING_DIR}
echo ${STAGING}
	install -m 0755 ${S}/zeecookbook ${D}${palmtopdir}/bin/
	install -m 0644 ${S}/apps/Applications/zeecookbook.desktop ${D}${palmtopdir}/apps/Applications/
	install -m 0644 ${S}/pics/ZeeCookbook.png ${D}${palmtopdir}/pics/
	install -m 0644 ${S}/pics/zeecookbook/*.png ${D}${palmtopdir}/pics/zeecookbook/
	install -m 0644 ${S}/help/en/zeecookbook.html ${D}${palmtopdir}/help/en/
}
