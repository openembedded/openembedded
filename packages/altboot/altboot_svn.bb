require altboot.inc

PV = "1.1.1+wip-${SRCDATE}"
PR = "r4"

SRC_URI = "svn://hentges.net/public/altboot;module=trunk;proto=svn"

do_install() {
	install -d ${D}/sbin
	install -d ${D}/etc/altboot-menu
	install -d ${D}/etc/altboot-menu/Advanced
	install -d ${D}/etc/altboot.rc
	install -d ${D}/usr/share/doc/altboot
	install -d ${D}/usr/share/sounds

	if test -d ${S}/${MACHINE_DIR}
	then
		install -m 0644 ${S}/${MACHINE_DIR}/altboot*.cfg ${D}/etc/
	else
		install -m 0644 ${S}/altboot*.cfg ${D}/etc/
	fi

	install -m 0644 ${S}/beep.raw ${D}/usr/share/sounds
	install -m 0644 ${S}/altboot.func ${D}/etc
	install -m 0644 ${S}/altboot.sbin ${D}/etc
	install -m 0644 ${S}/altbootctl.conf ${D}/etc
	install -m 0755 ${S}/init.altboot ${D}/sbin
	install -m 0755 ${S}/altbootctl ${D}/sbin
	
	ln -s /sbin/init.altboot ${D}/sbin/altboot

	if test -d ${S}/${MACHINE_DIR}/altboot-menu
	then
		install -m 0755 ${S}/${MACHINE_DIR}/altboot-menu/*-* ${D}/etc/altboot-menu
		
		if test -d ${S}/${MACHINE_DIR}/altboot-menu/Advanced
		then
			install -m 0755 ${S}/${MACHINE_DIR}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
		fi
	else
		install -m 0755 ${S}/altboot-menu/*-* ${D}/etc/altboot-menu

		if test -d ${S}/altboot-menu/Advanced
		then		
			install -m 0755 ${S}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced
		fi
	fi
	
	if test -d ${S}/${MACHINE_DIR}/altboot.rc
	then
		install -m 0755 ${S}/${MACHINE_DIR}/altboot.rc/*.sh ${D}/etc/altboot.rc
		install -m 0644 ${S}/${MACHINE_DIR}/altboot.rc/*.txt ${D}/etc/altboot.rc	
	else
		install -m 0755 ${S}/altboot.rc/*.sh ${D}/etc/altboot.rc
		install -m 0644 ${S}/altboot.rc/*.txt ${D}/etc/altboot.rc
	fi
}

do_configure() {
	cat ${S}/init.altboot | sed "s/^VERSION=.*/VERSION=\"${PV}-${PR}\"/" > ${S}/init.altboot_
	mv ${S}/init.altboot_ ${S}/init.altboot
}

pkg_postinst_${PN}() {
	test -L /linuxrc && update-alternatives --install /linuxrc linuxrc /sbin/init.altboot 55
	
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

pkg_postrm_${PN}() {
	test -L /linuxrc && update_alternatives --remove linuxrc /sbin/init.altboot
	
	update-alternatives --remove init /sbin/init.altboot
}

