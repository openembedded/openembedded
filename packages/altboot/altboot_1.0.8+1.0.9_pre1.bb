require altboot.inc

DEFAULT_PREFERENCE = "-1"

## Laibsch: The following DEPENDS lines seem broken in light of the fact that
## they have circular dependencies and depend on stuff that is recommended
## elsewhere.  Let's activate them only after further discussion
#RDEPENDS_${PN} = "${PN}-conf kexec-tools ncurses"
#RDEPENDS_${PN}_append_poodle = " kexec-tools"
#RDEPENDS_${PN}-conf = "${PN}"

PR = "r2"

SVN_REV="65"
#TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '-')}"
TAG = '1.0.x'
SRC_URI = "svn://hentges.net/public/altboot/branches/;module=${TAG};rev=${SVN_REV};proto=svn"

LDFLAGS += "-lncurses -lmenu"	

S = "${WORKDIR}/${TAG}/"

do_configure() {
	cat ${S}/init.altboot | sed "s/^VERSION=.*/VERSION=\"${PV}\"/" > ${S}/init.altboot_
	mv ${S}/init.altboot_ ${S}/init.altboot
}

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} ${S}curses_menu/altboot_menu.c -o altboot_menu
}

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
	install -m 0755 ${S}/altboot_menu ${D}/sbin

	install -m 0755 ${S}/altboot-menu/*-* ${D}/etc/altboot-menu

	install -m 0755 ${S}/altboot-menu/Advanced/*-* ${D}/etc/altboot-menu/Advanced

	install -m 0755 ${S}/altboot.rc/*.sh ${D}/etc/altboot.rc
	install -m 0644 ${S}/altboot.rc/*.txt ${D}/etc/altboot.rc
}

pkg_postinst_${PN}() {
	update-alternatives --install /sbin/init init /sbin/init.altboot 55
}

pkg_postrm_${PN}() {
	update-alternatives --remove init /sbin/init.altboot
}

do_rm_work() {
}

PACKAGE_ARCH_${PN} = "all"
PACKAGE_ARCH_${PN}-doc = "all"
PACKAGE_ARCH_${PN}-conf = "${MACHINE}"
PACKAGES = "${PN}-dbg ${PN}-conf ${PN}-doc ${PN}"

FILES_${PN}-conf = "/etc/altboot*.cfg"
