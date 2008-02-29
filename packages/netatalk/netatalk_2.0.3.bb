SECTION = "net"
PR = "r0"
LICENSE = "GPL"

DEPENDS = "cups db openssl libpam"

SRC_URI = "http://ovh.dl.sourceforge.net/sourceforge/netatalk/netatalk-${PV}.tar.gz \
	   file://netatalk-2.0.3-db43.patch;patch=1 \
	   file://netatalk-2.0.3-newerdb.patch;patch=1 \
	   file://netatalk-2.0.3-xfs.patch;patch=1 \
	   file://init \
		"
INITSCRIPT_NAME = "atalk"
INITSCRIPT_PARAMS = "defaults 65"

inherit autotools update-rc.d

do_configure () {
	autoreconf
	ac_cv_header_rpcsvc_rquota_h=no LDFLAGS="-lpthread -L${STAGING_LIBDIR}" ./configure \
		--build=${BUILD_SYS} \
		--host=${HOST_SYS} \
		--target=${TARGET_SYS} \
		--prefix=${prefix} \
		--with-bdb=${STAGING_DIR_TARGET}${layout_exec_prefix} \
		--with-ssl-dir=${STAGING_DIR_TARGET}${layout_exec_prefix} \
		--without-shadow \
		--sysconfdir=${sysconfdir} \
		--disable-nls \
		--disable-static \
		--with-pam \
		--mandir=${mandir}
	cp ${STAGING_BINDIR_NATIVE}/${TARGET_SYS}-libtool ./${TARGET_SYS}-libtool
}

do_install_append() {
	install -D -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/atalk
}
