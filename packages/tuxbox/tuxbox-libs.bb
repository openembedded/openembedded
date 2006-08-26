DESCRIPTION = "tuxbox libs"
DEPENDS = "zlib dreambox-dvbincludes"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"
SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/misc/libs;method=ext \
           file://acinclude.m4"
SRCDATE = "20040928"

PR = "r2"

PACKAGES_DYNAMIC = "libtuxbox-*"

S = "${WORKDIR}/libs"

EXTRA_OECONF = "--with-target=native"

inherit autotools pkgconfig

ALLOW_EMPTY = 1
FILES_${PN} = ""
FILES_${PN}-dev = "/usr/include/tuxbox"

do_configure_prepend() {
	install ${WORKDIR}/acinclude.m4 ${S}/acinclude.m4
}

python populate_packages_prepend () {
	tuxbox_libdir = bb.data.expand('${libdir}', d)

	do_split_packages(d, tuxbox_libdir, '^libtuxbox-(.*)\.so.*$', 'libtuxbox-%s', 'libtuxbox-%s')
#	do_split_packages(d, tuxbox_libdir, '^libtuxbox-(.*)\.l?a$', 'libtuxbox-%s-dev', 'libtuxbox-%s (development files)')
}

do_stage() {
	install -d ${STAGING_INCDIR}/tuxbox
	install -d ${STAGING_INCDIR}/tuxbox/connection
	install -d ${STAGING_INCDIR}/tuxbox/xmltree
	install -d ${STAGING_INCDIR}/tuxbox/mpegtools
  install -m 0644 ${S}/libconfigfile/configfile.h ${STAGING_INCDIR}/tuxbox/
  install -m 0644 ${S}/libconnection/basicclient.h ${STAGING_INCDIR}/tuxbox/connection/
  install -m 0644 ${S}/libconnection/basicmessage.h ${STAGING_INCDIR}/tuxbox/connection/
  install -m 0644 ${S}/libconnection/basicserver.h ${STAGING_INCDIR}/tuxbox/connection/
  install -m 0644 ${S}/libconnection/basicsocket.h ${STAGING_INCDIR}/tuxbox/connection/
  install -m 0644 ${S}/libconnection/messagetools.h  ${STAGING_INCDIR}/tuxbox/connection/
  install -m 0644 ${S}/libcramfs/libcramfs.h ${STAGING_INCDIR}/tuxbox/
  install -m 0644 ${S}/libeventserver/eventserver.h ${STAGING_INCDIR}/tuxbox/
  install -m 0644 ${S}/libmd5sum/libmd5sum.h ${STAGING_INCDIR}/tuxbox/
  install -m 0644 ${S}/libmpegtools/ctools.h ${STAGING_INCDIR}/tuxbox/mpegtools/
  install -m 0644 ${S}/libmpegtools/remux.h ${STAGING_INCDIR}/tuxbox/mpegtools/
  install -m 0644 ${S}/libmpegtools/ringbuffy.h ${STAGING_INCDIR}/tuxbox/mpegtools/
  install -m 0644 ${S}/libmpegtools/transform.h ${STAGING_INCDIR}/tuxbox/mpegtools/
  install -m 0644 ${S}/libnet/libnet.h ${STAGING_INCDIR}/tuxbox/
  install -m 0644 ${S}/libnet/network_interfaces.h ${STAGING_INCDIR}/tuxbox/
  install -m 0644 ${S}/libucodes/libucodes.h ${STAGING_INCDIR}/tuxbox/
  install -m 0644 ${S}/libxmltree/hashtab.h  ${STAGING_INCDIR}/tuxbox/xmltree/
  install -m 0644 ${S}/libxmltree/xmlparse.h ${STAGING_INCDIR}/tuxbox/xmltree/
  install -m 0644 ${S}/libxmltree/xmlrole.h  ${STAGING_INCDIR}/tuxbox/xmltree/
  install -m 0644 ${S}/libxmltree/xmltimpl.h ${STAGING_INCDIR}/tuxbox/xmltree/
  install -m 0644 ${S}/libxmltree/xmltok.h   ${STAGING_INCDIR}/tuxbox/xmltree/
  install -m 0644 ${S}/libxmltree/xmltree.h  ${STAGING_INCDIR}/tuxbox/xmltree/

	for d in configfile connection cramfs eventserver md5sum mpegtools net ucodes xmltree; do
		oe_libinstall -C lib$d -so libtuxbox-$d ${STAGING_LIBDIR}
	done;
}

