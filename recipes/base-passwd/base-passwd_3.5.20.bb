DESCRIPTION = "Base system password/group files."
SECTION = "base"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "\
  ${DEBIAN_MIRROR}/main/b/base-passwd/base-passwd_${PV}.tar.gz \
  file://nobash.patch;patch=1 \
  file://root-home.patch;patch=1 \
  file://mysql.patch;patch=1 \
"
S = "${WORKDIR}/base-passwd"

inherit autotools

do_install_docs () {
	install -d -m 755 \
		${D}${mandir}/man8 ${D}${mandir}/pl/man8
	install -p -m 644 man/update-passwd.8 \
		${D}${mandir}/man8/
	install -p -m 644 man/update-passwd.pl.8 \
		${D}${mandir}/pl/man8/update-passwd.8
	gzip -9 ${D}${mandir}/man8/* \
		${D}${mandir}/pl/man8/*

	install -d -m 755 ${D}${docdir}/${PN}
	install -p -m 644 debian/changelog ${D}${docdir}/${PN}/
	gzip -9 ${D}${docdir}/${PN}/*
	install -p -m 644 README ${D}${docdir}/${PN}/
	install -p -m 644 debian/copyright ${D}${docdir}/${PN}/
}

do_install () {
        do_install_docs

	install -d -m 755 ${D}${sbindir}
	install -p -m 755 update-passwd ${D}${sbindir}/
	install -d -m 755 ${D}${datadir}/base-passwd
	install -p -m 644 passwd.master \
		${D}${datadir}/base-passwd/
	install -p -m 644 group.master \
		${D}${datadir}/base-passwd/
}

do_install_micro () {
	install -d -m 755 ${D}${sysconfdir}
	install -p -m 644 passwd.master ${D}${sysconfdir}/passwd
	install -p -m 644 group.master ${D}${sysconfdir}/group
}

do_install_append_openmn() {
	echo "0:Jn6tcg/qjqvUE:0:0:root:/root:/bin/sh" >>${D}${datadir}/base-passwd/passwd.master
}

FILES_${PN}-doc += "${docdir}"

pkg_postinst () {
	set -e

	if [ ! -e $D${sysconfdir}/passwd ] ; then
		cp $D${datadir}/base-passwd/passwd.master $D${sysconfdir}/passwd
	fi

	if [ ! -e $D${sysconfdir}/group ] ; then
		cp $D${datadir}/base-passwd/group.master $D${sysconfdir}/group
	fi
	exit 0
}
