require altboot.inc

PR = "r4"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '-')}"
SRC_URI = "svn://hentges.net/public/altboot/tags/;module=${TAG};proto=svn"
S = "${WORKDIR}/${TAG}/"

do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc/altboot-menu
	install -d ${D}/etc/altboot-menu/Advanced
	install -d ${D}/etc/altboot.rc
	install -d ${D}/usr/share/doc/altboot
	install -d ${D}/usr/share/sounds

	if test -d ${S}/${MACHINE}
	then
		install -m 0644 ${S}/${MACHINE}/altboot*.cfg ${D}/etc
	else
		install -m 0644 ${S}/altboot*.cfg ${D}/etc
	fi

	install -m 0644 ${S}/beep.raw ${D}/usr/share/sounds
	install -m 0644 ${S}/altboot.func ${D}/etc
	install -m 0755 ${S}/init.altboot ${D}/sbin

	install -m 0755 ${S}/altboot-menu/*-* ${D}/etc/altboot-menu

	install -m 0755 ${S}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced

	install -m 0755 ${S}/altboot.rc/*.sh ${D}/etc/altboot.rc
	install -m 0644 ${S}/altboot.rc/*.txt ${D}/etc/altboot.rc
}

do_configure() {
	cat ${S}/init.altboot | sed "s/^VERSION=.*/VERSION=\"${PV}\"/" > ${S}/init.altboot_
	mv ${S}/init.altboot_ ${S}/init.altboot
}

pkg_postinst_${PN}() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

pkg_postrm_${PN}() {
	update-alternatives --remove init /sbin/init.altboot
}

PACKAGE_ARCH_${PN} = "all"
