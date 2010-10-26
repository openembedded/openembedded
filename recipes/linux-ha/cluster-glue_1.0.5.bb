DESCRIPTION = "Cluster Glue is a set of libraries, tools and utilities suitable for \
the Heartbeat/Pacemaker cluster stack. In essence, Glue is everything that \
is not the cluster messaging layer (Heartbeat), nor the cluster resource manager \
(Pacemaker), nor a Resource Agent."

LICENSE = "GPL"
DEPENDS = "libxml2 libtool glib-2.0 bzip2 util-linux-ng"

PR = "r3"

SRC_URI = " \
	http://hg.linux-ha.org/glue/archive/glue-${PV}.tar.bz2;name=tar \
	file://glue-remove-getpid-check.patch \
	file://fix-const-cast.patch \
	file://volatiles \
	"
SRC_URI_append_libc-uclibc = " file://kill-stack-protector.patch"
SRC_URI[tar.md5sum] = "09721e2d2ab3c3fa6696b4347e31721a"
SRC_URI[tar.sha256sum] = "c437a04494850b79c094f7e84d396e917ec09d9a2fdfb7c11f3b420741ea91a2"

inherit autotools

S = "${WORKDIR}/Reusable-Cluster-Components-glue-${PV}"

EXTRA_OECONF = "--with-daemon-user=hacluster --with-daemon-group=haclient"

do_install_append() {
	install -d ${D}${sysconfdir}/default/volatiles
	install -m 0644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/04_cluster-glue
}

pkg_postinst_${PN} () {
	set -e
	grep haclient /etc/group || addgroup haclient
	grep hacluster /etc/passwd || adduser --disabled-password --home=${localstatedir}/lib/heartbeat --ingroup haclient -g "HA cluster" hacluster
	/etc/init.d/populate-volatile.sh update
}

PACKAGES += "\
	 ${PN}-plugin-test \
	 ${PN}-plugin-test-dbg \
	 ${PN}-plugin-test-dev \
	 ${PN}-plugin-stonith2 \
	 ${PN}-plugin-stonith2-dbg \
	 ${PN}-plugin-stonith2-dev \
	 ${PN}-plugin-stonith2-ribcl \
	 ${PN}-plugin-stonith-external \
	 ${PN}-plugin-raexec \
	 ${PN}-plugin-raexec-dbg \
	 ${PN}-plugin-raexec-dev \
	 ${PN}-plugin-interfacemgr \
	 ${PN}-plugin-interfacemgr-dbg \
	 ${PN}-plugin-interfacemgr-dev \
	 ${PN}-lrmtest \
	 "

FILES_${PN} = "/etc/ /usr/lib/lib*.so.* /usr/sbin /usr/share/cluster-glue/*sh /usr/share/cluster-glue/*pl\
	/usr/lib/heartbeat/transient-test.sh \
	/usr/lib/heartbeat/logtest \
	/usr/lib/heartbeat/ipctransientserver \
	/usr/lib/heartbeat/base64_md5_test \
	/usr/lib/heartbeat/ipctest \
	/usr/lib/heartbeat/ipctransientclient \
	/usr/lib/heartbeat/ha_logd \
	/usr/lib/heartbeat/lrmd \
	"

FILES_${PN}-dbg += "/usr/lib/heartbeat/.debug/"

FILES_${PN}-plugin-test = "/usr/lib/heartbeat/plugins/test/test.so"
FILES_${PN}-plugin-test-dev = "/usr/lib/heartbeat/plugins/test/test.*a"
FILES_${PN}-plugin-test-dbg = "/usr/lib/heartbeat/plugins/test/.debug/"
FILES_${PN}-plugin-stonith2 = " \
	/usr/lib/stonith/plugins/xen0-ha-dom0-stonith-helper \
	/usr/lib/stonith/plugins/stonith2/*.so \
	"
FILES_${PN}-plugin-stonith2-ribcl = "/usr/lib/stonith/plugins/stonith2/ribcl.py"
RDEPENDS_${PN}-plugin-stonith2-ribcl += "python"

FILES_${PN}-plugin-stonith2-dbg = "/usr/lib/stonith/plugins/stonith2/.debug/"
FILES_${PN}-plugin-stonith2-dev = "/usr/lib/stonith/plugins/stonith2/*.*a"

FILES_${PN}-plugin-stonith-external = "/usr/lib/stonith/plugins/external/"
FILES_${PN}-plugin-raexec = "/usr/lib/heartbeat/plugins/RAExec/*.so"
FILES_${PN}-plugin-raexec-dev = "/usr/lib/heartbeat/plugins/RAExec/*.*a"
FILES_${PN}-plugin-raexec-dbg = "/usr/lib/heartbeat/plugins/RAExec/.debug/"

FILES_${PN}-plugin-interfacemgr = "/usr/lib/heartbeat/plugins/InterfaceMgr/generic.so"
FILES_${PN}-plugin-interfacemgr-dev = "/usr/lib/heartbeat/plugins/InterfaceMgr/generic.*a"
FILES_${PN}-plugin-interfacemgr-dbg = "/usr/lib/heartbeat/plugins/InterfaceMgr/.debug/"

FILES_${PN}-lrmtest = "/usr/share/cluster-glue/lrmtest/"
