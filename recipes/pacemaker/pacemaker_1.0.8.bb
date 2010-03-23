DESCRIPTION = "Scalable High-Availability cluster resource manager"
LICENSE = "GPL"
DEPENDS = " \
	bzip2 \
	cluster-glue \
	cluster-resource-agents \
	glib-2.0 \
	gnutls \
	libxml2 \
	libxslt \
	ncurses \
	openais \
	python-native \
	util-linux-ng \
	zlib \
	"
RDEPENDS_${PN} += "openais"

SRC_URI = " \
	http://hg.clusterlabs.org/pacemaker/stable-1.0/archive/Pacemaker-${PV}.tar.bz2;name=tar \
	file://pacemaker-remove-native-includes.patch;patch=1 \
	file://pacemaker-dont-use-help2man.patch;patch=1 \
	file://volatiles \
	"
SRC_URI[tar.md5sum] = "088569ca893fe9f2239b68abe2856132"
SRC_URI[tar.sha256sum] = "07e2e5559720890603baac96aa7635ff02f0b33ead592977554e661c6afe7b55"
inherit autotools_stage python-dir

S = "${WORKDIR}/Pacemaker-1-0-Pacemaker-${PV}"

EXTRA_OECONF = "--with-ais --without-heartbeat --disable-fatal-warnings --disable-pretty"

CFLAGS += "-I${STAGING_INCDIR}/heartbeat"

do_install_append() {
	install -d ${D}${sysconfdir}/default/volatiles
	install -m 0644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/06_pacemaker
	find ${D} -name "*.pyo" -exec rm {} \;
	find ${D} -name "*.pyc" -exec rm {} \;
	find ${D} -name "*.py" | xargs sed -i -e "s:${STAGING_BINDIR_NATIVE}:${bindir}:g"
}

pkg_postinst_${PN} () {
	set -e
	grep haclient /etc/group || addgroup haclient
	grep hacluster /etc/passwd || adduser --disabled-password --home=${localstatedir}/lib/heartbeat --ingroup haclient -g "HA cluster" hacluster
	/etc/init.d/populate-volatile.sh update
}

FILES_${PN} += " \
	${libdir}/service_crm.so \
	${libdir}/ocf/resource.d/pacemaker \
	${libdir}/heartbeat/a* \
	${libdir}/heartbeat/c* \
	${libdir}/heartbeat/pengine \
	${libdir}/heartbeat/pingd \
	${libdir}/heartbeat/plugins/RAExec/stonith.so \
	${libdir}/heartbeat/s* \
	"
FILES_${PN}-dbg += "${libdir}/heartbeat/.debug ${libdir}/heartbeat/plugins/RAExec/.debug/ ${libdir}/heartbeat/stonithdtest/.debug/ ${libexecdir}/lcrso/.debug"
FILES_${PN}-dev += "${libdir}/heartbeat/plugins/RAExec/*.la"
FILES_${PN}-static += "${libdir}/heartbeat/plugins/RAExec/*.a"

PACKAGES =+ "${PN}-crm ${PN}-hb2openais ${PN}-haresources2cib ${PN}-tests ${PN}-snmp"
FILES_${PN}-crm = "${sbindir}/crm ${PYTHON_SITEPACKAGES_DIR} ${libdir}/heartbeat/crm_primitive.py "
RDEPENDS_${PN}-crm += "python-core"
FILES_${PN}-hb2openais = "${libdir}/heartbeat/hb2openais.sh ${libdir}/heartbeat/hb2openais-helper.py"
RDEPENDS_${PN}-hb2openais += "python-core"
FILES_${PN}-haresources2cib = "${libdir}/heartbeat/haresources2cib.py"
RDEPENDS_${PN}-haresources2cib += "python-core"
FILES_${PN}-tests = "${datadir}/pacemaker/tests"
RDEPENDS_${PN}-test += "python-core"
FILES_${PN}-snmp = "${datadir}/snmp/mibs/PCMK-MIB.txt"
