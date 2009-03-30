SECTION = "net"
PR = "r1"
LICENSE = "GPL"

DEPENDS = "cups db openssl"

SRC_URI = "http://ovh.dl.sourceforge.net/sourceforge/netatalk/netatalk-${PV}.tar.gz \
	   file://netatalk-2.0.3-db43.patch;patch=1 \
	   file://netatalk-2.0.3-newerdb.patch;patch=1 \
	   file://netatalk-2.0.3-xfs.patch;patch=1 \
	   file://netatalk.conf \
	   file://init"

inherit autotools update-rc.d

INITSCRIPT_NAME = "atalk"
INITSCRIPT_PARAMS = "defaults 65"

PACKAGES = "${PN}-atalkd ${PN}-pap ${PN}-timelord ${PN}-dbg ${PN} ${PN}-doc ${PN}-dev"

RRECOMMENDS_${PN}-atalkd = "kernel-module-appletalk"

FILES_${PN}-atalkd += "${sysconfdir}/netatalk/atalkd.conf \
                       /usr/sbin/atalkd"
FILES_${PN}-pap +=  "/usr/bin/pap \
                     ${sysconfdir}/netatalk/papd.conf \
                     /usr/sbin/papd \
                     /usr/bin/papstatus"
FILES_${PN}-timelord += "/usr/sbin/timelord"
FILES_${PN}-dbg += "${sysconfdir}/netatalk/uams/.debug"
           
EXTRA_OECONF += "ac_cv_path_KRB5_CONFIG=no \
                 ac_cv_header_rpcsvc_rquota_h=no \
                 --with-bdb=${STAGING_DIR_TARGET}${layout_exec_prefix} \
                 --enable-timelord \
                 --without-shadow \
                 --enable-static=no \
                 --disable-srvloc \
                 --without-pam \
                 --with-ssl-dir=${STAGING_DIR_TARGET}${layout_exec_prefix}"
LDFLAGS += "-lpthread -L${STAGING_LIBDIR}"

do_install_append() {
	install -D -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/atalk
	install -D -m 0644 ${WORKDIR}/netatalk.conf ${D}${sysconfdir}/netatalk/netatalk.conf
}
