DESCRIPTION = "Tuxbox common files"
LICENSE = "GPL"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

PN = "tuxbox-common"
PR = "r7"
CVSDATE = "20060628"
PV = "cvs${CVSDATE}"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox/;module=cdk/root/share/tuxbox;method=ext;tag=dreambox;date=${CVSDATE} \
	http://dreamboxupdate.com/download/opendreambox/tuxbox-common-${PR}.tar.gz"

FILES_${PN} = "/"

S = "${WORKDIR}/tuxbox-common-${PR}"

do_install() {

	install -d ${D}/etc/init.d
	install -d ${D}/etc/rcS.d
	install -d ${D}/etc/tuxbox/
	install -m 0644 ${S}/scart.conf ${D}/etc/tuxbox/scart.conf
	install -m 0644 ${WORKDIR}/tuxbox/satellites.xml ${D}/etc/tuxbox/satellites.xml
	install -m 0644 ${WORKDIR}/tuxbox/cables.xml ${D}/etc/tuxbox/cables.xml
	install -m 0644 ${WORKDIR}/tuxbox/terrestrial.xml ${D}/etc/tuxbox/terrestrial.xml
	install -m 0644 ${S}/timezone.xml ${D}/etc/tuxbox/timezone.xml

	cat <<EOF >> ${D}/etc/init.d/tuxbox-hdd.sh
# sleep after 10min
hdparm -S 120 /dev/ide/host0/bus0/target0/lun0/disc
# set UDMA66
hdparm -X66 /dev/ide/host0/bus0/target0/lun0/disc
# accustic management
hdparm -M 128 /dev/ide/host0/bus0/target0/lun0/disc
EOF

	chmod a+x ${D}/etc/init.d/tuxbox-hdd.sh
	ln -sf ../init.d/tuxbox-hdd.sh ${D}/etc/rcS.d/S38tuxbox-hdd.sh
	ln -sf /etc/tuxbox/timezone.xml ${D}/etc/

	install -d ${D}/usr/share/tuxbox

	ln -sf /usr/share ${D}/share

	for i in satellites.xml cables.xml terrestrial.xml; do
		ln -sf /etc/tuxbox/$i ${D}/etc/;
		ln -sf /etc/tuxbox/$i ${D}/usr/share/;
		ln -sf /etc/tuxbox/$i ${D}/usr/share/tuxbox/;
	done;
}
