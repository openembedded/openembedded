DESCRIPTION = "A tool to calculate Ohm resistor values"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.pellicosystems.com/zaurus/applications/index.html"
APPNAME = "resistorUI"
APPTYPE = "binary"
APPDESKTOP = "${S}"
PR = "r1"

SRC_URI = "http://www.pellicosystems.com/zaurus/applications/resistorUI_1.5.0-0.9_armSRC.zip"
S = "${WORKDIR}/ResistorUI"

inherit opie

do_install () {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 resistorUI.png ${D}${palmtopdir}/pics/

}

SRC_URI[md5sum] = "3ef812023466905883a19a22ead8615c"
SRC_URI[sha256sum] = "467910e5f6b6e137db93a1ccaf668d4146c3dd27dfa0f368b2a20a0a14a23592"
