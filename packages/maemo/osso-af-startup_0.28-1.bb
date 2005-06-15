LICENSE =	"unknown"
MAINTAINER=	"Florian Boor <florian@kernelconcepts.de"
PR 	= "r4"

PACKAGES=	"${PN} osso-af-services osso-af-base-apps"
DEPENDS =	""
RDEPENDS_osso-af-services = "${PN}"
RDEPENDS_osso-af-base-apps = "${PN}"

SRC_URI = "http://stage.maemo.org:80/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.tar.gz \
           file://osso-af-startup-source.patch;patch=1;pnum=0 \
           file://launch-no-o.patch;patch=1;pnum=0"

S = ${WORKDIR}/${PN}-0.28

FILES_${PN} = "${sysconfdir}/osso-af-init ${sysconfdir}/init.d/af-startup"
FILES_osso-af-services = "${sysconfdir}/init.d/af-services"
FILES_osso-af-base-apps = "${sysconfdir}/init.d/af-base-apps"

INITSCRIPT_PACKAGES = ${PACKAGES}
INITSCRIPT_NAME_${PN} = "af-startup"
INITSCRIPT_PARAMS_${PN} = "defaults 50"
INITSCRIPT_NAME_osso-af-services = "af-services"
INITSCRIPT_PARAMS_osso-af-services = "defaults 22"
INITSCRIPT_NAME_osso-af-base-apps = "af-base-apps"
INITSCRIPT_PARAMS_osso-af-base-apps = "defaults 51"

inherit autotools update-rc.d

do_install () {
	install -d ${D}${sysconfdir}/osso-af-init
	install -m 755 ${S}/services/af-defines.sh ${D}/${sysconfdir}/osso-af-init/af-defines.sh
	install -m 755 ${S}/services/dbus-sessionbus.sh ${D}/${sysconfdir}/osso-af-init/dbus-sessionbus.sh
	install -m 755 ${S}/services/launch-wrapper.sh ${D}/${sysconfdir}/osso-af-init/launch-wrapper.sh
	install -m 755 ${S}/services/locale ${D}/${sysconfdir}/osso-af-init/locale
	install -m 755 ${S}/services/nice-launch-wrapper-tryrestart.sh ${D}/${sysconfdir}/osso-af-init/nice-launch-wrapper-tryrestart.sh
	install -m 755 ${S}/services/nice-launch-wrapper.sh ${D}/${sysconfdir}/osso-af-init/nice-launch-wrapper.sh
	install -m 755 ${S}/services/real-af-base-apps ${D}/${sysconfdir}/osso-af-init/real-af-base-apps
	install -m 755 ${S}/services/real-af-services ${D}/${sysconfdir}/osso-af-init/real-af-services
	install -m 755 ${S}/services/real-af-startup ${D}/${sysconfdir}/osso-af-init/real-af-startup

	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${S}/top-scripts/af-base-apps ${D}/${sysconfdir}/init.d/af-base-apps
	install -m 755 ${S}/top-scripts/af-services ${D}/${sysconfdir}/init.d/af-services
	install -m 755 ${S}/top-scripts/af-startup ${D}/${sysconfdir}/init.d/af-startup
}