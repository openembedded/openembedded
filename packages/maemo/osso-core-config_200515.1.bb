LICENSE    = "unknown"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de"
PR         = "r6"

DEPENDS =	"base-passwd osso-af-startup"
RDEPENDS =	"base-passwd osso-af-startup"

SRC_URI =	"http://stage.maemo.org:80/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.tar.gz"


inherit autotools update-rc.d

FILES_${PN} = "${sysconfdir}/osso-af-init ${sysconfdir}/init.d/"

INITSCRIPT_NAME = "x-server.sh"
INITSCRIPT_PARAMS = "defaults 21"


do_install () {
	install -d ${D}${sysconfdir}/osso-af-init
	install -m 755 ${S}/x-server.defs ${D}/${sysconfdir}/osso-af-init/x-server.defs

	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${S}/x-server.sh ${D}/${sysconfdir}/init.d/x-server.sh
}

pkg_postinst () {
#!/bin/sh

# can't do adduser stuff offline
if [ "x$D" != "x" ]; then
  exit 1
fi

MAEMOUSER=user
MAEMOHOME=/home/user

addgroup "$MAEMOUSER"
mkdir -p $MAEMOHOME/MyDocs || true
adduser --system --home "$MAEMOHOME" --no-create-home --disabled-password --ingroup "$MAEMOUSER" "$MAEMOUSER"
chown -R "$MAEMOUSER"."$MAEMOUSER" "$MAEMOHOME" 2>/dev/null
chgrp "$MAEMOUSER" "$MAEMOHOME" 2>/dev/null
}
