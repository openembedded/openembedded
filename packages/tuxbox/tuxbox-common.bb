DESCRIPTION = "Tuxbox common files"
LICENSE = "GPL"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

PN = "tuxbox-common"
PR = "r8"
SRCDATE = "20060628"
PV = "cvs${SRCDATE}"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox/;module=cdk/root/share/tuxbox;method=ext;tag=dreambox;date=${SRCDATE} \
	http://dreamboxupdate.com/download/opendreambox/tuxbox-common-${PR}.tar.gz"

FILES_${PN} = "/"

S = "${WORKDIR}/tuxbox-common-${PR}"

do_install() {

	install -d ${D}/etc/init.d
	install -d ${D}/etc/rcS.d
	install -d ${D}/etc/tuxbox/
	install -m 0644 ${S}/scart.conf ${D}/etc/tuxbox/scart.conf
	install -m 0644 ${WORKDIR}/tuxbox/satellites.xml ${D}/etc/tuxbox/satellites.xml
	install -m 0644 ${S}/cables.xml ${D}/etc/tuxbox/cables.xml
	install -m 0644 ${WORKDIR}/tuxbox/terrestrial.xml ${D}/etc/tuxbox/terrestrial.xml
	install -m 0644 ${S}/timezone.xml ${D}/etc/tuxbox/timezone.xml

	ln -sf /etc/tuxbox/timezone.xml ${D}/etc/

	install -d ${D}/usr/share/tuxbox

	ln -sf /usr/share ${D}/share

	for i in satellites.xml cables.xml terrestrial.xml; do
		ln -sf /etc/tuxbox/$i ${D}/etc/;
		ln -sf /etc/tuxbox/$i ${D}/usr/share/;
		ln -sf /etc/tuxbox/$i ${D}/usr/share/tuxbox/;
	done;
}
